package com.rmgYantra.Parametes;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rmgYantra.GenericLibrary.DatabaseUtility;
import com.rmgYantra.GenericLibrary.JavaUtility;
import com.rmgYantra.GenericLibrary.POJO;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RequestChaining_databaseCheck {

	@Test
	public void databaseCheck() throws SQLException {
		JavaUtility jutil=new JavaUtility();
		POJO poj=new POJO("hanuman", "winLanka_"+jutil.getRandomNumber(), "created", 3);
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(poj)
		.when()
		.post("http://localhost:8084/addProject");
		
		String PID = resp.jsonPath().get("projectId");
		
		Response res = given()
		.pathParam("pid", PID)
		.when()
		.get("http://localhost:8084/projects/{pid}");
		resp.prettyPrint();
		//String pname = res.jsonPath().get("projectName");
		String pname="gfghcheche";
		System.out.println("projectName is---> "+pname);
		
		DatabaseUtility dutil=new DatabaseUtility();
		
		dutil.createConnWithDB();
		
		ResultSet result = dutil.executeQuery("select * from project;");
		SoftAssert sa=new SoftAssert();
		while (result.next()) {
			String pn = result.getString(4);
			System.out.println(pn);
			
			if (pname.equals(pn)) {
				System.out.println("data available--->passed");
				sa.assertEquals(true, true);
				break;
			}else {
				System.out.println("Data not available");
				sa.assertEquals(true, false);
				
			}
			
			
			
			
			
		}
		dutil.closeConnWithDB();
		sa.assertAll();
	}
}
