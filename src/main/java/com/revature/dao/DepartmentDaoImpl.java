package com.revature.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import com.revature.model.Department;

public class DepartmentDaoImpl  implements DepartmentDao {
	private final static List<Department> DEPARTMENT_LIST = new LinkedList<>();
	@Override
	public List<Department> findAllDepartment() {
		
		return DEPARTMENT_LIST;
	}

	@Override
	public Department findDepartmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findDepartmentByName(String name) {
        Iterator<Department> iter = DEPARTMENT_LIST.iterator();
		
		while (iter.hasNext()) {
			Department department = iter.next();
			if(department.getDepartmentName().equals(name)) {
				return department;
			}
		}
		return null;
	}

	@Override
	public void insertDepartment(Department department) {
		
		DEPARTMENT_LIST.add(department);
		
	}

	@Override
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		
	}

}
