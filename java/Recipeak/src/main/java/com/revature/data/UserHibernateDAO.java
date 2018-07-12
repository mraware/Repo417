package com.revature.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.History;
import com.revature.beans.User;

@Component
public class UserHibernateDAO implements UserDAO, HibernateSession 
{
//
//	HibernateUtil hu = new HibernateUtil();
	private volatile Session session;

	@Override
	public User addUser(User user) 
	{
		session.save(user);
		return user;
	}

	@Override
	public User getUserById(int id) 
	{
		return (User) session.get(User.class, id);
	}
	
	public User getUserByUsernameAndPassword(String username, String password)
	{
		User result = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> riddleMeThis = builder.createQuery(User.class);
		Root<User> root = riddleMeThis.from(User.class);
		riddleMeThis.select(root);
		List<User> users = session.createQuery(riddleMeThis).getResultList();
		for(User u : users)
		{
			if(u.getUsername().equals(username) && u.getPassword().equals(password))
			{
				result = u;
			}
		}
		return result;
	}

	@Override
	public User updateUser(User user) 
	{
		session.update(user);
		return user;
	}

	@Override
	public void deleteUser(User user) 
	{
		session.delete(user);
	}


	@Override
	public void setSession(Session session) 
	{
		this.session = session;	
	}

	@Override
	public List<User> getAllUsers() {
		return session.createQuery("from User", User.class).list();
	}
	
	@Override
	public int getIdByUsername(String name) {
		Query<User> query = session.createQuery("FROM com.revature.beans.User user "
				+ "WHERE user.username=:name");
		query.setParameter("name", name);
		return query.uniqueResult().getUserId();
	}
}
