package de.svi.svis3g.any.crawl.test.dependency.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControllerClass {

	@Autowired
	private ServiceClass service;

	@Autowired
	private ClassDefinedInXml classDefinedInXml;

}
