package com.testYantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuthPost {

	@Test
	public void oAuth() {
		
		
		 Response resp = given()
		.formParam("client_id","SDET_10_sunny")
		.formParam("client_secret","a3cfebbc4c5e655b67ecb557fb92db8a")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri","https://example.com")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		 //post to generate token
		/*
		 .then().log().all();
		 
		 */ 
	//after that we have to get access token from console & need to save
		 
		 String accessToken = resp.jsonPath().get("access_token");
		 System.out.println(accessToken);
		 
		 given()
		 .auth().oauth2(accessToken)
		 .pathParam("USER_ID", "4062")
		 
		 .when()
		 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
		 .then()
		 .log().all();
	}
}

