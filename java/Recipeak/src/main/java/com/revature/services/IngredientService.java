package com.revature.services;
import java.util.List;
import com.revature.beans.Ingredient;

public interface IngredientService {
	public List<Ingredient> getIngredientsByIds(int[] ids);
}
