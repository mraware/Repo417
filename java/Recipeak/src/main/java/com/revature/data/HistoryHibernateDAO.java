package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;


import com.revature.beans.History;
import com.revature.beans.User;

@Component
public class HistoryHibernateDAO implements HistoryDAO, HibernateSession {
	private volatile Session session;

	@Override
	public History addHistory(History history) {
		session.save(history);
		return history;
		
	}

	@Override
	public History getHistoryById(int id) {
		return (History) session.get(History.class, id);
	}

	@Override
	public History updateHistory(History history) {
		session.update(history);
		return history;
		
	}

	@Override
	public void deleteHistory(History history) {
		session.delete(history);
		
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
		
	}

	@Override
	public List<History> historyByUser(User user) {
		return (List<History>) session.createQuery("From com.revature.beans.History hist where", History.class).list();
	}

}
