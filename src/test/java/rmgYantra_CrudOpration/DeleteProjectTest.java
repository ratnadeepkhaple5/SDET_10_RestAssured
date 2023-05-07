package rmgYantra_CrudOpration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {

	@Test(dataProvider = "data")
	public void deleteProject(String proid) {
		
		Response resp = RestAssured.delete("http://localhost:8084/projects/"+proid+"");
		
		System.out.println(resp.asPrettyString());
		
	}
	
	@DataProvider(name = "data")
	public String[] data() {
		
		String[] data=new String[] {
				"TY_PROJ_204"
		};
		return data;
		
	}
}
