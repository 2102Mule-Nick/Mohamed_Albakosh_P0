package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.exceptions.StudentNotFound;
import com.revature.model.Department;
import com.revature.model.Student;
import com.revature.model.User;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactoryPostgres;

public class StudentDaoImpl implements StudentDao{
	Logger log = Logger.getRootLogger();
	private final static List<Student> Student_LIST = new LinkedList<>();
	@Override
	public List<Student> findAllStudent() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from department_table ";
		
		try {
			
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			set = stmt.executeQuery();
			
			while(set.next()) {
				Student_LIST.add(  new Student( 
						                        set.getInt(1),
				                               set.getString(2),
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
		
		
		return Student_LIST;
	
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByName(String firstname) throws StudentNotFound{
		
        Student student = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from studenttable where username = ?";
		
		try {
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, firstname);
			set = stmt.executeQuery();
			
			while(set.next()) {
				student = new Student( 
				                set.getInt(1),
				                set.getString(2),
				                set.getString(3)
				           );
			}
			
		}catch(SQLException e) {
			log.error("Failure to connect to Student Table", e);
			e.printStackTrace();
		}finally {
			
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return student;
	}

	@Override
	public void insertStudent(Student student) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		 
		final String SQL = "insert into instructer_table values(default, ?,?,?,?)";
		
		try {
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);

			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setInt(3, student.getDepartment().getDepartmentId());
			stmt.setInt(3, student.getUser().getUserid());
			
	
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			log.error("Failure to connect to Student Table", e);
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}

	@Override
	public void deleteStudent(Student student) {
		
        Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "delete from  Student_table  studentid = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, student.getStudentId());
			stmt.execute();
			log.info("Student Deleted");
		} catch (SQLException e) {
	
			e.printStackTrace();
			log.info("Unsuccessful deleted");
		}
		
	}

	@Override
	public void updateStudent(Student student, String new_firstname) {
		
        Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "update student_table set firstname = ? WHERE studentid = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, new_firstname);
			stmt.setInt(2,student.getStudentId() );
			stmt.execute();
			log.info("Instructer updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Unsuccessful update");
		}
		
	}

}
