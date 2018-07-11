package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Recipe;

@Component
public class RecipeHibernateDAO implements RecipeDAO, HibernateSession {
	private Session session;
	
	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Recipe create(Recipe b) {
//		FlavorHibernateDAO fhd = new FlavorHibernateDAO();
//		fhd.addFlavor(b.getFlavor());
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
}
