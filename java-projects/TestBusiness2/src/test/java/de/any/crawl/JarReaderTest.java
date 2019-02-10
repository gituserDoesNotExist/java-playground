package de.any.crawl;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

public class JarReaderTest {

	private static final int FILES_IN_TEST_JAR = 15;
	private static final String PATH_TO_JAR_FILE = "C:\\Users\\Manfred\\JavaShit\\eclipseNeonEE_workspace\\test-data-for-crawler\\target\\test-data-for-crawler-0.0.1-SNAPSHOT.jar";
	private JarReader reader = new JarReader();

	@Test
	@SuppressWarnings("javadoc")
	public void findXmlFiles() {
		List<File> result = reader.findXmlFiles(PATH_TO_JAR_FILE);

		assertThat(result.stream().map(File::getName).collect(Collectors.toList()), containsInAnyOrder("JarTestApplicationContext.xml", "pom.xml"));
	}

	@Test
	@SuppressWarnings("javadoc")
	public void getJarContent() {
		List<String> result = reader.readJarContent(PATH_TO_JAR_FILE);

		assertThat(result, IsCollectionContaining.hasItems(PATH_TO_JAR_FILE + "\\META-INF/spring-global/JarTestApplicationContext.xml",
				PATH_TO_JAR_FILE + "\\META-INF/maven/de.svi.svis3g/test-data-for-crawler/pom.xml"));

		assertThat(result.size(), IsEqual.equalTo(FILES_IN_TEST_JAR));
	}
}
