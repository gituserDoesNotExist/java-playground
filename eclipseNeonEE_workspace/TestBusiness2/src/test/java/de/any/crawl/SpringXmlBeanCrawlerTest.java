package de.any.crawl;

import static org.junit.Assert.assertThat;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class SpringXmlBeanCrawlerTest {

	private SpringXmlBeanCrawler crawler;

	@Before
	public void setUp() {
		URL resource = getClass().getResource("test-spring.xml");
		URL resource2 = getClass().getResource("test-spring_EISIntegration.xml");
		List<URL> asList = Arrays.asList(resource, resource2);
		SpringXmlBeanModel model = new SpringXmlBeanModel(asList, new SaxXmlParser());
		crawler = new SpringXmlBeanCrawler(model);
	}

	@Test
	public void findAllBeanNamesForBeanTagWithId() {
		List<RequiredBean> result = crawler.collectAllRequiredBeanDefinitionsForBeanTagWithId("aktualisierenSoapClient");

		assertThat(result.stream().map(RequiredBean::getBeanId).collect(Collectors.toList()),
				IsIterableContainingInAnyOrder.containsInAnyOrder("aktualisierenSoapClient", "webServiceTemplate", "otherBean", "adbmarshaller"));
	}
}
