package de.any.crawl;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.jdom2.Element;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class SpringXmlBeanModelTest {

	private SpringXmlBeanModel model;

	@Before
	public void setUp() {
		URL resource1 = getClass().getResource("test-spring.xml");
		URL resource2 = getClass().getResource("test-spring_EISIntegration.xml");
		List<URL> xmlFiles = Arrays.asList(resource1, resource2);
		model = new SpringXmlBeanModel(xmlFiles, new SaxXmlParser());
	}

	@Test
	public void testFindNodeForBeanId() throws Exception {
		Optional<Element> result = model.findNodeForBeanId("aktualisierenSoapClient");

		assertTrue(result.isPresent());
	}

	@Test
	public void testFindAllBeansInNode() {
		Element parentNode = model.findNodeForBeanId("aktualisierenSoapClient").get();
		List<String> result = model.findAllBeansInNode(parentNode);

		assertThat(result, containsInAnyOrder("webServiceTemplate", "otherBean"));
	}

}
