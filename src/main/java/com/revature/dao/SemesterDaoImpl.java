package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.exceptions.PassAmountOfClassesForSemester;
import com.revature.model.Department;
import com.revature.model.Semester;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactoryPostgres;

public class SemesterDaoImpl implements  SemesterDao {
	Logger log = Logger.getRootLogger();
	private final static List<Semester> SEMESTER_LIST = new LinkedList<>();
	@Override
	public List<Semester> findAllSemester() {
		// TODO Auto-generated method stub
		return SEMESTER_LIST;
	}

	@Override
	public Semester findSemesterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Semester findSemesterByName(String name) {
		
        Semester semester = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
	
		final String SQL = "select * from semester_table where semestername = ?";
		
		try {
			
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, name);
			set = stmt.executeQuery();
			
			while(set.next()) {
				semester = new Semester( 
						        set.getInt(1),
				                set.getString(2)
				           /*     set.getInt(semester.getStudent().getStudentId()),
				                set.getInt(semester.getCourse().getCourseId()),
				                set.getInt(semester.getDepartment().getDepartmentId()),
				                set.getInt(semester.getInstructer().getInstructerId())
				                */
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
		
		return semester;
	}

	@Override
	public void insertSemester(Semester semester) throws PassAmountOfClassesForSemester {
		 
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet set = null;
		 int num=0;
		
		      String SQL2= "select student_id from semester_table inner join student_table  on "
		      		+ "semester_table.student_id=student_table.studentid   group by student_id;";
		final String SQL = "insert into semester_table values(default, ?,?,?,?,?,?)";
		
		try {
			conn = ConnectionFactoryPostgres.getConnection();
			stmt2=conn.prepareStatement(SQL2);
			set = stmt2.executeQuery();
			 num = set.getInt(1);
			if( num <= 3) {
			stmt = conn.prepareStatement(SQL);

			stmt.setString(1, semester.getSemesterName());
			stmt.setInt(2, semester.getStudent().getStudentId());
			stmt.setInt(3, semester.getStudent().getStudentId());
			stmt.setInt(4, semester.getCourse().getCourseId());
			stmt.setInt(5, semester.getDepartment().getDepartmentId());
			stmt.setInt(6, semester.getInstructer().getInstructerId());
	
			stmt.executeUpdate();
			}else {
				throw new PassAmountOfClassesForSemester();
			}
		}catch(SQLException e) {
			log.error("Failure to connect to Department Table", e);
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}

	@Override
	public void deleteSemester(Semester semester) {
       Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "delete from  semester_table  semesterid = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, semester.getSemesterId());
			stmt.execute();
			log.info("Semester Deleted");
		} catch (SQLException e) {
	
			e.printStackTrace();
			log.info("Unsuccessful deleted");
		}
		
	}

	@Override
	public void updateSemester(Semester semester, String New_semesterName) {
        Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "update semester_table set semestername = ? WHERE semesterid = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, New_semesterName);
			stmt.setInt(2, semester.getSemesterId() );
			stmt.execute();
			log.info("Instructer updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Unsuccessful update");
		}
		
	}
	@Override
	public int getTotalOfSemester() {
		
		return SEMESTER_LIST.size();
	}

}
