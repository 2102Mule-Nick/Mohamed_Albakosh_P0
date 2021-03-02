package com.revature.model;

public class Department {
	private int departmentId;
	private String departmentName;
	private Student student;
	
	public Department(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public Department(int departmentId, String departmentName, Student student) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.student = student;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Department [id=" + departmentId + ", DepartmentName=" +departmentName +"]";
	}
	

}
