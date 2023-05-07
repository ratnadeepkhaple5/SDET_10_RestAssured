package rmgYantra_CrudOpration;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetProjectsTest {

	@Test
	public void getProjects() {
		
		Response response = RestAssured.get("http://localhost:8084/projects");
		//System.out.println(response.asString());
		//System.out.println(response.asPrettyString());
		System.out.println(response.getContentType());//--> application/json
		
		ValidatableResponse valresp = response.then();
		valresp.assertThat().statusCode(200);
		valresp.assertThat().contentType(ContentType.JSON);
		valresp.log().all();
	}
}
