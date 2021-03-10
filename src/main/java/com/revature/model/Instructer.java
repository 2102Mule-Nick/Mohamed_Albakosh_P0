package com.revature.model;

public class Instructer {
	private int instructerId;
	private String firstName;
	private String lastName;
	private User user;
	
	public Instructer(int instructerId, String firstName, String lastName) {
		super();
		this.instructerId = instructerId;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public Instructer(int instructerId, String firstName, String lastName, User user) {
		super();
		this.instructerId = instructerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
	}
	
	public int getInstructerId() {
		return instructerId;
	}
	public void setInstructerId(int instructerId) {
		this.instructerId = instructerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String toString() {
		return "Instructer [id=" + instructerId + ", FirstName=" +firstName +", FirstName=" +lastName +"]";
	}

}
