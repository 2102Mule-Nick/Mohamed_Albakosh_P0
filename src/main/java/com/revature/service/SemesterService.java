package com.revature.service;


import java.util.List;

import com.revature.dao.SemesterDao;
import com.revature.dao.SemesterDaoImpl;
import com.revature.model.Semester;

public class SemesterService {
	
	private SemesterDao semesterDao;
	
	public SemesterService() {
		this.semesterDao = new SemesterDaoImpl();
	}
	
	public List<Semester> findAllCourses() {
		
		return this.semesterDao.findAllSemester() ;
	}

	public Semester findSemesterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Semester findSemesterByName(String name) {
		
        
		return this.semesterDao.findSemesterByName(name);
	}

	
	public void insertSemester(Semester semester) {
		
		this.semesterDao.insertSemester(semester);
		
	}

	
	public void deleteSemester(Semester semester) {
		// TODO Auto-generated method stub
		
	}

	
	public void updateSemester(Semester semester) {
		// TODO Auto-generated method stub
		
	}
	
	public int getTotalOfSemester() {
		return this.semesterDao.getTotalOfSemester();
	}

}
