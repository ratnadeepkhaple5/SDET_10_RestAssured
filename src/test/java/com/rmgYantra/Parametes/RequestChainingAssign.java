package com.rmgYantra.Parametes;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.rmgYantra.POJOLibrary.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingAssign {

	@Test
	public void endToEndSc() throws SQLException {
		
		baseURI="http://localhost";
		port=8084;
				
		int index=5;
		String projectName="tyssRavan_"+getRandomNumber();
	//1) create	
		POJO pojo=new POJO("ravan", projectName, "created", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post("/addProject");
		/*
		.then()
		.log().all();
		*/
		Response respProId =when()
		.get("/projects");
				
		String projectid = respProId.jsonPath().get("["+index+"].projectId");
				
		given()
		.pathParam("proId",projectid )
		
		.when()
		.get("/projects/{proId}");
		/*
		.then()
		.log().all();
		*/
	
	//2) Update completely
		
		POJO pojoUpdate=new POJO("ram", "tyss_new", "created", 12);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojoUpdate)
		
		.when()
		.put("/projects/"+projectid+"")
		
		.then()
		.assertThat().statusCode(200)
		.log().all();
	
	//3) get project Name
		
		String expProName="tyss_new";
		
		Response respProName = when()
		.get("/projects");
	
		String actproName = respProName.jsonPath().get("["+index+"].projectName");
		
		if (expProName.equals(actproName)) {
			System.out.println("data found");
		}
	//4 JDBC connectivity
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement state = conn.createStatement();
		String query="select project_name from project;";
		ResultSet result = state.executeQuery(query);
		
		while (result.next()) {
		//	System.out.println(result.getString(1));
			if (result.getString(1).contains(expProName)) {
				break;
			}
			System.out.println("Data present in database");
		}			
	}
	public int getRandomNumber() {
		Random random=new Random();
		int rNo=random.nextInt(1000);
		
		return rNo;
	}
}
