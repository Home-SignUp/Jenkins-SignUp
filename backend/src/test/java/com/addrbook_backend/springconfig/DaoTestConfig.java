package com.addrbook_backend.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.addrbook_backend.bootstrap.DatabaseConfig;

/**
 * Bootstrap for service layer.
 * 
 * @author Trey
 */
@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = {"com.addrbook_backend.dao"})
public class DaoTestConfig {

}
