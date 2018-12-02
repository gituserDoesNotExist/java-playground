package org.fancypackage.main;

import java.util.Arrays;

import org.fancypackage.configuration.PersistenceJPAConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextHandler {

	private ApplicationContext context;

	public ContextHandler() {
		setApplicationContext(PersistenceJPAConfig.class);
	}

	private void setApplicationContext(Class<? extends Object> configClass) {
		context = new AnnotationConfigApplicationContext(configClass);
	}

	public ApplicationContext getApplicationContext() {
		return context;
	}

	public void printAllBeans() {
		System.out.println("xxx");
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.asList(beanDefinitionNames));
	}

}
