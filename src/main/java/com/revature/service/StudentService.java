package com.revature.service;

import java.util.List;


import com.revature.dao.StudentDao;
import com.revature.dao.StudentDaoImpl;
import com.revature.model.Student;

public class StudentService {
	
    private StudentDao studentDao;
	
	public StudentService() {
		this.studentDao = new StudentDaoImpl();
	}
	public List<Student> findAllStudent() {
		
		return this.studentDao.findAllStudent();
	}

	
	public Student findStudentById(int id) {
		
		return this.studentDao.findStudentById(id);
	}

	
	public Student findStudentByName(String name) {
		
		return this.studentDao.findStudentByName(name);
	}

	
	public void insertStudent(Student student) {
		
		this.studentDao.insertStudent(student);
		
	}

	
	public void deleteStudent(Student student) {
		
		
	}

	
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}


}
