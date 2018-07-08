package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@Service
public class SpringHibernateService implements UserService {
	@Autowired
	UserDAO ud;

	@Override
	public User addUser(User user) {
		return ud.addUser(user);
	}

	@Override
	public User getUserById(int id) {
		return ud.getUserById(id);
	}

	@Override
	public User updateUser(User user) {
		return ud.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		ud.deleteUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

}
