package de.any.crawl;

import org.jdom2.Element;

public class TestRequiredBean extends RequiredBean {

	public TestRequiredBean(String beanId) {
		super(beanId);
	}

	@Override
	public Element getDescriptionForXmlConfiguration() {
		return new Element("element");
	}

}
