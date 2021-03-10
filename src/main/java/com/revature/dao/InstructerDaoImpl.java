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
import com.revature.model.Instructer;
import com.revature.model.User;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactoryPostgres;

public class InstructerDaoImpl implements InstructerDao{
	Logger log = Logger.getRootLogger();
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
		
		Instructer instructer = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		final String SQL = "select * from instructer_table inner join usertable on instructer_table.instructerid = usertable.userid"
				+ " where firstname = ?";
		
		try {
			
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, name);
			set = stmt.executeQuery();
			
			while(set.next()) {
				instructer = new Instructer( 
						        set.getInt(1),
				                set.getString(2),
				                set.getString(3)
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
		
		return instructer;
	}

	@Override
	public void insertInstructer(Instructer instructer) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		 
		final String SQL = "insert into instructer_table values(default, ?,?)";
		
		try {
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);

			stmt.setString(1, instructer.getFirstName());
			stmt.setString(1, instructer.getLastName());
			stmt.setInt(1, instructer.getUser().getUserid());
	
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
	public void deleteInstructer(Instructer instructer) {
        Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "delete from  instructer_table  instructerid = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, instructer.getInstructerId());
			stmt.execute();
			log.info("Instructer Deleted");
		} catch (SQLException e) {
	
			e.printStackTrace();
			log.info("Unsuccessful deleted");
		}
		
	}

	@Override
	public void updateInstructer(Instructer instructer, String new_firstname) {
		Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "update instructer_table set firstname = ? WHERE instructerid = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, new_firstname);
			stmt.setInt(2, instructer.getInstructerId() );
			stmt.execute();
			log.info("Instructer updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Unsuccessful update");
		}
		
		
	}

}
