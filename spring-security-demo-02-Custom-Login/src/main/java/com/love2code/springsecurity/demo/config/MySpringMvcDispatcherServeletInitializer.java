package com.love2code.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServeletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
//		no root config - just so servelet config
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {DemoAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
