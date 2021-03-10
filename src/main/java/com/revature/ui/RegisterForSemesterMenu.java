package com.revature.ui;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.CourseDao;
import com.revature.dao.DepartmentDao;
import com.revature.dao.InstructerDao;
import com.revature.dao.SemesterDao;
import com.revature.dao.StudentDao;
import com.revature.exceptions.PassAmountOfClassesForSemester;
import com.revature.exceptions.StudentNotFound;
import com.revature.model.Course;
import com.revature.model.Department;
import com.revature.model.Instructer;
import com.revature.model.Semester;
import com.revature.model.Student;
import com.revature.model.User;
import com.revature.service.AuthService;
import com.revature.service.RegistrationForSemesterImpl;

public class RegisterForSemesterMenu implements Menu {
	
	private Scanner scan;
	private Menu nextMenu;
	private AuthService authService;
	private User user;
	private CourseDao courseDao;
	private DepartmentDao departmentDao;
	private InstructerDao instructerDao;
	private SemesterDao semesterDao;
	private StudentDao studentDao;
	private RegistrationForSemesterImpl service;

	public RegisterForSemesterMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegisterForSemesterMenu(AuthService authService) {
		super();
		this.authService = authService;
		//this.user = user;

	}






	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@Override
	public Menu advance() {
		
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		
		System.out.println(" course:");
		//user.setPassword(scan.nextLine());
		List<Course> courses= courseDao.findAllCourses();
		for(Course c: courses) {
			System.out.println("course:"+c.getCourseName());
		}
		System.out.println("Slelect course");
		Course course=courseDao.findCoursByName(scan.nextLine());
		List<Department> departments= departmentDao.findAllDepartment();
		for(Department d: departments) {
			System.out.println("Departments:"+d.getDepartmentName());
		}
		System.out.println("Slelect department");
		
		Department department= departmentDao.findDepartmentByName(scan.nextLine());
		
		List<Instructer> instructers= instructerDao.findAllInstructer();
		for(Instructer inst: instructers) {
			System.out.println("Instructer:"+inst.getFirstName());
		}
		System.out.println("Slelect Instructer");
		
		Instructer instructer= instructerDao.findInstructerByName(scan.nextLine());
		
		
		System.out.println("Semester Samar Or spring");
		String semestername=scan.nextLine();
		
		System.out.println("inter the Student name:");
		String newstudent = scan.nextLine();
		if(authService.existingStudent(newstudent)) {
		Student student;
		try {
			student = studentDao.findStudentByName(newstudent);
		
		
		
			service.RegisterStusent( semestername, student, department, instructer, course);
		} catch (StudentNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PassAmountOfClassesForSemester e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
		
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		
		return this.scan ;
	}

	@Override
	public void setScanner(Scanner scan) {
		
		this.scan= scan;

	}

}
