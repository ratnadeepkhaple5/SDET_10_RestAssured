package rmgYantra_CrudOpration;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {

	@Test
	public void createProject() {
		
	JSONObject jobj=new JSONObject();//internally it uses map like structure
	
	jobj.put("createdBy","XyzSunny");
	jobj.put("projectName",	"dummy556");
	jobj.put("status", "created");
	jobj.put("teamSize", 7);
	
	
	RequestSpecification reqsp = RestAssured.given();
	reqsp.contentType(ContentType.JSON);
	reqsp.body(jobj);
	
	Response resp = reqsp.post("http://localhost:8084/addProject");
	
//	ValidatableResponse val = resp.then();
//	val.assertThat().statusCode(201);
//	val.log().all();
	
	resp.then().assertThat().statusCode(201).log().all();
	}
}