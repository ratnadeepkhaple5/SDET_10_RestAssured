package com.testYantra.validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.apache.http.impl.client.AbstractAuthenticationHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValidateData1 {

	//Mainly for verifying body data
	@Test
	public void validateData() {

		
		String expData="deepak_pro-5";

		Response resp=when()
		.get("http://localhost:8084/projects");

		 List<String> actData = resp.jsonPath().get("projectName");//json path without index
		
//	for (int i = 0; i < actData.size(); i++) {
//			
//			if (actData.contains(expData)) {
//				
//				System.out.println("data available1");
//				break;
//		}
	
	for (int i = 0; i < actData.size(); i++) {
		
		String actualData=actData.get(i);//getting inside loop..so every time it will re-initialize
		
		if (expData.equals(actualData)) {
	//	if(actData.get(i).equals(expData)) {	
			System.out.println("data available...equal");
			break;
		}
	}
	
//	for (String string : actData) {
//	
//		if (expData.equals(string)) {
//			
//			System.out.println("data available");
//			break;
//		}
//	}
	}
}
