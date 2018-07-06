package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.beans.RecipeIngredient;

public class RecipeIngredientHibernate implements RecipeIngredientDAO{
	private volatile Session session;
	Logger log = Logger.getLogger(RecipeIngredientHibernate.class);

	@Override
	public RecipeIngredient addRecipeIngredient(RecipeIngredient ingredient) {
		log.debug("Adding ingredient " + ingredient);
		session.save(ingredient);
		return ingredient;
	}

	@Override
	public RecipeIngredient getRecipeIngredientById(int id) {
		return (RecipeIngredient) session.get(RecipeIngredient.class, id);
	}

	@Override
	public RecipeIngredient updateRecipeIngredient(RecipeIngredient ingredient) {
		session.update(ingredient);
		return ingredient;
	}

	@Override
	public void deleteRecipeIngredient(RecipeIngredient ingredient) {
		session.delete(ingredient);
	}

	@Override
	public List<RecipeIngredient> getAll() {
		return (List<RecipeIngredient>) session.createQuery("From com.revature.beans.RecipeIngredient", RecipeIngredient.class).list();
	}

}
