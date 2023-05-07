package BDD_rmgYantraCRUD;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateProTestUsingHashMap {

	@Test
	public void createPro() {
	
		HashMap hm=new HashMap();
		hm.put("createdBy","XyzTonny12");
		hm.put("projectName",	"Bummy1212");
		hm.put("status", "created");
		hm.put("teamSize", 12);
		
	//predata	
		given()
		.contentType(ContentType.JSON)
		.body(hm)
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
