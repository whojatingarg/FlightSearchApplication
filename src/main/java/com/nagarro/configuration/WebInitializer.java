package com.nagarro.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author jatinkumar02
 *
 *It registers a ContextLoaderlistener (optionally) and a DispatcherServlet and 
 *allows you to easily add configuration classes to load for both classes and
 * to apply filters to the DispatcherServlet and to provide the servlet mapping.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
