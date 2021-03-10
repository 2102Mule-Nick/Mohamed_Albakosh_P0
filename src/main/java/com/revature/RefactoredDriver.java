package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.dao.UserDaoKryo;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;
import com.revature.ui.LoginMenu;
import com.revature.ui.Menu;
import com.revature.ui.OptionMenu;
import com.revature.ui.RegisterForSemesterMenu;
import com.revature.ui.RegistrationMenu;
import com.revature.ui.UserUpdateMenu;
import com.revature.ui.WelcomeMenu;

public class RefactoredDriver {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		UserDao userDao= new UserDaoImpl();
		
		AuthService  authService= new AuthServiceImpl(userDao);
		
		Menu register = new RegistrationMenu();
		
		Menu updateMenu = new UserUpdateMenu();
		Menu options = new OptionMenu(updateMenu,authService);
		Menu  registerForSemester = new  RegisterForSemesterMenu(authService);		
		Menu login =new LoginMenu(authService,options, registerForSemester);
		
		Menu welcomeMenu = new WelcomeMenu(login, register);
		
        ((RegistrationMenu)register).setWelcomeMenu(welcomeMenu);
		
		((RegistrationMenu)register).setAuthService(authService);
		
		((LoginMenu)login).setOptionMenu(options);
		
		((LoginMenu)login).setAuthService(authService);
		
		((LoginMenu)login).setRegisterForSemesterMenu(registerForSemester);
		login.setScanner(scan);
		options.setScanner(scan);
		register.setScanner(scan);
		registerForSemester.setScanner(scan);
		welcomeMenu.setScanner(scan);
		
		
		Menu nextMenu = welcomeMenu;
		
		do {
			nextMenu.displayOptions();
			nextMenu = nextMenu.advance();
			//nextMenu = options.advance();
		} while (nextMenu != null);
		
	}	

}
