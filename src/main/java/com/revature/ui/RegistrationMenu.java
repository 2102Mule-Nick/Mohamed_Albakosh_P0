package com.revature.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.exceptions.UserNameTaken;
import com.revature.model.User;
import com.revature.service.AuthService;

public class RegistrationMenu implements Menu {
	
	Logger log = Logger.getRootLogger();
	
	private Menu welcomeMenu;

	private Menu nextMenu;
	
	private Scanner scan;

	private AuthService authService;
	
	
	
	public RegistrationMenu() {
		super();
		
	}

	public RegistrationMenu(AuthService authService, Menu welcomeMenu) {
		super();
		this.authService = authService;
		this.welcomeMenu = welcomeMenu;
	}
	

	public Menu getWelcomeMenu() {
		return welcomeMenu;
	}

	public void setWelcomeMenu(Menu welcomeMenu) {
		this.welcomeMenu = welcomeMenu;
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@Override
	public Menu advance() {
		
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		
		User user = new User();
		System.out.println("Please enter a new username:");
		user.setUsername(scan.nextLine());
		System.out.println("Please enter a new password:");
		user.setPassword(scan.nextLine());
		System.out.println("Please enter a new first name:");
		user.setFirstName(scan.nextLine());
		System.out.println("Please enter a new Last name:");
		user.setLastName(scan.nextLine());
		if (!authService.existingUser(user)) {
			log.info("username:"+ user.getUsername()+"is avalable");
			try {
				authService.registerUser(user);
				nextMenu = null;
			} catch (UserNameTaken e) {
				System.out.println("Username taken, please try again");
				nextMenu = welcomeMenu;
			}
		} else {
			log.warn("username:"+ user.getUsername()+"is already taken");
			System.out.println("Username taken, please try again");
			nextMenu = welcomeMenu;
		}

	}

	@Override
	public Menu previousMenu() {
		
		return null;
	}

	@Override
	public Scanner getScanner() {
		
		return  this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		
		this.scan = scan;

	}

	public Menu getNextMenu() {
		return nextMenu;
	}

	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}
	

}
