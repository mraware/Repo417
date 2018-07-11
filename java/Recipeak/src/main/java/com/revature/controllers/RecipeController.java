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
import com.revature.beans.Recipe;
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
	public String getRecipes() {
		try {
			log.debug(rs.getAllRecipes());
			return om.writeValueAsString(rs.getAllRecipes());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String getRecipe(HttpSession session, @PathVariable(value="id") int id) {
		try {
			log.debug(rs.getRecipeById(id));
			return om.writeValueAsString(rs.getRecipeById(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	@ResponseBody
	public String addRecipe(@RequestBody String r) {
		try {
			String recipe = rs.addRecipe(om.readValue(r, Recipe.class)).toString();
			return recipe;
			//			return "redirect:home";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e ) {
			e.printStackTrace();
			return null;
		}
	}

}
