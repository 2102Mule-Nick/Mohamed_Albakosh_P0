package com.revature.service;



import com.revature.model.Student;


public interface StudentAuthSservice {
	
    public boolean existingStudent(Student student);
	
	public Student authenticateStudent(Student student);

}
