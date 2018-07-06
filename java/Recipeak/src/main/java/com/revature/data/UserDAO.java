package com.revature.data;

import com.revature.beans.User;

public interface UserDAO 
{
	public User addUser(User user);
	public User getUserById(int id);
	public User updateUser(User user);
	public void deleteUser(User user);
}
