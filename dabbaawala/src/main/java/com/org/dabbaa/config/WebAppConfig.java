package com.org.dabbaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc  
public class WebAppConfig extends WebMvcConfigurerAdapter {	
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    System.out.println("addResourceHandlers");
	}
	
	@Bean(name="tilesConfigurer")
	public TilesConfigurer tilesConfigurer(){
	    TilesConfigurer tilesConfigurer = new TilesConfigurer();
	    tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
	    tilesConfigurer.setCheckRefresh(true);
	    System.out.println("tilesConfigurer");
	    return tilesConfigurer;
	}
	
	@Bean(name="tilesViewResolver")
	public TilesViewResolver tilesViewResolver(){
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(0);
	    System.out.println("tilesViewResolver");
	    return tilesViewResolver;
	}

}
