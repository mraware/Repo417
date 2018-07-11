package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.data.UserDAO;
@CrossOrigin
@Controller
@RequestMapping(value="/login")
public class LoginController 
{
	ObjectMapper om = new ObjectMapper();
	@Autowired
	ApplicationContext ac;
	
	@Autowired
	UserDAO userHD;
	
	private static Logger log = Logger.getLogger("10010001111011");

	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String goLogin(   String username,  String password, HttpSession session) throws JsonProcessingException 
	{
		log.debug(username);
		User u = userHD.getUserByUsernameAndPassword(username, password);
		System.out.println("Log in controller is being accessed.");
		session.setAttribute("user", u);
		System.out.println("User had been entered.");
		if(u==null)
		{
			return "redirect:dashboard";
		}
		else
		{
			return om.writeValueAsString(u);
		}
		
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public void getMeOutOfHere (HttpSession session)
	{
		session.invalidate();
	}
}