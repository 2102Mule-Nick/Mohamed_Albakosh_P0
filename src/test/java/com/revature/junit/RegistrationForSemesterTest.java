package com.revature.junit;






import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.model.Course;
import com.revature.model.Department;
import com.revature.model.Instructer;
import com.revature.model.Semester;
import com.revature.model.Student;
import com.revature.service.CourseService;
import com.revature.service.DepartmentService;
import com.revature.service.InstructerService;
import com.revature.service.RegistrationForSemesterImpl;
import com.revature.service.StudentService;





public class RegistrationForSemesterTest {
	private Student student;
	private Course course;
	private Instructer instructer;
	private Semester semester;
	private Department department;
	
	private StudentService studentService;
	private CourseService courseService;
	private InstructerService  instructerService;
	private DepartmentService  departmentService;
	
	private static RegistrationForSemesterImpl service;
	@Test
	public void SemesterRegistration() {
		student = new Student(1,"Mohamed","Albakosh");
		studentService = new StudentService();
		 studentService.insertStudent(student);
		course = new Course(1,"Math");
		courseService = new CourseService();
		courseService.insertCours(course);
		instructer = new Instructer(1,"Axel","Albakosh");
		instructerService = new InstructerService();
		instructerService.insertInstructer(instructer);
		department = new Department(1,"Computer");
		departmentService = new DepartmentService();
		departmentService.insertDepartment(department);
		//studentService = new StudentService();
		service = new RegistrationForSemesterImpl();
		service.RegisterStusent(1,"Samar", student, department, instructer, course);
		
		int totalofstudent=service.TotalOfStudentInSemester();
		
		assertEquals(1,totalofstudent);
		
	}

}
