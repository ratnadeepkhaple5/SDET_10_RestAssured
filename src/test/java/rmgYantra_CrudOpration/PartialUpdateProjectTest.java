package rmgYantra_CrudOpration;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PartialUpdateProjectTest {

	@Test
	public void partialUpdateProject() {
		
	JSONObject jobj=new JSONObject();//internally it uses map like structure
	jobj.put("name", "reanheraTargerion");
	
	RequestSpecification reqsp = RestAssured.given();
	reqsp.contentType(ContentType.JSON);
	reqsp.body(jobj);
	
	Response resp = reqsp.patch("https://reqres.in/api/users/2");

	ValidatableResponse val = resp.then();
	val.assertThat().statusCode(200);
	val.log().all();
	}
}
