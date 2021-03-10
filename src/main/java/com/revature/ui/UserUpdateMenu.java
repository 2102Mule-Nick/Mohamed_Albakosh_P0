package com.revature.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.exceptions.UserNameTaken;
import com.revature.exceptions.UserNotFound;
import com.revature.model.User;
import com.revature.service.AuthService;

public class UserUpdateMenu implements Menu {
	
	Logger log = Logger.getRootLogger();
    Scanner scan;
	
	private AuthService authService;
	
	private Menu nextMenu;
	private Menu optionMenu;

	public UserUpdateMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public UserUpdateMenu( AuthService authService, Menu optionMenu ) {
		super();
		
		this.authService = authService;
		this.optionMenu = optionMenu ;
	}


	public Menu getNextMenu() {
		return nextMenu;
	}


	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}


	public Menu getOptionMenu() {
		return optionMenu;
	}


	public void setOptionMenu(Menu optionMenu) {
		this.optionMenu = optionMenu;
	}


	public Scanner getScanner() {
		return scan;
	}


	public void setScanner(Scanner scan) {
		this.scan = scan;
	}


	public AuthService getAuthService() {
		return authService;
	}


	public void setAuthService(AuthService authService) {
		this.authService = authService;
		
	}


	@Override
	public Menu advance() {
	
		return this.nextMenu;
	}

	@Override
	public void displayOptions() {
		
		User user = new User();
		
		System.out.println("Please enter a new password:");
		user.setPassword(scan.nextLine());
		String new_password = scan.nextLine();
		
		
		if (authService.existingUser(user)) {
			
			
				authService.updateUser(user, new_password);
				nextMenu = null;
			
				
			
		} else {
			
		        nextMenu = optionMenu ;
		}

	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
