package com.testYantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class DelRepoBearerToken1 {

	@Test
	public void beareeTest() {
		
//		HashMap hm= new HashMap();
//		hm.put("name", "raj-ratna_123");
//		hm.put("id", "551155");
		
	given()
	.auth().oauth2("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")
//	.contentType(ContentType.JSON)
//	.body(hm)
	.when()
	.delete("https://api.github.com/repos/ratnadeepkhaple5/raj-ratna")
	.then()
	//.assertThat().statusCode(204)
//	.assertThat().contentType(ContentType.JSON)
	.log().all();
		
	}
}
