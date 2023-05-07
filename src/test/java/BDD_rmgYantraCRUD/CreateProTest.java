package BDD_rmgYantraCRUD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProTest {
	//precondition: make import statement static & ends with-> .*  
	
	@Test
	public void createTestBDD() {
		
		
		JSONObject jobj=new JSONObject();//internally it uses map like structure
		
		jobj.put("createdBy","XyzTonny");
		jobj.put("projectName",	"Bummy1111");
		jobj.put("status", "created");
		jobj.put("teamSize", 25);
		
	//predata	
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
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
