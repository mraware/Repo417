package com.revature.services;

import java.util.List;

import com.revature.beans.Recipe;
import com.revature.beans.RecipeIngredient;

public interface RecipeIngredientService {
	public List<RecipeIngredient> getRecipeIngredientByRecipe(Recipe r);
}
