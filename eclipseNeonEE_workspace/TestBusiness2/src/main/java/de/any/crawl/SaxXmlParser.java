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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;

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
public class SaxXmlParser implements XmlParser {

	@Override
	public Element getRootElementOfXmlFile(URL resource) {
		return tryBuildingDocument(resource).getRootElement();
	}

	@Override
	public List<Element> extractTagsFromXmlFile(URL resource, String tagName) {
		Element rootElement = getRootElementOfXmlFile(resource);
		return findDescendantTagsInParentTagByName(rootElement, tagName);
	}

	@Override
	public boolean hasParentDescendantTagsWithName(Element parentTag, String name) {
		List<Element> elements = findDescendantTagsInParentTagByName(parentTag, name);
		return !elements.isEmpty();
	}

	@Override
	public List<Element> findDescendantTagsInParentTagByName(Element parentTag, String nameDescendantTag) {
		IteratorIterable<Element> descendants = parentTag.getDescendants(new ElementFilter(nameDescendantTag));
		return convertIterableIteratorToList(descendants);
	}

	private List<Element> convertIterableIteratorToList(IteratorIterable<Element> descendants) {
		List<Element> elements = new ArrayList<>();
		for (Element element : descendants) {
			elements.add(element);
		}
		return elements;
	}

	private Document tryBuildingDocument(URL resource) {
		SAXBuilder builder = new SAXBuilder();
		try {
			return builder.build(resource);
		} catch (JDOMException | IOException e) {
			throw new RuntimeException("unable to load file : " + resource, e);
		}
	}

}