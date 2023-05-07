package com.rmgYantra.GenericLibrary;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass {
	
	//we are creating object here and extending this class to test script 
	//so no need to create the object in test directly we can perform actions

	public DatabaseUtility dUtil=new DatabaseUtility();
	
	@BeforeSuite
	public void createConn() throws SQLException {
		
		dUtil.createConnWithDB();
	}
	
	@AfterSuite
	public void closeConn() throws SQLException {
		dUtil.closeConnWithDB();
	}
}
