package com.addrbook.backend.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.addrbook.backend.bootstrap.DatabaseConfig;

/**
 * Bootstrap for service layer.
 * 
 * @author Trey
 */
@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = {"com.addrbook.backend.dao"})
public class DaoTestConfig {

}
