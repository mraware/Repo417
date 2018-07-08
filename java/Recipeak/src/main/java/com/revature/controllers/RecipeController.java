package com.revature.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.RecipeService;

@Controller
@RequestMapping(value="/recipe")
public class RecipeController {
	ObjectMapper om = new ObjectMapper();
	Logger log = Logger.getLogger(RecipeController.class);
	
	@Autowired
	RecipeService rs;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public String getUsers() {
		try {
			log.debug(rs.getAllUsers());
			return om.writeValueAsString(rs.getAllUsers());
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
			return om.writeValueAsString(us.getById(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
