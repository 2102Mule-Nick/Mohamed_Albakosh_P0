package com.revature.dao;

import java.util.List;

import com.revature.model.Course;

public interface RoleDao {
	
	public List< Role> findAllRolrs();
	public Course findRoleById(int id);
	public Course findRoleByName(String name);
	public void insertRole(Course course);
	public void deleteRole(Course course);
	public void updateRole(Course course);

}
