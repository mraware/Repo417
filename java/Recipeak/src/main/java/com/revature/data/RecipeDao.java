package com.revature.data;

import java.util.List;

import com.revature.beans.Recipe;

public interface RecipeDao {
	Recipe save(Recipe r);
	List<Recipe> getAll();
	Recipe getById(int i);
	Recipe update(Recipe r);
	void delete(Recipe r);
}
