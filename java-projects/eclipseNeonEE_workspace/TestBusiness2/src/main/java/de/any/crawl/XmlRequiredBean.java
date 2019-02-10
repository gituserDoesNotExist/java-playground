/*
 * Created on 29.08.2018
 *
 * Dimensions - Versionierung
 * $Workfile: %PM% $
 * $Revision: %PR% $
 * $Date: %Date% $
 * $Author: %Author% $
 * 
 * (c) Copyright SV Informatik GmbH 2010
 */

package de.any.crawl;

import org.jdom2.Element;

public class XmlRequiredBean extends RequiredBean {

	private Element beanNode;

	protected XmlRequiredBean(String beanId) {
		super(beanId);
	}

	/**
	 * @param node
	 */
	public XmlRequiredBean(Element node) {
		this(node.getAttributeValue("id"));
		this.beanNode = node;
	}

	@Override
	public Element getDescriptionForXmlConfiguration() {
		return beanNode;
	}

}
