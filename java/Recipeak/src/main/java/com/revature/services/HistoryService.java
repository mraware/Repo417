package com.revature.services;

import java.util.List;

import com.revature.beans.History;
import com.revature.beans.User;

public interface HistoryService {
	public History addHistory(History history);
	public History getHistoryById(int id);
	public History updateHistory(History history);
	public void deleteHistory(History history);
	public List<History> historyByUser(User user);
}
