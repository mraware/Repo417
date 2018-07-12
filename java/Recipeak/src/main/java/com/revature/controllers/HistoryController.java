package com.revature.controllers;

import java.io.IOException;

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
@RequestMapping(value="/history")
public class HistoryController {
	ObjectMapper om = new ObjectMapper();
	Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	HistoryService hs;
	@Autowired
	UserService us;
	@Autowired
	RecipeService rs;
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public String isUserUpdateHistory(HttpSession session, @RequestBody History history) {
		try {
			history.setUser((User)session.getAttribute("user"));
			return om.writeValueAsString(hs.updateHistory(history));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
