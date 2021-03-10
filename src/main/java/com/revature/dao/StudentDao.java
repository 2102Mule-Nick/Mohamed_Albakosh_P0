package com.revature.dao;

import java.util.List;

import com.revature.exceptions.StudentNotFound;
import com.revature.model.Student;

public interface StudentDao {
	public List<Student> findAllStudent();
	public Student findStudentById(int id);
	public Student findStudentByName(String name) throws StudentNotFound;
	public void insertStudent(Student student);
	public void deleteStudent(Student student);
	public void updateStudent(Student student, String new_firstname);

}
