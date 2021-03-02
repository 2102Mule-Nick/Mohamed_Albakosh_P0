package com.revature;

import java.util.Hashtable;
import java.util.Scanner;

import com.revature.model.Course;
import com.revature.model.Department;
import com.revature.model.Instructer;
import com.revature.model.Student;
import com.revature.service.CourseService;
import com.revature.service.DepartmentService;
import com.revature.service.InstructerService;
import com.revature.service.StudentService;

public class Driver {
	public static void main(String[] args) {
		String userName;
		String passWord ;
		// set up user list for authentication
		Hashtable<String,String> userList = new Hashtable<>();
		userList.put("Mohamed", "pass");
		userList.put("Sleman", "pass2");
		userList.put("Axel", "pass3");
		userList.put("Massinissa", "pass4");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter username:");
		userName = scanner.nextLine();
		System.out.println("Please enter password:");
		passWord = scanner.nextLine();
		//System.out.println("Welcome user "+userName+" with "+passWord);
		
		
		String authPassword=userList.get(userName);
		if(authPassword != null) {
				if(authPassword.equals(passWord)) {
					System.out.println("Welcom to the system "+ userName);
					
					Student student = new Student(1,"Mohamed","Albakosh");
					
					StudentService studentService = new StudentService();
					
					 studentService.insertStudent(student);
					 System.out.println(studentService.findAllStudent());
					 
					  Course  course = new Course(1,"Math");
					  CourseService courseService = new CourseService();
					  courseService.insertCours(course);
					  System.out.println(courseService.findAllCourses());
					  Instructer instructer = new Instructer(1,"Axel","Albakosh");
					  InstructerService instructerService = new InstructerService();
					  instructerService.insertInstructer(instructer);
					  System.out.println(instructerService.findAllInstructer());
					  Department department = new Department(1,"Computer");
					  DepartmentService departmentService = new DepartmentService();
					  departmentService.insertDepartment(department);
					  System.out.println(departmentService.findAllDepartment());
				}else {
					System.out.println("user is not authenticated");
				}
			} else {
		System.out.println("user not found");
	}
	}

}
