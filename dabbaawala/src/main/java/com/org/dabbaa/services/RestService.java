package com.org.dabbaa.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest")
public class RestService {
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getService(@PathVariable String name){
		return name +": This is project first restfull webservice";
	}
}
