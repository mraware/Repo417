package com.revature.controllers;

import java.io.IOException;
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
import com.revature.beans.Ingredient;
import com.revature.beans.Recipe;
import com.revature.beans.RecipeIngredient;
import com.revature.beans.User;
import com.revature.services.IngredientService;
import com.revature.services.RecipeIngredientService;
import com.revature.services.RecipeService;

@Controller
@RequestMapping(value="/recipe")
public class RecipeController {
	ObjectMapper om = new ObjectMapper();
	Logger log = Logger.getLogger(RecipeController.class);
	
	@Autowired
	RecipeService rs;
	@Autowired
	IngredientService is;
	@Autowired
	RecipeIngredientService ris;
	
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
	
	/* TODO change this to a POST... */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String getRecipe(HttpSession session, @PathVariable(value="id") int id) {
		try {
			// so I am going to try returning a string that contains
			// basically everything
			// return a JSON object containing:
			// 1. Recipe Object
			// 2. List of Instructions
			// 3. List of Ingredients
			// --> Need List of both: Ingredient & RecipeIngredient
			
			Recipe recipe = rs.getRecipeById(id);
			log.debug(recipe);
			
			List<RecipeIngredient> recipeIngList = ris.getRecipeIngredientByRecipe(recipe);
			log.debug(recipeIngList);
			/* 
			 * I am pretty sure the eager loading takes care of getting all the ingredients...
			 * ... now if only I could knock off that annoying recipe object...
			 */
			// get the set of IDs from RecipeIngredients to pass into 
//			int ids[] = new int [recipeIngList.size()]; int i = 0;
//			for(RecipeIngredient ing: recipeIngList) { ids[i++] = ing.getRecipe().getRecipeId(); }
//			List<Ingredient> ingList = is.getIngredientsByIds(ids);
//			log.debug(ingList);
			return om.writeValueAsString(recipe) +
					om.writeValueAsString(recipeIngList);
//					om.writeValueAsString(ingList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	@ResponseBody
	public String isUserAddRecipe(HttpSession session, @RequestBody String r) {
		try {
			Recipe recipe = om.readValue(r, Recipe.class);
			recipe.setCreator((User) session.getAttribute("user"));
			log.trace("\n" + recipe + "\n");
			rs.addRecipe(recipe);
			//log.debug((User) session.getAttribute("user"));
			return recipe.toString();
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
