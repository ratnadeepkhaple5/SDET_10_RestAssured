package com.testYantra.validation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.mysql.cj.log.Log;


public class ResponseTimeValidation {

	
	@Test
	public void respVal() {

		String expData="deepak_pro-5";
		
		when()
		.get("http://localhost:8084/projects")
		
		.then()
	//	.assertThat().time(Matchers.lessThan(7000l),TimeUnit.MILLISECONDS)
		.assertThat().body("[1].projectName", Matchers.equalTo(expData))
		.log().all();
		
		
	}
}
