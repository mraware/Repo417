package com.revature.services;
import java.util.List;
import com.revature.beans.Recipe;

public interface RecipeService {
	public Recipe addRecipe(Recipe recipe);
	public Recipe getRecipeById(int id);
	public Recipe updateRecipe(Recipe recipe);
	public void deleteRecipe(Recipe recipe);
	public List<Recipe> getAllRecipes();
	public List<Recipe> getAllRecipesByUserId(int id);
}
