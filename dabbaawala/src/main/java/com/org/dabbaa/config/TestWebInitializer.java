package com.org.dabbaa.config;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;

public class TestWebInitializer implements ServletContainerInitializer{

	@Override
	public void onStartup(java.util.Set<java.lang.Class<?>> c, ServletContext ctx) {
		
		System.out.println("Running at startup");
		
	}
	
	
}
