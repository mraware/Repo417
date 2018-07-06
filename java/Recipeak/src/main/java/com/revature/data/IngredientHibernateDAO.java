package com.revature.data;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;


import com.revature.beans.Ingredient;


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

}