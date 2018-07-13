package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.History;
import com.revature.beans.Recipe;
import com.revature.beans.User;

@Component
public class RecipeHibernateDAO implements RecipeDAO, HibernateSession {
	private Session session;
	
	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Recipe create(Recipe b) {
		session.save(b);
		return b;
	}

	@Override
	public List<Recipe> getAll() {
		return (List<Recipe>) session.createQuery("From com.revature.beans.Recipe", Recipe.class).list();
	}

	@Override
	public Recipe getById(int i) {
		return (Recipe) session.get(Recipe.class, i);
	}

	@Override
	public Recipe update(Recipe b) {
		session.update(b);
		return b;
	}

	@Override
	public void delete(Recipe b) {
		session.delete(b);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getAllByUser(User user) {
		System.out.println(user);
		Query<Recipe> query = session.createQuery("FROM com.revature.beans.Recipe reci "
				+ "WHERE reci.creator=:user");
		query.setParameter("user", user);
		List<Recipe> recipes =  query.list();
		System.out.println("I am returning!");
		System.out.println(recipes);
		return recipes;
	}
}
