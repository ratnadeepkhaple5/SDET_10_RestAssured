package com.rmgYantra.DifferntWaysToPost;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgYantra.GenericLibrary.POJO;

public class CreateProjectUsingPOJO {

	@Test
	public void createProject(String createdBy,String projectName,String status,int teamSize) {
		// TODO Auto-generated method stub

		POJO pojo=new POJO("RatNa555", "rmgyantra.Xenosian12", "created", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
/*	
	@DataProvider
	public Object[][] proData(){
		
		Object[][] data=new Object[2][4] ;
			
			data[0][1]="ronny555";
			data[0][2]="ram1234";
			data[0][3]="created";
			data[0][4]=12;
			
			data[1][0]="ronny123";
			data[1][2]="sdetSunny555";
			data[1][3]="created";
			data[1][4]=10;
				
		}
		*/
	}


