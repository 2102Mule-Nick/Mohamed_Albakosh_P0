package com.revature.service;




import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.revature.dao.StudentDao;
import com.revature.dao.UserDao;
import com.revature.exceptions.InvalidPassword;
import com.revature.exceptions.StudentNotFound;
import com.revature.exceptions.UserNameTaken;
import com.revature.exceptions.UserNotFound;
import com.revature.model.Student;
import com.revature.model.User;

public class AuthServiceImpl implements AuthService{
	private  static List<Student> S_LIST = new LinkedList<>();
    private UserDao userDao;
    private StudentDao studentDao;
    
    
    
	public AuthServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
		//this.studentDao = studentDao;
	}

	@Override
	public boolean existingUser(User user) {
		
		try {
			if (userDao.getUserByUsername(user.getUsername()) != null) {
				return true;
			}
		} catch (UserNotFound e) {
			return false;
		}
		return false;
	}

	@Override
	public User authenticateUser(User user) throws  InvalidPassword, UserNotFound {
		User existingUser = userDao.getUserByUsername(user.getUsername());

		if (existingUser !=  null && existingUser.getPassword().equals(user.getPassword())) {
			return existingUser;
		}

		throw new InvalidPassword();
	}

	@Override
	public User registerUser(User user) throws UserNameTaken {
		userDao.createUser(user);
		return user;
	}
	
	public void updateUser(User user,String new_password ) {
		userDao.updateUser(user, new_password);
	}
	
	public void removeUser(User user) {
		userDao.removeUser(user);
	}
	
	@Override
	public boolean existingStudent(String studentName) {
		
		try {
			if (studentDao.findStudentByName(studentName) != null) {
				return true;
			}
		} catch (StudentNotFound e) {
			return false;
		}
		return false;
	}
	
	@Override
	public boolean ckechIfUserSudent(User user)     {
		
        try {
        	User euser = userDao.getUserByUsername(user.getUsername());
        	S_LIST = studentDao.findAllStudent();
        	
        	Iterator<Student> iter = S_LIST.iterator();
    		
    		while (iter.hasNext()) {
    			Student student = iter.next();
    			if(euser.getFirstName().equals(student.getFirstName())) {
    				return true;
    			}
    		}
				
        }catch(UserNotFound e) {

		        return false;
        }
        
		return false;
	}

}
