package com.org.dabbaa.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.dabbaa.model.User;

@RestController
@RequestMapping(value="/rest")
public class RestService {
	@RequestMapping(value = "/{name}", method = RequestMethod.GET ) //,headers="Accept=application/json")
	@ResponseBody
	public User getService(@PathVariable String name){
		User user=new User();
		user.setUsername(name);
		return user;
	}
}
