package com.revature.data;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.History;
import com.revature.beans.Ingredient;
import com.revature.beans.Recipe;


@Component
public class IngredientHibernateDAO implements IngredientDAO, HibernateSession {
	private volatile Session session;
	Logger log = Logger.getLogger(IngredientHibernateDAO.class);

	@Override
	public Ingredient addIngredient(Ingredient ingredient) {
		log.debug("Adding ingredient " + ingredient);
		session.save(ingredient);
		return ingredient;
		
	}

	@Override
	public Ingredient getIngredientById(int id) {
		return (Ingredient) session.get(Ingredient.class, id);
	}

	@Override
	public Ingredient updateIngredient(Ingredient ingredient) {
		session.update(ingredient);
		return ingredient;
		
	}

	@Override
	public void deleteIngredient(Ingredient ingredient) {
		session.delete(ingredient);
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
		
	}
	
	@Override
	public int getIdFromName(String name) {
		Query<Ingredient> query = session.createQuery("FROM com.revature.beans.Ingredient ing "
				+ "WHERE ing.ingredient=:name");
		query.setParameter("name", name);
		return query.uniqueResult().getId();
	}

	@Override
	public List<Ingredient> getIngredients(int[] ids) {
		// first, need to query the list of IDs from the 
		// RECIPE_INGREDIENTS table for a given recipe_id
		//
		// then, once you have the set of RECIPEINGREDIENT_IDs
		// you should be able to retrieve a list of ingredients
		//  see if you can just call getIngredient a bunch of times...
		List<Ingredient> ingList = new ArrayList<Ingredient>();
		for(int i = 0; i < ids.length; i++) {
			ingList.add(getIngredientById(ids[i]));
		}
		return ingList;
	}
}