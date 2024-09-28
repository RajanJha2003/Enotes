package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

public class UserDAO {
	
	private Connection conn;
	
	public UserDAO(Connection conn) {
		super();
		this.conn=conn;
	}
	
	
	public boolean addUser(UserDetails u) {
		
		boolean f=false;
		try {
			String query="insert into user(name,email,password) values(?,?,?) ";
			
			
			PreparedStatement pr=conn.prepareStatement(query);
			pr.setString(1, u.getName());
			pr.setString(2, u.getEmail());
            pr.setString(3,u.getPassword());
            	
            int i=pr.executeUpdate();
            if(i==1) {
            	f=true;
            }
            
           
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return f;
	}
	
	
	public boolean loginUser(UserDetails u) {
		boolean f=false;
		
		try {
			String query="Select * from user where email=? and password=?";
			PreparedStatement pr=conn.prepareStatement(query);
			
			pr.setString(1, u.getEmail());
			pr.setString(2, u.getPassword());
			
			ResultSet rs=pr.executeQuery();
            
            
        	
	           
            if(rs.next()) {
            	f=true;
            }
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return f;
		
	}
	

}
