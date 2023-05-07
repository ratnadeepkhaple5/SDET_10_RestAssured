package BDD_rmgYantraCRUD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class pra {

	@Test
	public void get() {
		
		given()
		.pathParam("proId", "TY_PROJ_1003")
		.get("http://localhost:8084/projects/{proId}")
		.then().log().all();
	}
}
