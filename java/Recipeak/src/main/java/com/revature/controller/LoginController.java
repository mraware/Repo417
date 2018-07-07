package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/login")
public class LoginController 
{
	@Autowired
	ApplicationContext ac;
	
	private static Logger log = Logger.getLogger("10010001111011");

	public LoginController() {
		log.info("LOgin controller instantiated");
	}
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String goLogin(HttpSession session) 
	{
		String sacrificialLamb = "hi";
		System.out.println("Log in controller is being accessed.");
		
		return sacrificialLamb;
	}
}
