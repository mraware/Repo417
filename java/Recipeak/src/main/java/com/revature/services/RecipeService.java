package com.revature.services;
import java.util.List;
import com.revature.beans.Recipe;

public interface RecipeService {
	public Recipe addRecipe(Recipe Recipe);
	public Recipe getRecipeById(int id);
	public Recipe updateRecipe(Recipe Recipe);
	public void deleteRecipe(Recipe Recipe);
	public List<Recipe> getAllRecipes();
}
