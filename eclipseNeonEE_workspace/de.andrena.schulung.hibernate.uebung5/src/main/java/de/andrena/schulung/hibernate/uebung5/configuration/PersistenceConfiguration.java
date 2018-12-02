package de.andrena.schulung.hibernate.uebung5.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {

    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql}")
    private Boolean hibernateShowSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2DdlAuto;

    // Hier fehlen noch @Bean-Definitionen für die Beans "dataSource",
    // "entityManagerFactory" und "transactionManager" (vgl.
    // persistence-config.xml)

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	return null;
    }

    @SuppressWarnings("unused")
    private JpaVendorAdapter jpaVendorAdapter() {
	HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	jpaVendorAdapter.setDatabasePlatform(hibernateDialect);
	jpaVendorAdapter.setShowSql(hibernateShowSql);
	return jpaVendorAdapter;
    }

    @SuppressWarnings("unused")
    private Properties jpaProperties() {
	Properties jpaProperties = new Properties();
	jpaProperties.put("hibernate.archive.autodetection", "class, hbm");
	jpaProperties.put("hibernate.hbm2ddl.auto", hibernateHbm2DdlAuto);
	return jpaProperties;
    }

}
