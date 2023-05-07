package com.rmgYantra.Parametes;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameters {
	
	@Test
	public void pathPara() {
	
	given()
	.pathParam("proId", "TY_PROJ_605")
	
	.when()
	.get("http://localhost:8084/projects/{proId}")
	
	.then()
	.log().all();
	}		
}
