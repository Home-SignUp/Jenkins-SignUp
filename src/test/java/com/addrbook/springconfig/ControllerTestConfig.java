package com.addrbook.springconfig;

import org.mockito.Mockito;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.addrbook.service.PersonService;

@Configuration
@ComponentScan(basePackages = {"com.addrbook.util"})
public class ControllerTestConfig {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PersonService mockPersonService() {
		return Mockito.mock(PersonService.class);
	}
	
}
