package com.revature.dao;

import java.util.List;

import com.revature.exceptions.PassAmountOfClassesForSemester;
import com.revature.model.Semester;

public interface SemesterDao {
	public List< Semester> findAllSemester();
	public Semester findSemesterById(int id);
	public Semester findSemesterByName(String name);
	public void insertSemester(Semester semester) throws PassAmountOfClassesForSemester;
	public void deleteSemester(Semester semester);
	public void updateSemester(Semester semester, String New_semesterName);
	public int getTotalOfSemester();


}
