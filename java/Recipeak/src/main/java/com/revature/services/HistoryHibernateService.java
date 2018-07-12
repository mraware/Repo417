package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.History;
import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.data.HistoryDAO;

@Service
public class HistoryHibernateService implements HistoryService {
	
	@Autowired
	HistoryDAO hd;

	@Override
	public History addHistory(History history) {
		return hd.addHistory(history);
	}

	@Override
	public History getHistoryById(int id) {
		return hd.getHistoryById(id);
	}

	@Override
	public History updateHistory(History history) {
		if (history.getId() == 0) {
			History oldHistory = hd.getHistoryByUserAndRecipe(history.getUser(), history.getRecipe());
			history.setId(oldHistory.getId());
		}
		return hd.updateHistory(history);
	}

	@Override
	public void deleteHistory(History history) {
		hd.deleteHistory(history);
		
	}

	@Override
	public List<History> historyByUser(User user) {
		return hd.historyByUser(user);
	}

	@Override
	public History addHistory(User user, Recipe recipe) {
		History history = hd.getHistoryByUserAndRecipe(user, recipe);
		if (history == null) {
			history = new History(0,user,recipe,0,0,"");
			hd.addHistory(history);
		}
		return history;
	}

	@Override
	public List<History> getReviewsByUser(User user) {
		return hd.getReviewsByUser(user);
	}

	@Override
	public List<History> getReviewsByRecipe(Recipe recipe) {
		return hd.getReviewsByRecipe(recipe);
	}
}
