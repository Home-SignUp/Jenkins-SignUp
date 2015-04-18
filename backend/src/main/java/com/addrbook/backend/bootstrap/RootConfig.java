package com.addrbook.backend.bootstrap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
* Bootstrap for service layer.
*
* @author Trey
*/
@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = {"com.addrbook.backend.service", "com.addrbook.backend.dao", "com.addrbook.backend.util"})
public class RootConfig {

}
