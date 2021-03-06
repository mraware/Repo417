package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Recipe;
import com.revature.beans.RecipeIngredient;

@Component
public class RecipeIngredientHibernate implements RecipeIngredientDAO, HibernateSession {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<RecipeIngredient> getRecipeIngredients(Recipe r) {
		Query<RecipeIngredient> query = session.createQuery("From com.revature.beans.RecipeIngredient ri where ri.recipe=:r");
		query.setParameter("r", r);
		return (List<RecipeIngredient>) query.list();
		
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

}
