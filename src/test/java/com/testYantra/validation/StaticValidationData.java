package com.testYantra.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticValidationData {

	@Test
	public void StaticvalidateData() {
		
		String expData="deepak_pro-5";
		
		Response resp=when()
		.get("http://localhost:8084/projects");
		
		String actData = resp.jsonPath().get("[1].projectName");//with index
		
		Assert.assertEquals(actData, expData);
		
		
	}
}
