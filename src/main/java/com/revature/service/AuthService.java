package com.revature.service;

import com.revature.exceptions.InvalidPassword;
import com.revature.exceptions.UserNameTaken;
import com.revature.exceptions.UserNotFound;
import com.revature.model.Student;
import com.revature.model.User;

public interface AuthService {
	
    public boolean existingUser(User user);
	
	public User authenticateUser(User user) throws InvalidPassword, UserNotFound;
	
	public User registerUser(User user) throws UserNameTaken ;
	
	public void updateUser(User user,String new_password );
	
	public void removeUser(User user) ;

	public boolean existingStudent(String studentName);
	
	public boolean ckechIfUserSudent(User user)  ;

}
