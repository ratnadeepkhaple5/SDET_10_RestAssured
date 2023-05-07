package com.rmgYantra.Parametes;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.compress.archivers.zip.ExtraFieldUtils;
import org.testng.annotations.Test;

import com.rmgYantra.GenericLibrary.BaseApiClass;
import com.rmgYantra.GenericLibrary.EndPoints;
import com.rmgYantra.GenericLibrary.JavaUtility;
import com.rmgYantra.POJOLibrary.POJO;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingSoumya extends BaseApiClass {

	@Test
	public void endToEndSc() throws SQLException {
		
	//1) create project
		
		POJO pojo=new POJO("BHIM","BlueStar_"+JavaUtility.getRandomNumber(),"created", 10);
		
		baseURI="http://localhost";
		port=8084;
		//getting id of created project
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post(EndPoints.createProject);
	//	resp.prettyPrint();
	
		String projectid = resp.jsonPath().get("projectId");
		
	//2) update complete
		
		POJO pojoUpdated=new POJO("JAYBHIM", "SuperStar_999", "updated", 9);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojoUpdated)
		.pathParam("proId", projectid)
		.when()
		.put(EndPoints.completeUpdate);
		
	//3) get updated project
		
		Response respUp = given()
		.pathParam("proId", projectid)
		.when()
		.get(EndPoints.getSingleProject);
		
		String proName = respUp.jsonPath().get("projectName");
		System.out.println(proName);
		
	//verify in databases
		
		ResultSet result = dUtil.executeQuery("select * from project;");
		
		while (result.next()) {
			
			if (proName.equals(result.getString(4))) {
				
				System.out.println(proName+" is available in db");
				break;
			}
		}
			
	}
}
