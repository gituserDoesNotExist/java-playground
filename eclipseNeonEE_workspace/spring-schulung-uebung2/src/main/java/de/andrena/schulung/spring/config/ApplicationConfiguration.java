package de.andrena.schulung.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("de.andrena.schulung.spring.haendler")
@PropertySource("classpath:/META-INF/haendler.properties")
public class ApplicationConfiguration {

}
