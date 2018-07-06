package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.beans.Recipe;

public class SearchHibernate implements SearchDao, HibernateSession {
	private Session session;
	
	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<Recipe> getContains(List<Integer> ingredientIds) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		int ingredients;
		for(int i = 0; i < getAll().size(); i++) {
			ingredients = 0;
			for(int j = 0; j < ingredientIds.size(); j++) {
				if(true /* the ingredient is in the list = true */) {
					ingredients++;
				}
			}
			if(ingredients == ingredientIds.size()) {
				outputList.add(getAll().get(i));
			}
		}
		return outputList;
	}

	@Override
	public List<Recipe> getMadeFrom(List<Integer> ingredientIds) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		int ingredients;
		for(int i = 0; i < getAll().size(); i++) {
			ingredients = 0;
			for(int j = 0; j < ingredientIds.size(); j++) {
				if(true /* the ingredient is in the list = true */) {
					ingredients++;
				}
			}
			if(ingredients == getAll().get(i).getIngredients().size()) {
				outputList.add(getAll().get(i));
			}
		}
		return outputList;
	}

	@Override
	public List<Recipe> getName(String name) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		for(int i = 0; i < getAll().size(); i++) {
			if(getAll().get(i).getName().contains(name)) {
				outputList.add(getAll().get(i));
			}
		}
		return outputList;
	}

	@Override
	public List<Recipe> getFlavor(int flavorId) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		for(int i = 0; i < getAll().size(); i++) {
			if(getAll().get(i).getFlavor() == flavorId) {
				outputList.add(getAll().get(i));
			}
		}
		return outputList;
	}

	@Override
	public List<Recipe> getByUser(int userId) {
		List<Recipe> outputList = new ArrayList<Recipe>();
		for(int i = 0; i < getAll().size(); i++) {
			if(getAll().get(i).getCreator() == userId) {
				outputList.add(getAll().get(i));
			}
		}
		return outputList;
	}
	
	@Override
	public List<Recipe> getAll() {
		return (List<Recipe>) session.createQuery("From com.revature.beans.Recipe", Recipe.class).list();
	}

}
