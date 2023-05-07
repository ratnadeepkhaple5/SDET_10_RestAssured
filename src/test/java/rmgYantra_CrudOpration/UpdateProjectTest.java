package rmgYantra_CrudOpration;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {


		@Test
		public void updateProject() {
			
		JSONObject jobj=new JSONObject();//internally it uses map like structure
		
		jobj.put("createdBy","XyzSunny123");
		jobj.put("projectName",	"dummy5511");
		jobj.put("status", "updated");
		jobj.put("teamSize", 9);
		
		
		RequestSpecification reqsp = RestAssured.given();
		reqsp.contentType(ContentType.JSON);
		reqsp.body(jobj);
		
		Response resp = reqsp.put("http://localhost:8084/projects/TY_PROJ_602");

		resp.then().assertThat().statusCode(200).log().all();
	}

}
