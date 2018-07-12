package com.revature.controllers;

import java.sql.Array;
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
import com.revature.beans.User;
import com.revature.data.FlavorDAO;
import com.revature.data.IngredientDAO;
import com.revature.data.UserDAO;
import com.revature.services.SearchService;

@Controller
@RequestMapping(value="/search")
public class SearchController {
	ObjectMapper om = new ObjectMapper();
	Logger log = Logger.getLogger(SearchController.class);
	
	SearchService ss;
	
	@Autowired
	FlavorDAO fd;
	
	@Autowired
	UserDAO ud;
	
	@Autowired
	IngredientDAO id;
	
	@RequestMapping(value="/name/{name}", method=RequestMethod.GET)
	@ResponseBody
	public String getRecipesName(HttpSession session, @PathVariable(value="name") String name) {
		try {
			log.debug(ss.getRecipeByName(name));
			return om.writeValueAsString(ss.getRecipeByName(name));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/flavor/{flavor}", method=RequestMethod.GET)
	@ResponseBody
	public String getRecipesFlavor(HttpSession session, @PathVariable(value="flavor") String flavor) {
		try {
			log.debug(ss.getRecipeByFlavor(fd.getIdFromName(flavor)));
			return om.writeValueAsString(ss.getRecipeByFlavor(fd.getIdFromName(flavor)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/user/{user}", method=RequestMethod.GET)
	@ResponseBody
	public String getRecipesUser(HttpSession session, @PathVariable(value="user") String user) {
		try {
			log.debug(ss.getRecipeByUser(ud.getIdByUsername(user)));
			return om.writeValueAsString(ss.getRecipeByUser(ud.getIdByUsername(user)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/contains/{contains}", method=RequestMethod.GET)
	@ResponseBody
	public String getRecipesContains(HttpSession session, @PathVariable(value="contains") String contains) {
		String[] containsArray = contains.split(",");
		List<Integer> intList = new ArrayList<Integer>();
		for(int i = 0; i < containsArray.length; i++) {
			intList.add(id.getIdFromName(containsArray[i]));
		}
		try {
			log.debug(ss.getContains(intList));
			System.out.println(intList.toString());
			System.out.println(ss.getContains(intList));
			return om.writeValueAsString(ss.getContains(intList));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/madefrom/{madefrom}", method=RequestMethod.GET)
	@ResponseBody
	public String getRecipesMadeFrom(HttpSession session, @PathVariable(value="madefrom") String madefrom) {
		String[] madefromArray = madefrom.split(",");
		List<Integer> intList = new ArrayList<Integer>();
		for(int i = 0; i < madefromArray.length; i++) {
			intList.add(id.getIdFromName(madefromArray[i]));
		}
		try {
			log.debug(ss.getMadeFrom(intList));
			System.out.println(intList.toString());
			System.out.println(ss.getMadeFrom(intList));
			return om.writeValueAsString(ss.getMadeFrom(intList));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
