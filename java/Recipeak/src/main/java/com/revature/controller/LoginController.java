package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.User;
import com.revature.data.UserHibernateDAO;

@Controller
@RequestMapping(value="/login")
public class LoginController 
{
	@Autowired
	ApplicationContext ac;
	
	@Autowired
	UserHibernateDAO userHD;
	
	private static Logger log = Logger.getLogger("10010001111011");

	public LoginController() {
		log.info("LOgin controller instantiated");
	}
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String goLogin(HttpSession session) 
	{
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		User u = userHD.getUserByUsernameAndPassword(username, password);
		System.out.println("Log in controller is being accessed.");
		session.setAttribute("user", u); 
		return "redirect:home";
	}
}