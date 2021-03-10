package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Course;
import com.revature.model.Department;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactoryPostgres;

public class CourseDaoImpl implements CourseDao {
	Logger log = Logger.getRootLogger();
	private final static List<Course> COURES_LIST = new LinkedList<>();
	@Override
	public List<Course> findAllCourses() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from courser_table ";
		
		try {
			
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			set = stmt.executeQuery();
			
			while(set.next()) {
				COURES_LIST.add(  new Course( 
						                         set.getInt(1),
				                               set.getString(2)
				                               )
				);
			}
			
		}catch(SQLException e) {
			log.error("Failure to connect to Course Table", e);
			e.printStackTrace();
		}finally {
			
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		
		
		return COURES_LIST;
	}

	@Override
	public Course findCoursById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCoursByName(String name) {
         Course course = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from courser_table where departmentname = ?";
		
		try {
			
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, name);
			set = stmt.executeQuery();
			
			while(set.next()) {
				course = new Course( 
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
		
		return course;
		
      
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

}
