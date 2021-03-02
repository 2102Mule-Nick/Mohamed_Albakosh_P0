package com.revature.service;

import java.util.List;

import com.revature.dao.InstructerDao;
import com.revature.dao.InstructerDaoImpl;
import com.revature.model.Instructer;

public class InstructerService {
	
	private InstructerDao instructerDao;
	
	public InstructerService() {
		this.instructerDao = new InstructerDaoImpl();
	}
	
	public List<Instructer> findAllInstructer() {
		
		return this.instructerDao.findAllInstructer();
	}

	
	public Instructer findInstructerById(int id) {
		
		return this.instructerDao.findInstructerById(id);
	}

	
	public Instructer findInstructerByName(String name) {
		
		return this.instructerDao.findInstructerByName(name);
	}

	
	public void insertInstructer(Instructer instructer) {
		
		this.instructerDao.insertInstructer(instructer);
		
		
	}

	
	public void deleteInstructer(Instructer instructer) {
		// TODO Auto-generated method stub
		
	}

	
	public void updateInstructer(Instructer instructer) {
		// TODO Auto-generated method stub
		
	}

}
