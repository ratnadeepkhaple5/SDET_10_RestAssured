package BDD_rmgYantraCRUD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FullUpdateProTest {

	@Test
	public void updateFullProject() {
		
	JSONObject jobj=new JSONObject();//internally it uses map like structure
	
	jobj.put("createdBy","XyzTonny123");
	jobj.put("projectName",	"dummy313");
	jobj.put("status", "on-going");
	jobj.put("teamSize", 10);
		
   given()
	.contentType(ContentType.JSON)
	.body(jobj)
   .when()	
	.put("http://localhost:8084/projects/TY_PROJ_603")

   .then()
	.assertThat().statusCode(200)
	.log().all();
	}
}	
