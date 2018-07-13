package com.revature.data;

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
		List<Recipe> outputList = new ArrayList<Recipe>();
		List<Integer> ingredientList = new ArrayList<Integer>();
		List<Recipe> allRecipes = (ArrayList<Recipe>) getAllRecipes();
		List<RecipeIngredient> allIngredients = (ArrayList<RecipeIngredient>) getAllRecipeIngredients();
		for(int i = 0; i < allRecipes.size(); i++) {
			ingredientList.clear();
			for(int k = 0; k < allIngredients.size(); k++) {
				if(allIngredients.get(k).getRecipe().getRecipeId() == allRecipes.get(i).getRecipeId()) {
					ingredientList.add(allIngredients.get(k).getIngredient().getId());
				}
			}
			if(ingredientList.containsAll(ingredientIds)) {
				outputList.add(allRecipes.get(i));
			}
		}
		log.trace("----------" + outputList + "----------");
		return outputList;
	}

	@Override
	public List<Recipe> getMadeFrom(List<Integer> ingredientIds) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		List<Integer> ingredientList = new ArrayList<Integer>();
		List<Recipe> allRecipes = (ArrayList<Recipe>) getAllRecipes();
		List<RecipeIngredient> allIngredients = (ArrayList<RecipeIngredient>) getAllRecipeIngredients();
		int ingredients;
		for(int i = 0; i < allRecipes.size(); i++) {
			ingredientList.clear();
			ingredients = 0;
			for(int k = 0; k < allIngredients.size(); k++) {
				if(allIngredients.get(k).getRecipe().getRecipeId() == allRecipes.get(i).getRecipeId()) {
					ingredientList.add(allIngredients.get(k).getIngredient().getId());
				}
			}
			log.trace(ingredientIds);
			log.trace(ingredientList);
			for(int j = 0; j < ingredientList.size(); j++) {
				if(ingredientIds.contains(ingredientList.get(j))) {
					ingredients++;
				}
			}
			if(ingredients == ingredientList.size()) {
				outputList.add(allRecipes.get(i));
			}
		}
		log.trace("----------" + outputList + "----------");
		return outputList;
	}

	@Override
	public List<Recipe> getRecipeByName(String name) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		for(int i = 0; i < getAllRecipes().size(); i++) {
			if(getAllRecipes().get(i).getName().contains(name)) {
				outputList.add(getAllRecipes().get(i));
			}
		}
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
		return (List<RecipeIngredient>) session.createQuery("From com.revature.beans.RecipeIngredient", RecipeIngredient.class).list();
	}

}
