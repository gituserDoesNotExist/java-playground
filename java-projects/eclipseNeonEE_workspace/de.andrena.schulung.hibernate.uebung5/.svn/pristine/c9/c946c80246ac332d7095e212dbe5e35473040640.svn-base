package de.andrena.schulung.hibernate.uebung5.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:/META-INF/application.properties")
@ComponentScan(basePackages = { "de.andrena.schulung.hibernate.uebung5.dao",
		"de.andrena.schulung.hibernate.uebung5.service" })
@Import(PersistenceConfiguration.class)
public class ApplicationConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
