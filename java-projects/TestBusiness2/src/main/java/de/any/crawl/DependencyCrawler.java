/*
 * Created on 28.08.2018
 *
 * Dimensions - Versionierung
 * $Workfile: %PM% $
 * $Revision: %PR% $
 * $Date: %Date% $
 * $Author: %Author% $
 * 
 * (c) Copyright SV Informatik GmbH 2010
 */

package de.any.crawl;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public class DependencyCrawler {

	private static final Logger LOGGER = Logger.getLogger(DependencyCrawler.class);

	private ClasspathModel classpathModel;
	private XmlCrawler xmlCrawler;

	@SuppressWarnings("javadoc")
	public DependencyCrawler(ClasspathModel classpathModel, XmlCrawler xmlCrawler) {
		this.classpathModel = classpathModel;
		this.xmlCrawler = xmlCrawler;
	}

	@SuppressWarnings("javadoc")
	public RequiredBeanContainer collectRequiredDependenciesRecursively(Class<?> clazz) {
		RequiredBeanContainer requiredBeans = new RequiredBeanContainer();
		requiredBeans.addIfNotPresent(new AnnotationRequiredBean(clazz));

		collectRequiredBeans(clazz, requiredBeans);
		return requiredBeans;
	}

	private void collectRequiredBeans(Class<?> clazz, RequiredBeanContainer requiredBeans) {
		List<String> beansDefinedInSpringXml = findAllBeansDefinedInSpringXml(clazz);
		List<Class<?>> beansWithStereotypeAnnotation = findAllBeansWithStereotypeAnnotation(clazz);
		for (String beanId : beansDefinedInSpringXml) {
			LOGGER.debug("add bean definition for " + beanId);
			requiredBeans.addAllIfNotPresent(xmlCrawler.collectAllRequiredBeanDefinitionsForBeanTagWithId(beanId));
		}
		for (Class<?> clz : beansWithStereotypeAnnotation) {
			LOGGER.debug("add bean definition for " + clz.getName());
			requiredBeans.addIfNotPresent(new AnnotationRequiredBean(clz));
			collectRequiredBeans(clz, requiredBeans);
		}
	}

	private List<String> findAllBeansDefinedInSpringXml(Class<?> clazz) {
		List<Field> autowiredFields = getAutowiredFields(clazz);
		return autowiredFields.stream()//
				.filter(this::isBeanDefinedInSpringXml)//
				.map(this::extractBeanId).collect(Collectors.toList());
	}

	private String extractBeanId(Field field) {
		if (hasFieldQualifierAnnotation(field)) {
			return getValueOfQualifierAnnotation(field).value();
		}
		return field.getName();
	}

	private List<Class<?>> findAllBeansWithStereotypeAnnotation(Class<?> clazz) {
		List<Class<?>> classesAutowiredByField = getAutowiredFields(clazz).stream().map(Field::getType).collect(Collectors.toList());
		List<Class<?>> classesAutowiredByConstructor = getAutowiredConstructorParameters(clazz);
		List<Class<?>> autowiredTypes = concat(classesAutowiredByField.stream(), classesAutowiredByConstructor.stream()).collect(toList());
		return autowiredTypes.stream()//
				.map(this::findImplementingClassForTypeOrThrow)//
				.filter(this::hasClassComponentTypeAnnotation).collect(Collectors.toList());
	}

	private List<Field> getAutowiredFields(Class<?> clazz) {
		return Arrays.asList(clazz.getDeclaredFields()).stream().filter(this::hasFieldAutowiredAnnotation).collect(Collectors.toList());
	}

	private List<Class<?>> getAutowiredConstructorParameters(Class<?> clazz) {
		List<Constructor<?>> constructors = Arrays.asList(clazz.getConstructors());
		return constructors.stream()//
				.filter(this::hasConstructorAutowiredAnnotation)//
				.flatMap(this::getConstructorArgumentsAsStream).collect(Collectors.toList());
	}

	private Stream<Class<?>> getConstructorArgumentsAsStream(Constructor<?> constructor) {
		return Arrays.asList(constructor.getParameterTypes()).stream();
	}

	private boolean isBeanDefinedInSpringXml(Field field) {
		Class<?> implementingClass = findImplementingClassForTypeOrThrow(field.getType());
		return !hasClassComponentTypeAnnotation(implementingClass) || hasFieldQualifierAnnotation(field);
	}

	private boolean hasClassComponentTypeAnnotation(Class<?> clazz) {
		boolean annotationPresent = false;
		annotationPresent |= clazz.isAnnotationPresent(Controller.class);
		annotationPresent |= clazz.isAnnotationPresent(Service.class);
		annotationPresent |= clazz.isAnnotationPresent(Repository.class);
		annotationPresent |= clazz.isAnnotationPresent(Component.class);
		return annotationPresent;
	}

	private boolean hasConstructorAutowiredAnnotation(Constructor<?> constructors) {
		return constructors.isAnnotationPresent(Autowired.class);
	}

	private boolean hasFieldQualifierAnnotation(Field field) {
		return field.isAnnotationPresent(Qualifier.class);
	}

	private boolean hasFieldAutowiredAnnotation(Field field) {
		return field.isAnnotationPresent(Autowired.class);
	}

	private Qualifier getValueOfQualifierAnnotation(Field field) {
		return field.getAnnotation(Qualifier.class);
	}

	private Class<?> findImplementingClassForTypeOrThrow(Class<?> type) {
		return classpathModel.findImplementationClassForType(type).orElseThrow(() -> new RuntimeException("Kein Klasse gefunden für" + type));
	}

}
