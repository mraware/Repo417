package com.revature.data;

import org.hibernate.Session;

import com.revature.beans.User;

public class UserHibernateDAO implements UserDAO, HibernateSession 
{
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
	
	public User getUserByUsername(String username)
	{
		
		return null;
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
