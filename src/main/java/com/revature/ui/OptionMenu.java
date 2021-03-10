package com.revature.ui;

import java.util.Scanner;

import com.revature.service.AuthService;

public class OptionMenu implements Menu {
	private Scanner scan;
	private Menu nextMenu;
	private Menu userUpdateMenu;

	private AuthService authService;
	
	
	
   
	public OptionMenu() {
		super();
		
	}
	

	public OptionMenu(Menu userUpdateMenu, AuthService authService) {
		super();
		this.userUpdateMenu = userUpdateMenu;
		this.authService = authService;
	} 


	


	public Menu getUserUpdateMenu() {
		return userUpdateMenu;
	}


	public void setUserUpdateMenu(Menu userUpdateMenu) {
		this.userUpdateMenu = userUpdateMenu;
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
		
		System.out.println("Options");
		System.out.println("Would you like to add, update, delete :");
		String answer = scan.nextLine();
		if ("add".equals(answer)) {
			System.out.println("Would you like to add  user,student,instructer, department, courses,semester:  ");
			String updateOption = scan.nextLine();
			if ("user".equals(updateOption)) {
				
			}else if("student".equals(updateOption)) {
				
				
			}else if("instructer".equals(updateOption)) {
				
			}else if("department".equals(updateOption)) {
				
			}else if("courses".equals(updateOption)) {
				
			}else if("semester".equals(updateOption)) {
				
			}else {
				nextMenu = this;
			}
			
		} else if ("update".equals(answer)) {
			System.out.println("Would you like to update  user,student,instructer, department, courses,semester:  ");
			String updateOption = scan.nextLine();
			if ("user".equals(updateOption)) {
				nextMenu = userUpdateMenu;
			}else if("student".equals(updateOption)) {
				
			}else if("instructer".equals(updateOption)) {
				
			}else if("department".equals(updateOption)) {
				
			}else if("courses".equals(updateOption)) {
				
			}else if("semester".equals(updateOption)) {
				
			}else {
				nextMenu = this;
			}
		}else if("delete".equals(answer)) {
			System.out.println("Would you like to delete  user,student,instructer, department, courses,semester:  ");
			String updateOption = scan.nextLine();
			if ("user".equals(updateOption)) {
				
			}else if("student".equals(updateOption)) {
				
			}else if("instructer".equals(updateOption)) {
				
			}else if("department".equals(updateOption)) {
				
			}else if("courses".equals(updateOption)) {
				
			}else if("semester ".equals(updateOption)) {
				
			}else {
				nextMenu = this;
			}
			
		}else {
			System.out.println("invalid input");
			//redirect user to same welcome menu
			nextMenu = null;
		}

	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		
		this.scan = scan;

	}

}
