package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController 
{
	@RequestMapping(value="/hell", method=RequestMethod.GET)
	public String goToHell() 
	{
		return "redirect:static/RobotHell.html";
	}
}
