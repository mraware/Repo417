package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.data.RecipeDAO;
import com.revature.data.UserDAO;

@Service
public class SpringHibernateService implements UserService,
											   RecipeService {
	@Autowired
	UserDAO ud;
	@Autowired
	RecipeDAO rd;

	@Override
	public User addUser(User user) {
		return ud.addUser(user);
	}

	@Override
	public User getUserById(int id) {
		return ud.getUserById(id);
	}

	@Override
	public User updateUser(User user) {
		return ud.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		ud.deleteUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

	/* Recipe Section */
	@Override
	public Recipe addRecipe(Recipe recipe) {
		return rd.create(recipe);
	}

	@Override
	public Recipe getRecipeById(int id) {
		return rd.getById(id);
	}

	@Override
	public Recipe updateRecipe(Recipe recipe) {
		return rd.update(recipe);
	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		rd.delete(recipe);
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return rd.getAll();
	}

}
