package com.revature.data;

import java.util.List;

import com.revature.beans.History;
import com.revature.beans.Recipe;
import com.revature.beans.User;

public interface HistoryDAO {
	public History addHistory(History history);
	public History getHistoryById(int id);
	public History updateHistory(History history);
	public void deleteHistory(History history);
	public List<History> historyByUser(User user);
	public History getHistoryByUserAndRecipe(User user, Recipe recipe);
}
