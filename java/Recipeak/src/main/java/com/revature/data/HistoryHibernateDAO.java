package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.History;
import com.revature.beans.Recipe;
import com.revature.beans.User;

@Component
public class HistoryHibernateDAO implements HistoryDAO, HibernateSession {
	private volatile Session session;
	Logger log = Logger.getLogger(HistoryHibernateDAO.class);

	@Override
	public History addHistory(History history) {
		log.debug("Adding history " + history);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<History> historyByUser(User user) {
		//TODO: finish query on history by user
		// (List<History>) session.createQuery("From com.revature.beans.History hist where hist.user=:user", History.class).list();
		Query<History> query = session.createQuery("FROM com.revature.beans.History hist WHERE hist.user=:user");
		query.setParameter("user", user);
		return (List<History>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public History getHistoryByUserAndRecipe(User user, Recipe recipe) {
		Query<History> query = session.createQuery("FROM com.revature.beans.History hist "
				+ "WHERE hist.user=:user AND hist.recipe=:recipe");
		query.setParameter("user", user);
		query.setParameter("recipe", recipe);
		return query.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<History> getReviewsByUser(User user) {
		Query<History> query = session.createQuery("FROM com.revature.beans.History hist "
				+ "WHERE hist.user=:user AND hist.score>0");
		query.setParameter("user", user);
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<History> getReviewsByRecipe(Recipe recipe) {
		Query<History> query = session.createQuery("FROM com.revature.beans.History hist "
				+ "WHERE hist.recipe=:recipe AND hist.score>0");
		query.setParameter("recipe", recipe);
		return query.list();
	}

}
