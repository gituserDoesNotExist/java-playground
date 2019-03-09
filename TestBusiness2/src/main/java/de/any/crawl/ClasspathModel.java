/*
 * Created on 29.08.2018
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Zweck dieser Klasse: <br>
 * (Hier Zweck eintragen - bis zu 2 Zeilen).
 * <p>
 * Angewandte Pattern: <br>
 * (Hier Pattern nennen)
 * <p>
 * Zusammenhaenge / Partnerklassen <br>
 * (Hier erlaeutern)
 * <p>
 * Abgrenzung zu anderen Klassen <br>
 * (Hier erlaeutern)
 * <p>
 * Weitere Informationen <br>
 * (Hier auffuehren)
 * 
 * @author N0008244
 */
public class ClasspathModel {

	private static final String SUBSTRING_ONLINE_IMPLEMENTATION = "Online";

	private List<Class<?>> classesInClasspath;

	@SuppressWarnings("javadoc")
	public ClasspathModel(List<Class<?>> classes) {
		this.classesInClasspath = classes;
	}

	@SuppressWarnings("javadoc")
	public Optional<Class<?>> findImplementationClassForType(Class<?> type) {
		if (!type.isInterface()) {
			return Optional.of(type);
		}
		return findClassImplementingInterface(type);
	}

	// @SuppressWarnings("javadoc")
	// public Optional<Class<?>> findImplementationClassOfField(Field field) {
	// return findImplementationClassForType(field.getType());
	// }

	@SuppressWarnings("javadoc")
	public Optional<Class<?>> findClassImplementingInterface(Class<?> interfaze) {
		List<Class<?>> implementingClasses = findImplementingClasses(interfaze);
		if (isSingleImplementingClass(implementingClasses)) {
			return Optional.ofNullable(implementingClasses.get(0));
		}
		return implementingClasses.stream().filter(clz -> clz.getSimpleName().contains(SUBSTRING_ONLINE_IMPLEMENTATION)).findFirst();
	}

	private List<Class<?>> findImplementingClasses(Class<?> interfaze) {
		return classesInClasspath.stream().filter(this::isValidClass).filter(clazz -> isClazzImplementingInterface(clazz, interfaze))
				.collect(Collectors.toList());
	}

	private boolean isValidClass(Class<?> clazz) {
		return !clazz.isInterface() && !clazz.getSimpleName().isEmpty();
	}

	private boolean isClazzImplementingInterface(Class<?> clazz, Class<?> interfaze) {
		return interfaze.isAssignableFrom(clazz);
	}

	private boolean isSingleImplementingClass(List<Class<?>> implementingClasses) {
		return implementingClasses.size() == 1;
	}

}
