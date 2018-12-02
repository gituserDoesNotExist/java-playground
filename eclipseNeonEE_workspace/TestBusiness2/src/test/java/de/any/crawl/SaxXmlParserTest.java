package de.any.crawl;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("javadoc")
public class SaxXmlParserTest {

	private static final String NAME_OTHER_TAG = "other";
	private static final String NAME_BEAN_TAG = "bean";
	private static final String NAME_PROPERTY_TAG = "property";

	private XmlParser xmlParser = new SaxXmlParser();

	@Rule
	public ExpectedException excpectedException = ExpectedException.none();

	@Test
	public void getRootElementFromFile_Success() {
		URL resource = getClass().getResource("test-spring.xml");
		Element result = xmlParser.getRootElementOfXmlFile(resource);

		assertThat(result.getName(), equalTo("beans"));
	}

	@Test
	public void testExtractTagsFromXmlFile_Success() {
		URL resource = getClass().getResource("test-spring.xml");
		List<Element> result = xmlParser.extractTagsFromXmlFile(resource, NAME_BEAN_TAG);

		assertThat(result.stream().map(element -> element.getAttributeValue("id")).collect(Collectors.toList()),
				containsInAnyOrder("speichernSoapClient", "aktualisierenSoapClient", "otherBean"));
	}

	@Test
	public void testExtractTagsFromXmlFile_FileIsInJar_Success() throws JDOMException, IOException {
		URL file = getClass().getResource("/META-INF/spring-global/JarTestApplicationContext.xml");

		List<Element> result = xmlParser.extractTagsFromXmlFile(file, NAME_BEAN_TAG);

		assertThat(result.stream().map(element -> element.getAttributeValue("id")).collect(Collectors.toList()), containsInAnyOrder("anyId"));
	}

	@Test
	public void testExtractTagsFromXmlFile_InvalidTagname_ReturnsEmptyList() {
		URL resource = getClass().getResource("test-spring.xml");
		List<Element> result = xmlParser.extractTagsFromXmlFile(resource, "invalid");

		assertTrue(result.isEmpty());
	}

	@Test
	public void testExtractTagsFromXmlFile_InvalidFileName_ThrowsException() throws MalformedURLException {
		excpectedException.expect(RuntimeException.class);
		excpectedException.expectMessage("unable to load file");

		xmlParser.extractTagsFromXmlFile(new File("path/invalid.xml").toURI().toURL(), "invalid");
	}

	@Test
	public void testHasParentDescendantTagsWithName_HasChildTagNamedProperty_Success() {
		Element beanNode = XmlBeanNodeBuilder.aBeanTagWithId("myBean").addPropertyTagWithNameAndRefAttribute("field", "otherBean").build();

		assertTrue(xmlParser.hasParentDescendantTagsWithName(beanNode, "property"));
	}

	public void testHasParentDescendantTagsWithName_NoChildTags_ReturnsFalse() {
		Element beanNode = XmlBeanNodeBuilder.aBeanTagWithId("myBean").build();

		assertFalse(xmlParser.hasParentDescendantTagsWithName(beanNode, NAME_PROPERTY_TAG));
	}

	public void testHasParentDescendantTagsWithName_ChildTagHasOtherName_ReturnsFalse() {
		assertFalse(xmlParser.hasParentDescendantTagsWithName(new Element(NAME_BEAN_TAG), NAME_PROPERTY_TAG));
	}

	@Test
	public void testFindDescendantTagsInParentTagByName_Success() {
		Element beanTag = XmlBeanNodeBuilder.aBeanTagWithId("beanId")//
				.addPropertyTagWithNameAndRefAttribute("field", "otherBean")//
				.addPropertyTagWithNameAndRefAttribute("field2", "otherBean2").build();
		beanTag.addContent(new Element(NAME_OTHER_TAG));

		List<Element> result = xmlParser.findDescendantTagsInParentTagByName(beanTag, NAME_PROPERTY_TAG);

		assertThat(result.stream().map(el -> el.getAttributeValue("ref")).collect(Collectors.toList()), containsInAnyOrder("otherBean", "otherBean2"));
	}

}
