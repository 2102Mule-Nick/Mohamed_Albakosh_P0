package com.revature.service;

import java.util.List;



import com.revature.dao.DepartmentDao;
import com.revature.dao.DepartmentDaoImpl;
import com.revature.model.Department;

public class DepartmentService {
	
	private DepartmentDao departmentDao;

	public DepartmentService() {
		this.departmentDao = new DepartmentDaoImpl();
	}
    
	public List<Department> findAllDepartment() {
		
		return this.departmentDao.findAllDepartment();
	}

	
	public Department findDepartmentById(int id) {
		
		return this.departmentDao.findDepartmentById(id);
	}

	
	public Department findDepartmentByName(String name) {
		
		return this.departmentDao.findDepartmentByName(name);
	}

	
	public void insertDepartment(Department department) {
		
		
		this.departmentDao.insertDepartment(department);
		
	}

	
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		
	}

	
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		
	}

}
