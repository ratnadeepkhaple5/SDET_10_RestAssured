package BDD_rmgYantraCRUD;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateProByFethingDataFromFile {

	@Test
	public void createPro() {
		
		File fl=new File("./dataBDD.json");//for complex json structure
		
		//predata	
				given()
				.contentType(ContentType.JSON)
				.body(fl)
			//test	
			   .when()
			   	.post("http://localhost:8084/addProject")
			//validation 	
			   .then()
			   	.assertThat().statusCode(201)
			   	.and().assertThat().contentType(ContentType.JSON)
			   	.log().all();
	}
}
