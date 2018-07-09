package com.revature.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	ObjectMapper om = new ObjectMapper();
	Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	UserService us;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public String getUsers() {
		try {
			log.debug(us.getAllUsers());
			return om.writeValueAsString(us.getAllUsers());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String getUser(@PathVariable(value="id") int id) {
		try {
			log.debug(us.getUserById(id));
			return om.writeValueAsString(us.getUserById(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}