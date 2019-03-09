package de.any.crawl;

import static org.junit.Assert.assertThat;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

public class ClasspathScannerTest {

	private static final String PATH_XML_FILE_IN_DIRECTORY = "C:\\Users\\Manfred\\JavaShit\\eclipseNeonEE_workspace\\TestBusiness2\\target\\classes\\META-INF";
	private static final String PATH_XML_FILE_IN_JAR = "file:\\C:\\Users\\Manfred\\JavaShit\\eclipseNeonEE_workspace\\test-data-for-crawler\\target\\test-data-for-crawler-0.0.1-SNAPSHOT.jar!\\META-INF";

	private static final String PACKAGE_NAME = "de.svi.svis3g.test.crawl";

	private ClasspathScanner scanner;

	@Before
	public void setUp() {
		SVIS3GBusinessIntegrationTierClassFilter classFilter = new SVIS3GBusinessIntegrationTierClassFilter();
		QualifiedFileFilter xmlFileFilter = new TestXmlFileFilter();
		scanner = new ClasspathScanner(classFilter, xmlFileFilter);
	}

	@Test
	public void testName() {
		String[] property = System.getProperty("java.class.path").split(File.pathSeparator);
		for (String string : property) {
			System.out.println(string);
		}
	}

	@Test
	public void findAllClassesRecursively() {
		List<Class<?>> result = scanner.findAllClassesInPackageRecursively(PACKAGE_NAME);

		assertThat(result.stream().map(Class::getName).collect(Collectors.toList()),
				IsIterableContainingInAnyOrder.containsInAnyOrder("de.svi.svis3g.test.crawl.FirstClass", //
						"de.svi.svis3g.test.crawl.SecondClass", "de.svi.svis3g.test.crawl.ClassInJar"));
	}

	@Test
	@SuppressWarnings("javadoc")
	public void findAllFoldersContainingPathName() {
		List<File> result = scanner.findAllFoldersContainingPathName("META-INF");

		assertThat(result.stream().map(File::getPath).collect(Collectors.toList()),
				IsCollectionContaining.hasItems(PATH_XML_FILE_IN_DIRECTORY, PATH_XML_FILE_IN_JAR));
	}

	@Test
	@SuppressWarnings("javadoc")
	public void findXmlFiles() {
		List<URL> result = scanner.findXmlFilesInBaseFolderRecursively("META-INF");

		assertThat(result.size(), IsEqual.equalTo(2));
		assertThat(result.stream().map(this::convertUrlToFilename).collect(Collectors.toList()),
				IsIterableContainingInAnyOrder.containsInAnyOrder("InFolder_ApplicationContext.xml", "JarTestApplicationContext.xml"));
	}

	private String convertUrlToFilename(URL url) {
		return new File(url.getFile()).getName();
	}

}
