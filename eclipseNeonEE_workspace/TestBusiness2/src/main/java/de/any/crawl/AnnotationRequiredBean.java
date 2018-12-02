/*
 * Created on 28.08.2018
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

import static java.beans.Introspector.decapitalize;

import org.jdom2.Attribute;
import org.jdom2.Element;

/**
 * Zweck dieser Klasse: <br>
 * (Hier Zweck eintragen - bis zu 2 Zeilen).
 * <p>
 * Angewandte Pattern: <br>
 * (Hier Pattern nennen)
 * <p>
 * Zusammenhaenge / Partnerklassen <br>
 * (Hier erlaeutern)
 * <p>
 * Abgrenzung zu anderen Klassen <br>
 * (Hier erlaeutern)
 * <p>
 * Weitere Informationen <br>
 * (Hier auffuehren)
 * 
 * @author N0008244
 */
public class AnnotationRequiredBean extends RequiredBean {

	private String fullyQualifiedName;

	protected AnnotationRequiredBean(String beanId) {
		super(beanId);
	}

	/**
	 * @param clazz
	 */
	public AnnotationRequiredBean(Class<?> clazz) {
		this(decapitalize(clazz.getSimpleName()));
		this.fullyQualifiedName = clazz.getName();
	}

	/**
	 * @return the fullyQualifiedName
	 */
	public String getFullyQualifiedName() {
		return fullyQualifiedName;
	}

	@Override
	public Element getDescriptionForXmlConfiguration() {
		Element beanTag = new Element("bean");
		beanTag.setAttribute(new Attribute("class", fullyQualifiedName));
		return beanTag;
	}
}
