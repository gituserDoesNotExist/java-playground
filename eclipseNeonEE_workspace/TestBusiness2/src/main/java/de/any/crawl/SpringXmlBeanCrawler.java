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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jdom2.Element;

public class SpringXmlBeanCrawler implements XmlCrawler {

	private SpringXmlBeanModel model;

	@SuppressWarnings("javadoc")
	public SpringXmlBeanCrawler(SpringXmlBeanModel model) {
		this.model = model;
	}

	@Override
	public List<RequiredBean> collectAllRequiredBeanDefinitionsForBeanTagWithId(String beanname) {
		List<RequiredBean> beans = new ArrayList<>();
		scanForBeans(beanname, beans);
		return beans;
	}

	private void scanForBeans(String beanName, List<RequiredBean> beans) {
		Optional<Element> beanNode = model.findNodeForBeanId(beanName);
		beanNode.ifPresent(element -> beans.add(new XmlRequiredBean(element)));
		List<String> beanIdsInNode = beanNode.map(model::findAllBeansInNode).orElseThrow(RuntimeException::new);
		for (String beanId : beanIdsInNode) {
			scanForBeans(beanId, beans);
		}
	}
}