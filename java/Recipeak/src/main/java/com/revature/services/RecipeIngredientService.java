package com.revature.services;

import java.util.List;
import com.revature.beans.RecipeIngredient;

public interface RecipeIngredientService {
	public List<RecipeIngredient> getRecipeIngredientByRecipeId(int recipeId);
}
