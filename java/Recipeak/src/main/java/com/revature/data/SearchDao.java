package com.revature.data;

import java.util.List;

import com.revature.beans.Recipe;

public interface SearchDao {
// contains all the ingredients listed
	List<Recipe> getContains(List<Integer> ingredientIds);

// can be made from these ingredients
	List<Recipe> getMadeFrom(List<Integer> ingredientIds);

// contains the string in the name
	List<Recipe> getName(String name);

// has this flavor profile
	List<Recipe> getFlavor(int flavorId);

// created by this user
	List<Recipe> getByUser(int userId);
	
// gets all recipes
	List<Recipe> getAll();
}

/*containing ingredients!
can be made from these ingredients
given the name.
given a flavor profile!
given a starred user and their recipes.*/