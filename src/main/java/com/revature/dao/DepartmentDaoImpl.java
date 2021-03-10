package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Department;
import com.revature.model.User;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactoryPostgres;

public class DepartmentDaoImpl  implements DepartmentDao {
	private final static List<Department> DEPARTMENT_LIST = new LinkedList<>();
	Logger log = Logger.getRootLogger();
	@Override
	public List<Department> findAllDepartment() {
		
       
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from department_table ";
		
		try {
			
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			set = stmt.executeQuery();
			
			while(set.next()) {
				DEPARTMENT_LIST.add(  new Department( 
						                         set.getInt(1),
				                               set.getString(2)
				                               )
				);
			}
			
		}catch(SQLException e) {
			log.error("Failure to connect to DEPARTMENT Table", e);
			e.printStackTrace();
		}finally {
			
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		
		return DEPARTMENT_LIST;
	}

	@Override
	public Department findDepartmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findDepartmentByName(String name) {
		Department department = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from department_table where departmentname = ?";
		
		try {
			
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, name);
			set = stmt.executeQuery();
			
			while(set.next()) {
				department = new Department( 
						        set.getInt(1),
				                set.getString(2)
				              );
			}
			
		}catch(SQLException e) {
			log.error("Failure to connect to DB", e);
			e.printStackTrace();
		}finally {
			
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return department;
	}

	@Override
	public void insertDepartment(Department department) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		 
		final String SQL = "insert into department_table values(default, ?,)";
		
		try {
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);

			stmt.setString(1, department.getDepartmentName());
	
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			log.error("Failure to connect to Department Table", e);
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
		
	}

	@Override
	public void deleteDepartment(Department department) {
		
        Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "delete from  department_table  WHERE departmentname = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, department.getDepartmentName());
			stmt.execute();
			log.info("Department Deleted");
		} catch (SQLException e) {
	
			e.printStackTrace();
			log.info("Unsuccessful deleted");
		}
		
	}

	@Override
	public void updateDepartment(Department department,String new_departmentname) {
		
		    Connection conn = null;
			
			PreparedStatement stmt = null;
			
			String sql = "update department_table set departmentname = ? WHERE departmentid = ?";
			
			conn = ConnectionFactoryPostgres.getConnection();
			
			try {
				stmt=conn.prepareStatement(sql);
				stmt.setString(1, new_departmentname);
				stmt.setInt(2, department.getDepartmentId());
				stmt.execute();
				log.info("Department updated");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("Unsuccessful update");
			}
			
			
		
	}

}
