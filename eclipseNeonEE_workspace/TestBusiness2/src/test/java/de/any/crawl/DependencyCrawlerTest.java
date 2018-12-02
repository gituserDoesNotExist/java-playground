package de.any.crawl;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Controller;

import de.svi.svis3g.any.crawl.test.dependency.crawler.ControllerClass;

@Controller
public class DependencyCrawlerTest {

	private static final String BASE_PACKAGE = "de.svi.svis3g.any.crawl.test";
	private DependencyCrawler crawler;

	@Before
	public void setUp() {
		ClasspathScanner classpathScanner = new ClasspathScanner(new SVIS3GBusinessIntegrationTierClassFilter(), new TestXmlFileFilter());
		List<Class<?>> qualifiedClassesInClasspath = classpathScanner.findAllClassesInPackageRecursively(BASE_PACKAGE);
		List<URL> qualifiedXmlFilesInClasspath = classpathScanner.findXmlFilesInBaseFolderRecursively("META-INF");

		assertThat(qualifiedClassesInClasspath.size(), IsEqual.equalTo(6));
		assertThat(qualifiedXmlFilesInClasspath.size(), IsEqual.equalTo(2));

		ClasspathModel classpathModel = new ClasspathModel(qualifiedClassesInClasspath);
		SpringXmlBeanModel springXmlBeanModel = new SpringXmlBeanModel(qualifiedXmlFilesInClasspath, new SaxXmlParser());

		XmlCrawler xmlCrawler = new SpringXmlBeanCrawler(springXmlBeanModel);
		crawler = new DependencyCrawler(classpathModel, xmlCrawler);
	}

	@Test
	public void collectRequiredDependenciesRecursively_FindAllClasses_AutowiredByField_ClassHasStereotypeAnnotation() {
		RequiredBeanContainer result = crawler.collectRequiredDependenciesRecursively(ControllerClass.class);

		List<String> collect = result.getRequiredBeans().stream().map(RequiredBean::getBeanId).collect(Collectors.toList());

		assertThat(collect, IsCollectionContaining.hasItems("controllerClass", "serviceClass", "repositoryClass"));
	}

	@Test
	public void collectRequiredDependenciesRecursively_FindAllClasses_AutowiredByConstructor_ClassHasStereotypeAnnotation() {
		RequiredBeanContainer result = crawler.collectRequiredDependenciesRecursively(ControllerClass.class);

		List<String> collect = result.getRequiredBeans().stream().map(RequiredBean::getBeanId).collect(Collectors.toList());

		assertThat(collect, hasItems("mapperClass"));
	}

	@Test
	public void collectRequiredDependenciesRecursively_FindAllClasses_AutowiredByField_ClassDefinedInSpringXML() {
		RequiredBeanContainer result = crawler.collectRequiredDependenciesRecursively(ControllerClass.class);

		List<String> collect = result.getRequiredBeans().stream().map(RequiredBean::getBeanId).collect(Collectors.toList());
		assertThat(collect, IsCollectionContaining.hasItems("classDefinedInXml", "otherClassDefinedInXml", "otherClassDefinedInXml"));
	}

	@Test
	public void collectRequiredDependenciesRecursively_FindsAll_NoDuplicates() {
		RequiredBeanContainer result = crawler.collectRequiredDependenciesRecursively(ControllerClass.class);

		List<String> collect = result.getRequiredBeans().stream().map(RequiredBean::getBeanId).collect(Collectors.toList());
		assertThat(collect, IsIterableContainingInAnyOrder.containsInAnyOrder("controllerClass", "serviceClass", "repositoryClass", "classDefinedInXml",
				"otherClassDefinedInXml", "mapperClass"));
	}

}
