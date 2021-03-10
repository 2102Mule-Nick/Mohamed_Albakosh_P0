package com.revature.dao;

import java.util.List;

import com.revature.exceptions.UserNameTaken;
import com.revature.exceptions.UserNotFound;
import com.revature.model.User;

public interface UserDao {
	
public void createUser(User user) throws UserNameTaken ;
	
	public User getUserByUsername(String username) throws UserNotFound ;
	
	public List<User> getAllUsers();
	
	public void updateUser(User user, String new_password );
	
	public void removeUser(User user);

}
