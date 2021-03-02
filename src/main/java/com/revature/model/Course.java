package com.revature.model;

public class Course {
	private int courseId;
	private String courseName;
	private Department department;
	private Instructer instructer;
	
	public Course( int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}
	public Course(int courseId, String courseName, Department department, Instructer instructer) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.department = department;
		this.instructer = instructer;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Instructer getInstructer() {
		return this.instructer;
	}
	public void setInstructer(Instructer instructer) {
		this.instructer = instructer;
	}
	@Override
	public String toString() {
		return "Course [id=" + courseId + ", FirstName=" +courseName +"]";
	}

}
