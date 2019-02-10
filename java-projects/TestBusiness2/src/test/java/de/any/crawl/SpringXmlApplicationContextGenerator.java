package de.any.crawl;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class SpringXmlApplicationContextGenerator {

	private static final String XMLNS = "http://www.springframework.org/schema/beans";

	private Element rootElement;
	private Document document;

	public SpringXmlApplicationContextGenerator() {
		this.rootElement = generateRootElement();
		this.document = new Document(rootElement);
	}

	private Element generateRootElement() {
		Namespace namespace = Namespace.getNamespace(XMLNS);
		return new Element("beans", namespace);
	}

	public void addRequiredBeans(List<RequiredBean> requiredBeans) {
		requiredBeans.stream().map(this::addNamespaceToElemElementWithParentNamespace).forEach(rootElement::addContent);
	}

	private Element addNamespaceToElemElementWithParentNamespace(RequiredBean requiredBean) {
		Element element = requiredBean.getDescriptionForXmlConfiguration();
		element.setNamespace(rootElement.getNamespace());
		return element;
	}

	public String generate() {
		XMLOutputter xmlOutputter = new XMLOutputter();
		xmlOutputter.setFormat(Format.getPrettyFormat());
		return xmlOutputter.outputString(document);
	}

}
