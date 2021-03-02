package com.revature.model;

public class Student {
	private int studentId;
	private String firstName;
	private String lastName;
	private Course course;
	private Instructer instructer;
	
	public Student(int studentId, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;	
	}
	
	public Student(int studentId, String firstName, String lastName,Course course,Instructer instructer) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.instructer = instructer;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Instructer getInstructer() {
		return instructer;
	}
	public void setInstructer(Instructer instructer) {
		this.instructer = instructer;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + studentId + ", FirstName=" +firstName + ",LastName="+ lastName +"]";
	}
    
}
