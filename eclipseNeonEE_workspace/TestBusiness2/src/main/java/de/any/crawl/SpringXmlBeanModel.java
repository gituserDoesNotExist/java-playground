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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jdom2.Element;

public class SpringXmlBeanModel {

	private List<URL> xmlFiles;
	private XmlParser xmlParser;
	private List<Element> beanNodes;

	@SuppressWarnings("javadoc")
	public SpringXmlBeanModel(List<URL> xmlFiles, XmlParser parser) {
		this.xmlFiles = xmlFiles;
		this.xmlParser = parser;
		this.beanNodes = createBeanNodes();
	}

	private List<Element> createBeanNodes() {
		return this.xmlFiles.stream().flatMap(this::createBeanNodesFromFile).collect(Collectors.toList());
	}

	private Stream<Element> createBeanNodesFromFile(URL resource) {
		return xmlParser.extractTagsFromXmlFile(resource, "bean").stream();
	}

	@SuppressWarnings("javadoc")
	public Optional<Element> findNodeForBeanId(String beanName) {
		return beanNodes.stream().filter(beanTag -> beanTag.getAttributeValue("id").equals(beanName)).findFirst();
	}

	@SuppressWarnings("javadoc")
	public List<String> findAllBeansInNode(Element node) {
		if (!hasBeanTagProperties(node)) {
			return Collections.emptyList();
		}
		List<String> referencedBeanNamesInBeanTag = new ArrayList<>();
		referencedBeanNamesInBeanTag.addAll(findAllPropertyTagsHavingRefAttributeIn(node));
		referencedBeanNamesInBeanTag.addAll(findAllRefTagsIn(node));
		return referencedBeanNamesInBeanTag;
	}

	private boolean hasBeanTagProperties(Element beanTag) {
		return !xmlParser.findDescendantTagsInParentTagByName(beanTag, "property").isEmpty();
	}

	private List<String> findAllPropertyTagsHavingRefAttributeIn(Element node) {
		List<Element> elements = xmlParser.findDescendantTagsInParentTagByName(node, "property");
		return mapElementsAndRemoveNullValues(elements, element -> element.getAttributeValue("ref"));
	}

	private List<String> findAllRefTagsIn(Element node) {
		List<Element> elements = xmlParser.findDescendantTagsInParentTagByName(node, "ref");
		return mapElementsAndRemoveNullValues(elements, element -> element.getAttributeValue("bean"));
	}

	private List<String> mapElementsAndRemoveNullValues(List<Element> list, Function<Element, String> function) {
		return list.stream().map(function).filter(Objects::nonNull).collect(Collectors.toList());
	}

}
