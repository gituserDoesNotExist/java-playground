package de.any.crawl;

import java.util.Arrays;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class XmlBeanNodeBuilder {

	private static XmlBeanNodeBuilder self;
	private Element parent;

	private XmlBeanNodeBuilder(Element parentTag) {
		this.parent = parentTag;
	};

	public static XmlBeanNodeBuilder aBeanTagWithId(String id) {
		Element parentTag = new Element("bean");
		parentTag.setAttribute(new Attribute("id", id));
		self = new XmlBeanNodeBuilder(parentTag);
		return self;
	}

	public XmlBeanNodeBuilder addPropertyTagWithNameAndRefAttribute(String nameAttribute, String refAttribute) {
		Element propertyTag = new Element("property", parent.getNamespace());
		propertyTag.setAttributes(Arrays.asList(new Attribute("name", nameAttribute), new Attribute("ref", refAttribute)));
		parent.addContent(propertyTag);
		return self;
	}

	public Element build() {
		return parent;
	}

}
