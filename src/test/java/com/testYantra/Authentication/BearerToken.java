package com.testYantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {

	@Test
	public void bearerToken() {
		
		given()
		.auth().oauth2("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")
		.when().get("https://api.github.com/user/repos")
		.then().log().all();
	}
}
