package com.revature.data;

import java.util.List;

import com.revature.beans.Recipe;

public interface RecipeDAO {
	Recipe create(Recipe r);
	List<Recipe> getAll();
	Recipe getById(int i);
	Recipe update(Recipe r);
	void delete(Recipe r);
}
