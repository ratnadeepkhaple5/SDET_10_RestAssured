package rmgYantra_CrudOpration;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectDPTest {

	@Test(dataProvider = "data")
	public void createProject(Object[] data) {
		
	JSONObject jobj=new JSONObject();//internally it uses map like structure
	
//	jobj.put("createdBy","XyzSunny123");
//	jobj.put("projectName",	"dummy5511");
//	jobj.put("status", "updated");
//	jobj.put("teamSize", 9);
	
	jobj.put(data[0], data[0]);
	jobj.put(data[0], data[1]);
	jobj.put(data[1], data[0]);
	jobj.put(data[1], data[1]);
	
	
	RequestSpecification reqsp = RestAssured.given();
	reqsp.contentType(ContentType.JSON);
	reqsp.body(jobj);
	
	Response resp = reqsp.put("http://localhost:8084/projects/TY_PROJ_602");

	resp.then().assertThat().statusCode(200).log().all();
	}
	
	@DataProvider(name="data")
	public Object[][] data() {
		
		Object[][] data=new Object[][]
				{
			{"createdBy","XyzSunny567"},
			{"projectName",	"dummy5522"},
			{"status", "updated1"},
			{"teamSize", 10}
		};
		return data;
		
	}	
}
