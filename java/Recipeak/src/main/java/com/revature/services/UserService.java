package com.revature.services;


import java.util.List;

import com.revature.beans.User;

public interface UserService {
	public User addUser(User user);
	public User getUserById(int id);
	public User updateUser(User user);
	public void deleteUser(User user);
	public List<User> getAllUsers();
}
