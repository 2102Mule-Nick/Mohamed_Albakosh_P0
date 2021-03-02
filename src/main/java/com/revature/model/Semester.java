package com.revature.model;

public class Semester {
	private int semesterId;
	private String semesterName;
	private String studentName;
	private String departmentNam;
	private String instructerName;
	private String courseName;
	public Semester(int semesterId, String semesterName, String studentName, String departmentNam,
			String instructerName, String courseName) {
		super();
		this.semesterId = semesterId;
		this.semesterName = semesterName;
		this.studentName = studentName;
		this.departmentNam = departmentNam;
		this.instructerName = instructerName;
		this.courseName = courseName;
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
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartmentNam() {
		return departmentNam;
	}
	public void setDepartmentNam(String departmentNam) {
		this.departmentNam = departmentNam;
	}
	public String getInstructerName() {
		return instructerName;
	}
	public void setInstructerName(String instructerName) {
		this.instructerName = instructerName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
