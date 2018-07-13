package com.revature.data;

import java.util.List;

import com.revature.beans.Recipe;
import com.revature.beans.User;

public interface RecipeDAO {
	public Recipe create(Recipe r);
	public List<Recipe> getAll();
	public Recipe getById(int i);
	public Recipe update(Recipe r);
	public void delete(Recipe r);
	public List<Recipe> getAllByUser(User user);
}
