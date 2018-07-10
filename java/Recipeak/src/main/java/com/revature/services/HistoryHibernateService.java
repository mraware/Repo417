package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.History;
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

}
