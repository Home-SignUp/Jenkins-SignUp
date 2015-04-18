package com.addrbook.backend.springconfig;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.addrbook.backend.dao.PersonDao;

/**
 * Bootstrap for service layer.
 * 
 * @author Trey
 */
@Configuration
@ComponentScan(basePackages = {"com.addrbook.backend.service"})
public class ServiceTestConfig {

	@Bean
	public PersonDao mockPersonDao() {
		return Mockito.mock(PersonDao.class);
	}
	
}
