package com.revature.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import com.revature.model.Instructer;

public class InstructerDaoImpl implements InstructerDao{
	private final static List<Instructer> INSTRUCTER_LIST = new LinkedList<>();
	@Override
	public List<Instructer> findAllInstructer() {
		
		return INSTRUCTER_LIST;
	}

	@Override
	public Instructer findInstructerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instructer findInstructerByName(String name) {
		
		 Iterator<Instructer> iter = INSTRUCTER_LIST.iterator();
			
			while (iter.hasNext()) {
				Instructer instructer = iter.next();
				if(instructer.getFirstName().equals(name)) {
					return instructer;
				}
			}
		return null;
	}

	@Override
	public void insertInstructer(Instructer instructer) {
		// TODO Auto-generated method stub
		INSTRUCTER_LIST.add(instructer);
	}

	@Override
	public void deleteInstructer(Instructer instructer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInstructer(Instructer instructer) {
		// TODO Auto-generated method stub
		
	}

}
