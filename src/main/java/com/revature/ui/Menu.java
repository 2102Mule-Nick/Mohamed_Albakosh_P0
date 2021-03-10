package com.revature.ui;

import java.util.Scanner;

import com.revature.exceptions.InvalidPassword;
import com.revature.exceptions.UserNotFound;

public interface Menu {
	public Menu advance();
	
    public void displayOptions() ;
	
	public Menu previousMenu();
	
	public Scanner getScanner();
	
	public void setScanner(Scanner scan);

}
