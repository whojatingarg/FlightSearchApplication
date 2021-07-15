package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author jatinkumar02
 *This class defines the servlet configuration,
 *this basically adds a suffix (.jsp) to the name of the page.
 *
 */

@Configuration
@ComponentScan( { "com.nagarro.controller" } )
public class ServletConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
}
