package de.svi.svis3g.any.crawl.test.dependency.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

	@Autowired
	private RepositoryClass repositoryClass;

	private MapperClass mapper;

	@Autowired
	public ServiceClass(MapperClass mapper) {
		this.mapper = mapper;
	}
}
