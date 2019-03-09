package de.any.crawl;

import static de.any.crawl.XmlBeanNodeBuilder.aBeanTagWithId;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.jdom2.Element;
import org.jdom2.Namespace;
import org.junit.Before;
import org.junit.Test;

public class SpringXmlApplicationContextGeneratorTest {

	SpringXmlApplicationContextGenerator generator;

	@Before
	public void setUp() {
		RequiredBean annotationRequiredBean = new AnnotationRequiredBean(SpringXmlApplicationContextGeneratorTest.class);
		RequiredBean xmlBean = new XmlRequiredBean(aBeanTagWithId("beanId").addPropertyTagWithNameAndRefAttribute("anyField", "otherBeanId").build());
		generator = new SpringXmlApplicationContextGenerator();
	}

	@Test
	public void generate_NoElementsAdded_CreatesDocumentStub() {
		String result = generator.generate();

		assertTrue(result.contains("<beans xmlns=\"http://www.springframework.org/schema/beans\" />"));
	}

	@Test
	public void generate_AddAnnotationRequiredBean_Success() {
		generator.addRequiredBeans(Arrays.asList(new AnnotationRequiredBean(SpringXmlApplicationContextGeneratorTest.class)));

		String result = generator.generate();

		assertTrue(result.contains("<bean class=\"de.any.crawl.SpringXmlApplicationContextGeneratorTest\" />"));
	}

	@Test
	public void generate_XmlRequiredBean_Success() {
		XmlRequiredBean xmlBean = new XmlRequiredBean(aBeanTagWithId("beanId").addPropertyTagWithNameAndRefAttribute("anyField", "otherBeanId").build());
		Element property = xmlBean.getDescriptionForXmlConfiguration().getChild("property");
		property.setNamespace(Namespace.getNamespace("http://www.springframework.org/schema/beans"));
		generator.addRequiredBeans(Arrays.asList(xmlBean));

		String result = generator.generate();

		assertTrue(result.contains("<property name=\"anyField\" ref=\"otherBeanId\" />"));
	}

}
