package com.revature.data;

import java.util.List;

import com.revature.beans.Recipe;
import com.revature.beans.RecipeIngredient;

public interface SearchDAO {
// contains all the ingredients listed
	public List<Recipe> getContains(List<Integer> ingredientIds);

// can be made from these ingredients
	public List<Recipe> getMadeFrom(List<Integer> ingredientIds);

// contains the string in the name
	public List<Recipe> getRecipeByName(String name);

// has this flavor profile
	public List<Recipe> getRecipeByFlavor(int flavorId);

// created by this user
	public List<Recipe> getRecipeByUser(int userId);
	
// gets all recipes
	public List<Recipe> getAllRecipes();
	
// gets all recipe ingredients
	public List<RecipeIngredient> getAllRecipeIngredients();
}

/*containing ingredients!
can be made from these ingredients
given the name.
given a flavor profile!
given a starred user and their recipes.*/