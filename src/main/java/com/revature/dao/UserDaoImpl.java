package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.exceptions.UserNameTaken;
import com.revature.exceptions.UserNotFound;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactoryPostgres;

public class UserDaoImpl implements UserDao{
	
	Logger log = Logger.getRootLogger();
	
	public static List<User> userList;
	
	public UserDaoImpl() {
		super();
		
	}

	@Override
	public void createUser(User user) throws UserNameTaken {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		 
		final String SQL = "insert into user_table values(default, ?, ?,?,?,?)";
		
		try {
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			//stmt.setInt(1, user.getUserId());
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setInt(5, user.getRole().getRoleId());
	
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			log.error("Failure to connect to DB", e);
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
		
	
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFound {
		
        User user = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from usertable  inner join roletable on usertable.role_id=roletable.roleid where usertable.username =?";
		
		try {
			conn = ConnectionFactoryPostgres.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();
			
			while(set.next()) {
				user = new User( 
				                set.getInt(1),
				                set.getString(2),
				                set.getString(3),
				                set.getString(4),
				                set.getString(5),
				                set.getString(6),
				               new Role(set.getInt(8),set.getString(9))
				           );
			}
			System.out.println(user);
		}catch(SQLException e) {
			log.error("Failure to connect to DB", e);
			e.printStackTrace();
		}finally {
			
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		
		return user;
		
       
	}

	private String setString(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private int setInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user,String new_password ) {
        Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "update user_acc set pass_word = ? WHERE username = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, new_password);
			stmt.setString(2, user.getUsername());
			stmt.execute();
			log.info("User updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Unsuccessful update");
		}
		
		
	}

	@Override
	public void removeUser(User user) {
		
        log.trace("UserDaoPostgres.createUser method called");
        
        Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "delete from  usertable  WHERE username = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.execute();
			log.info("User Deleted");
		} catch (SQLException e) {
	
			e.printStackTrace();
			log.info("Unsuccessful deleted");
		}
          	
		
	}
	
	

}
