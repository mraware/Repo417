package com.revature.data;

import java.util.List;

import com.revature.beans.Recipe;
import com.revature.beans.RecipeIngredient;

public interface SearchService {
// contains all the ingredients listed
	List<Recipe> getContains(List<Integer> ingredientIds);

// can be made from these ingredients
	List<Recipe> getMadeFrom(List<Integer> ingredientIds);

// contains the string in the name
	List<Recipe> getRecipeByName(String name);

// has this flavor profile
	List<Recipe> getRecipeByFlavor(int flavorId);

// created by this user
	List<Recipe> getRecipeByUser(int userId);
	
// gets all recipes
	List<Recipe> getAllRecipes();
	
// gets all recipe ingredients
	List<RecipeIngredient> getAllRecipeIngredients();
}

/*containing ingredients!
can be made from these ingredients
given the name.
given a flavor profile!
given a starred user and their recipes.*/