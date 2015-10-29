package com.org.dabbaa.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	protected final Log log = LogFactory.getLog(getClass());
	
	public String home( HttpServletRequest request, Model model, HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", "");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.ENGLISH);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
