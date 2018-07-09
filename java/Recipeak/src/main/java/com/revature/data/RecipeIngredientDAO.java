package com.revature.data;

import java.util.List;

import com.revature.beans.RecipeIngredient;

public interface RecipeIngredientDAO {
	public RecipeIngredient addRecipeIngredient(RecipeIngredient ingredient);
	public RecipeIngredient getRecipeIngredientById(int id);
	public RecipeIngredient updateRecipeIngredient(RecipeIngredient ingredient);
	public void deleteRecipeIngredient(RecipeIngredient ingredient);
	public List<RecipeIngredient> getAll();
}
