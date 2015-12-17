package com.org.dabbaa.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

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
	
	 public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
	        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

	        ObjectMapper mapper = new ObjectMapper();
	        //Registering Hibernate4Module to support lazy objects
	        mapper.registerModule(new Hibernate4Module());

	        messageConverter.setObjectMapper(mapper);
	        return messageConverter;

	    }

	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        //Here we add our custom-configured HttpMessageConverter
	        converters.add(jacksonMessageConverter());
	        super.configureMessageConverters(converters);
	    }


}
