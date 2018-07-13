package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.History;
import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.services.HistoryService;
import com.revature.services.RecipeService;
import com.revature.services.UserService;

@Controller
@RequestMapping(value="/register")
public class RegisterController {
	ObjectMapper om = new ObjectMapper();
	Logger log = Logger.getLogger(RegisterController.class);
	
	@Autowired
	UserService us;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	@ResponseBody
	public String registerUser(HttpSession session, @RequestBody String userInfo) {
		log.trace(userInfo);
		String[] userList = userInfo.split(" ");
		User newUser = new User(0, "user", userList[0], userList[1], userList[2], userList[3]);
		log.trace(newUser.toString());
		try {
			return om.writeValueAsString(us.addUser(newUser));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
