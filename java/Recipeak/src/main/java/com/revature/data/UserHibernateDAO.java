package com.revature.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

@Component
public class UserHibernateDAO implements UserDAO, HibernateSession 
{
	HibernateUtil hu = new HibernateUtil();
	private volatile Session session = hu.getHibernateSession();

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


	public void setSession(Session session) 
	{
		this.session = session;	
	}

}
