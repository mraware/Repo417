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
import com.revature.beans.Instruction;
import com.revature.beans.Recipe;
import com.revature.beans.RecipeIngredient;
import com.revature.beans.User;
import com.revature.services.IngredientService;
import com.revature.services.InstructionService;
import com.revature.services.RecipeIngredientService;
import com.revature.services.HistoryService;
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
	@Autowired
	InstructionService ins;
	@Autowired
	HistoryService hs;

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
  
	@RequestMapping(value="/all/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String getRecipesByUserId(@PathVariable(value="id") int id) {
		try {
			return om.writeValueAsString(rs.getAllRecipesByUserId(id));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String getRecipe(HttpSession session, @PathVariable(value="id") int id) {
		try {
			Recipe recipe = rs.getRecipeById(id);
			List<RecipeIngredient> recipeIngList = ris.getRecipeIngredientByRecipe(recipe);

			// lastly, return the set of instructions for the recipe
			List<Instruction> recipeInstr = ins.getInstructionsByRecipe(recipe);

			return "[{ \"recipe\" :" + om.writeValueAsString(recipe) + "}, " +
			"{ \"recipeIngredients\" :" + om.writeValueAsString(recipeIngList) + "}, " +
			"{ \"instructions\" :" + om.writeValueAsString(recipeInstr) + "}]";
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

	@RequestMapping(value="/{id}/reviews", method=RequestMethod.GET)
	@ResponseBody
	public String getReviewsFromRecipe(@PathVariable(value="id") int id) {
		Recipe recipe = rs.getRecipeById(id);
		try {
			return om.writeValueAsString(hs.getReviewsByRecipe(recipe));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public String updateRecipe (@RequestBody String s)
	{
		try 
		{
			String recipe = om.writeValueAsString(rs.updateRecipe(om.readValue(s, Recipe.class)));
			return recipe;
		}
		catch (JsonProcessingException e) 
		{
			e.printStackTrace();
			return null;
		} 
		catch (IOException e ) 
		{

			e.printStackTrace();
			return null;
		}
	}

}
