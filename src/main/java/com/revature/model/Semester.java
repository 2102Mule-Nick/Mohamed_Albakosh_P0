package com.revature.model;

public class Semester {
	private int semesterId;
	private String semesterName;
	private Student student;
	private Department department;
	private Instructer instructer;
	private Course course;
	
	public Semester(int semesterId, String semesterName) {
		super();
		this.semesterId = semesterId;
		this.semesterName = semesterName;
		
	}
	public Semester( String semesterName, Student student, Course course, Department department,Instructer instructer) {
		super();
		
		this.semesterName = semesterName;
		this.student = student;
		this.course = course;
		this.department = department;
		this.instructer = instructer;
	}
	public Semester(int semesterId, String semesterName, Student student, Course course, Department department,Instructer instructer) {
		super();
		this.semesterId = semesterId;
		this.semesterName = semesterName;
		this.student = student;
		this.course = course;
		this.department = department;
		this.instructer = instructer;
	}
	
	public Instructer getInstructer() {
		return instructer;
	}
	public void setInstructer(Instructer instructer) {
		this.instructer = instructer;
	}
	public int getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	

}
