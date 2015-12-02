package com.org.dabbaa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.dabbaa.dao.UtilDao;
import com.org.dabbaa.model.TiffinType;

@RestController
@RequestMapping(value="/rest")
public class RestService {
	
	@Autowired
    private UtilDao dao;
	
	/*@RequestMapping(value = "/{name}", method = RequestMethod.GET )
	@ResponseBody
	public User getService(@PathVariable String name){
		User user=new User();
		user.setUsername(name);
		return user;
	}*/
	
	@RequestMapping(value = "/ttype", method = RequestMethod.GET )
	@ResponseBody
	public List<TiffinType> getTiffinTypes(){
		return dao.getTiffinTypes();
	}
}
