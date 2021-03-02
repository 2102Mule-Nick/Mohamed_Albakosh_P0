package com.revature.service;

import com.revature.model.Course;
import com.revature.model.Department;
import com.revature.model.Instructer;
import com.revature.model.Semester;
import com.revature.model.Student;

public interface RegistrationForSemester {
	
	public void RegisterStusent(int semesterId, String semesterName,Student student,Department department,Instructer instructer, Course course);
	public void removeItemStudent(String name, Semester semester);
	public int TotalOfStudentInSemester();

}
