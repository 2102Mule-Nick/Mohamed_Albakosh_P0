package com.revature.ui;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.InvalidPassword;
import com.revature.exceptions.UserNotFound;
import com.revature.model.User;
import com.revature.service.AuthService;

public class LoginMenu implements Menu {
	private AuthService authService;
	private Menu optionMenu;
	private Menu nextMenu;
    private Scanner scan;
    private UserDao userDao;
    private Menu registerForSemesterMenu;
    
	public LoginMenu() {
		super();
	
	}
	
	public LoginMenu(AuthService authService, Menu optionMenu, Menu registerForSemesterMenu ) {
		super();
		this.authService = authService;
		this.optionMenu = optionMenu;
		this.registerForSemesterMenu =registerForSemesterMenu;
	} 

	
	public Menu getRegisterForSemesterMenu() {
		return registerForSemesterMenu;
	}

	public void setRegisterForSemesterMenu(Menu registerForSemesterMenu) {
		this.registerForSemesterMenu = registerForSemesterMenu;
	}

	public Menu getOptionMenu() {
		return optionMenu;
	}

	public void setOptionMenu(Menu optionMenu) {
		this.optionMenu = optionMenu;
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	public Scanner getScanner() {
		return scan;
	}

	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	@Override
	public Menu advance() {
		
		return nextMenu;
	}

	@Override
	public void displayOptions()  {
		
		System.out.println("Please Enter Username");
		String username = scan.nextLine();
		System.out.println("Please Enter Password");
		String password=scan.nextLine();
		User user = new User(username, password);
		
		try {
			authService.authenticateUser(user);
			System.out.println("Login successful");
			userDao= new UserDaoImpl();
		     user=userDao.getUserByUsername(username);
			String  rolename = user.getRole().getRole();
			 
			System.out.println("Note if you a Student Only you can register for a semester:");
			System.out.println("wuold you like to register for a Semester:(yes or no)");
			String answer= scan.nextLine();
			 if(answer.equals("yes")) {
				//System.out.println((user.getRole().getRole().equals("Admin")); 
				//System.out.println("[[["+rolename+"]]");
				//if(rolename.equals("Admin")) {
				 nextMenu = registerForSemesterMenu;
				//}else {
				//	nextMenu = this;
				//}
			}
			System.out.println("Note Only if you a Employee or Instructer  you have accesss our Mangement system for Add Updet and delete:");
			System.out.println("wuold you like to accesss our Mangement system :(yes or no)");
			String answer2= scan.nextLine();
			if(answer2.equals("yes")) {
				if(          user.getRole().getRole().equals("Admin") ) {
				      nextMenu=optionMenu;
				 
					
					
				}else {
					
				}
			}else {
				nextMenu = this;
			}
			//throw new Error();
		} catch (UserNotFound e) {
			System.out.println("Username does not exist.  Please register an account.");
		} catch (InvalidPassword e) {
			System.out.println("Authentication error, check username/password");
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong. Please try again later.");
			e.printStackTrace();
		} finally {
			System.out.println("Login Process Ended");
		}
		
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

}
