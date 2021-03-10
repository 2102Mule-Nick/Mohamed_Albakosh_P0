package com.revature.service;

import java.util.LinkedList;
import java.util.List;

import com.revature.exceptions.PassAmountOfClassesForSemester;
import com.revature.model.Course;
import com.revature.model.Department;
import com.revature.model.Instructer;
import com.revature.model.Semester;
import com.revature.model.Student;

public class RegistrationForSemesterImpl implements RegistrationForSemester {
	private final static List<Semester> SEMESTER_LIST = new LinkedList<>();
	//private StudentDao studentDao;
	private SemesterService semesterService ;
	private Semester semester;
	private StudentService  studentService ;
	private DepartmentService departmentService;
	private InstructerService instructerService ;
	private CourseService   courseService ;
	
	
	@Override
	public void RegisterStusent(String  semesterName, Student student, Department department,Instructer instructer, Course course) throws PassAmountOfClassesForSemester {
		
		
		semester = new Semester( semesterName,student, course, department, instructer);
		semesterService = new SemesterService();
		semesterService.insertSemester(semester);
		
	}

	@Override
	public void removeItemStudent(String name, Semester semester) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int TotalOfStudentInSemester() {
		 
		semesterService = new SemesterService();
		return semesterService.getTotalOfSemester();
	}

}
