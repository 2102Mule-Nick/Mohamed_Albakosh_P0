package com.revature.model;

public class User {
	private String username;
	
	private String password;
	private String firstName;
	private String lastName;
	private int userid;
	private String email;
	private Role role;
	
	public User(String username, String password ) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(int userid, String username, String password ,String firstName, String lastName, String email) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email =email;
		
	}

	public User(int userid, String username, String password ,String firstName, String lastName, String email, Role  role) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email =email;
		this.role = role;
	}
	public User() {
		super();
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password  + ", FirstName=" +firstName+ ", lastName=" +lastName+"RoleName "+role.getRole()+"]";
	}
	

}
