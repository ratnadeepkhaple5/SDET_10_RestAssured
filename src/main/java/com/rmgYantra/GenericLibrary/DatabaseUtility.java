package com.rmgYantra.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	public Connection conn;
	
	public void createConnWithDB() throws SQLException {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("****connected to database****");
	}
	
	public void closeConnWithDB() throws SQLException {
		conn.close();	
		System.out.println("****Database closed****");
	}
	public ResultSet executeQuery(String query) throws SQLException{
		
		Statement state=conn.createStatement();
		ResultSet result = state.executeQuery(query);
		
		return result;
	}
}
