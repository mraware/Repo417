package com.revature.data;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Recipe;
import com.revature.beans.RecipeIngredient;

@Component
public class SearchHibernate implements SearchDAO, HibernateSession {
	private volatile Session session;
	Logger log = Logger.getLogger(SearchHibernate.class);
	
	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<Recipe> getContains(List<Integer> ingredientIds) {
		log.trace("ingredientIds 1 " + ingredientIds.toString());
		List<Recipe> outputList = new ArrayList<Recipe>();
		List<Integer> ingredientList = new ArrayList<Integer>();
		for(int i = 0; i < getAllRecipes().size(); i++) {
			ingredientList.clear();
			log.trace("ingredientList 1 " + ingredientList.toString());
			for(int k = 0; k < getAllRecipeIngredients().size(); k++) {
				if(getAllRecipeIngredients().get(k).getRecipe().getRecipeId() == getAllRecipes().get(i).getRecipeId()) {
					ingredientList.add(getAllRecipeIngredients().get(k).getRecipe().getRecipeId());
				}
			}
			log.trace("ingredientIds 2 " + ingredientIds.toString());
			log.trace("ingredientList 2 " + ingredientList.toString());
			if(ingredientIds.containsAll(ingredientList)) {
				outputList.add(getAllRecipes().get(i));
			}
		}
		return outputList;
	}

	@Override
	public List<Recipe> getMadeFrom(List<Integer> ingredientIds) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		List<Integer> ingredientList = new ArrayList<Integer>();
		int ingredients;
		for(int i = 0; i < getAllRecipes().size(); i++) {
			ingredientList.clear();
			ingredients = 0;
			for(int k = 0; k < getAllRecipeIngredients().size(); k++) {
				if(getAllRecipeIngredients().get(k).getRecipe().getRecipeId() == getAllRecipes().get(i).getRecipeId()) {
					ingredientList.add(getAllRecipeIngredients().get(k).getRecipe().getRecipeId());
				}
			}
			for(int j = 0; j < ingredientList.size(); j++) {
				if(ingredientIds.contains(ingredientList.get(j))) {
					ingredients++;
				}
			}
			if(ingredients == ingredientList.size()) {
				outputList.add(getAllRecipes().get(i));
			}
		}
		return outputList;
	}

	@Override
	public List<Recipe> getRecipeByName(String name) {
		log.trace("\nNow inside getRecipeByName");
		List<Recipe> outputList = new ArrayList<Recipe>();
		log.trace("\n" + outputList.toString());
		for(int i = 0; i < getAllRecipes().size(); i++) {
			log.trace("\n" + getAllRecipes().get(i).getName());
			log.trace("\n" + name);
			if(getAllRecipes().get(i).getName().contains(name)) {
				outputList.add(getAllRecipes().get(i));
				log.trace("\n" + outputList.toString());
			}
		}
		log.trace("\n" + outputList.toString());
		return outputList;
	}

	@Override
	public List<Recipe> getRecipeByFlavor(int flavorId) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		for(int i = 0; i < getAllRecipes().size(); i++) {
			if(getAllRecipes().get(i).getFlavor().getId() == flavorId) {
				outputList.add(getAllRecipes().get(i));
			}
		}
		return outputList;
	}

	@Override
	public List<Recipe> getRecipeByUser(int userId) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		for(int i = 0; i < getAllRecipes().size(); i++) {
			if(getAllRecipes().get(i).getCreator().getUserId() == userId) {
				outputList.add(getAllRecipes().get(i));
			}
		}
		return outputList;
	}
	
	@Override
	public List<Recipe> getAllRecipes() {
		return (List<Recipe>) session.createQuery("From com.revature.beans.Recipe", Recipe.class).list();
	}

	@Override
	public List<RecipeIngredient> getAllRecipeIngredients() {
		log.trace(session.createQuery("From com.revature.beans.RecipeIngredient", RecipeIngredient.class).list().toString());
		return (List<RecipeIngredient>) session.createQuery("From com.revature.beans.RecipeIngredient", RecipeIngredient.class).list();
	}

}
