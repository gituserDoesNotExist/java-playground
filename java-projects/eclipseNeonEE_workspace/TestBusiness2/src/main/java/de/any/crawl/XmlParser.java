/*
 * Created on 31.08.2018
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

import java.net.URL;
import java.util.List;

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
public interface XmlParser {

	Element getRootElementOfXmlFile(URL resource);

	/**
	 * @param file
	 * @param tagName
	 * @return Liste aller Elemente mit dem Tagnamen @param tagName aus der XML-Datei @param file.
	 */
	List<Element> extractTagsFromXmlFile(URL resource, String tagName);

	/**
	 * @param parentTag
	 * @param name
	 * @return true falls in dem Element "parentTag" Child-Tags mit dem Namen "name" sind.
	 */
	boolean hasParentDescendantTagsWithName(Element parentTag, String name);

	/**
	 * @param parentTag
	 * @param nameDescendantTag
	 * @return Liste aller Kindelemente mit dem namen "nameDescendantTag" in Parent-Tag "parentTag".
	 */
	List<Element> findDescendantTagsInParentTagByName(Element parentTag, String nameDescendantTag);

}
