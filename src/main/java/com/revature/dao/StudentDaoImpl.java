package com.revature.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



import com.revature.model.Student;

public class StudentDaoImpl implements StudentDao{
	private final static List<Student> Student_LIST = new LinkedList<>();
	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		
		return Student_LIST;
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByName(String name) {
		
		Iterator<Student> iter = Student_LIST.iterator();
		
		while (iter.hasNext()) {
			Student student = iter.next();
			if(student.getFirstName().equals(name)) {
				return student;
			}
		}
		
		return null;
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		Student_LIST.add(student);
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

}
