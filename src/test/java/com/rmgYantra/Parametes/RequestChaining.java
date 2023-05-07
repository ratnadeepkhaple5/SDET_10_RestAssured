package com.rmgYantra.Parametes;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining {

	
	@Test
	public void requestChaining() {
		
		//getting specific response
		Response resp =when()
		.get("http://localhost:8084/projects");
		
		String projectid = resp.jsonPath().get("[2].projectId");
		
		//deleting that response that we get
		given()
		.pathParam("proId",projectid )
		.when()
		.delete("http://localhost:8084/projects/{proId}")
		
		.then()
		.log().all();
		
		
	
	}
}
