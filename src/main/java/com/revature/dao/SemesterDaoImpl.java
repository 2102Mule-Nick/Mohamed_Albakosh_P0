package com.revature.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import com.revature.model.Semester;

public class SemesterDaoImpl implements  SemesterDao {
	private final static List<Semester> SEMESTER_LIST = new LinkedList<>();
	@Override
	public List<Semester> findAllSemester() {
		// TODO Auto-generated method stub
		return SEMESTER_LIST;
	}

	@Override
	public Semester findSemesterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Semester findSemesterByName(String name) {
		
        Iterator<Semester> iter = SEMESTER_LIST.iterator();
		
		while (iter.hasNext()) {
			Semester semester = iter.next();
			if(semester.getSemesterName().equals(name)) {
				return semester;
			}
		}
		return null;
	}

	@Override
	public void insertSemester(Semester semester) {
		
		SEMESTER_LIST.add(semester);
		
	}

	@Override
	public void deleteSemester(Semester semester) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSemester(Semester semester) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getTotalOfSemester() {
		return SEMESTER_LIST.size();
	}

}
