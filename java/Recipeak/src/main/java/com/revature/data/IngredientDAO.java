package com.revature.data;

import java.util.List;
import com.revature.beans.Ingredient;

public interface IngredientDAO {
	public Ingredient addIngredient(Ingredient ingredient);
	public Ingredient getIngredientById(int id);
	public Ingredient updateIngredient(Ingredient ingredient);
	public void deleteIngredient(Ingredient ingredient);
	public int getIdFromName(String name);
	public List<Ingredient> getIngredients(int[] Id);
}
