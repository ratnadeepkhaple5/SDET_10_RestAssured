package com.testYantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OuthGet {

	@Test
	public void getData() {
		
		Response resp = given()
		.formParam("client_id", "warrior_007")
		.formParam("client_secret", "748da019db980e8cd58834042614faad")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		//.then().log().all();
		
		String accessToken = resp.jsonPath().get("access_token");
		//System.out.println(accessToken);
		
		given()
		.auth().oauth2(accessToken)
		.when()
		.get("http://coop.apps.symfonycasts.com/me")
		
		.then().log().all();
	}
}
