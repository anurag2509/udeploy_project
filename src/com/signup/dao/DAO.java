package com.signup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.signup.entity.Entity;

public class DAO implements DAOInterface{

	private DAO(){}
	
	public static DAOInterface createDAOObject() {
		
		return new DAO();
	}

	@Override
	public int createProfile(Entity e) {
		int i=0;
		DataSource ds;
		try {
			Context ctx=new InitialContext();
			 ds=(DataSource) ctx.lookup("java:/OracleDS");
			
			try {
				Connection con= ds.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into signup values (?,?,?,?,?)");
				ps.setString(1, e.getName());
				ps.setString(2, e.getEmail());
				ps.setString(3, e.getAddress());
				ps.setString(4, e.getUsername());
				ps.setString(5, e.getPassword());
			} 
			catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		} 
		catch (NamingException e1) {
			
			e1.printStackTrace();
		}
		
		return 1;
		
		
	}

}
