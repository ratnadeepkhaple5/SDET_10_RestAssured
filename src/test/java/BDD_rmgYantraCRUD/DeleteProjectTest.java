package BDD_rmgYantraCRUD;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteProjectTest {

	@Test(dataProvider = "data")
	public void deleteProject(String proid) {
		
		when()
		.delete("http://localhost:8084/projects/"+proid+"")
	
		.then()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	
	@DataProvider(name = "data")
	public String[] data() {
		
		String[] data=new String[] {
				"TY_PROJ_419"
		};
		return data;
		
	}
}
