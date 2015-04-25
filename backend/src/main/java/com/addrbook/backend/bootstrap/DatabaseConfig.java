package com.addrbook.backend.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Database configuration. Note the 'Import' annotation in RootConfig that activates this. PropertySource and
 * Environment pair allows externalized settings.
 * 
 * @author Trey
 *
 * https://github.com/voahar/spring/blob/master/src/main/java/fr/soat/mvc/config/DbConfig.java
 * http://hadoop43.blogspot.com/2015/03/hibernate-spring-transaction-doesn-work.html
 * http://www.mkyong.com/spring/maven-spring-jdbc-example/
 * http://alvinalexander.com/java/spring-mysql-java-basicdatasource-connection-example
 * http://docs.cloudfoundry.org/buildpacks/java/spring-service-bindings.html
 ** (Use MySQL database in a Spring Boot web application through Hibernate) http://blog.netgloo.com/2014/08/17/use-mysql-database-in-a-spring-boot-web-application-through-hibernate/
 ** http://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.6
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource("jdbc.properties")
public class DatabaseConfig {

	@Autowired
    Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // (символы превращаются в знаки вопроса (????)) http://otvety.google.ru/otvety/thread?tid=366242fda39990ad
        Properties properties = new Properties();
        properties.setProperty("user", env.getProperty("jdbc.username"));
        properties.setProperty("password", env.getProperty("jdbc.password"));
        properties.setProperty("useUnicode", env.getProperty("jdbc.useUnicode"));
        properties.setProperty("characterEncoding", env.getProperty("jdbc.characterEncoding"));
        dataSource.setConnectionProperties(properties);
        // (символы превращаются в знаки вопроса (????))
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
//		dataSource.setUsername(env.getProperty("jdbc.username"));
//		dataSource.setPassword(env.getProperty("jdbc.password"));


//		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
//				.addScript("classpath:init.sql").build();

		return dataSource;
	}
	
	@Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
