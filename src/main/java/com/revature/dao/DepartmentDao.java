package com.revature.dao;

import java.util.List;


import com.revature.model.Department;

public interface DepartmentDao {
	public List<Department > findAllDepartment();
	public Department findDepartmentById(int id);
	public Department findDepartmentByName(String name);
	public void insertDepartment(Department department);
	public void deleteDepartment(Department department);
	public void updateDepartment(Department department);

}
