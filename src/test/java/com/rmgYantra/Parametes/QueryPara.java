package com.rmgYantra.Parametes;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryPara {


	@Test
	public void queryPara() {
		
		given()
		.pathParam("username", "ratnadeepkhaple5")
		.queryParam("sort", "created")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.log().all();
	}
	
}
