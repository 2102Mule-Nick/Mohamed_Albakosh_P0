package com.revature.dao;

import java.util.List;

import com.revature.model.Instructer;

public interface InstructerDao {
	public List<Instructer> findAllInstructer();
	public Instructer findInstructerById(int id);
	public Instructer findInstructerByName(String name);
	public void insertInstructer(Instructer instructer);
	public void deleteInstructer(Instructer instructer);
	public void updateInstructer(Instructer instructer,String new_firstname);

}
