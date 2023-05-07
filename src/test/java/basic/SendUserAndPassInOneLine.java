package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.time.Duration;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class SendUserAndPassInOneLine {

	@Test
	public void getProjects() {
		
	ChromeDriver driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8084");
	
	driver.findElement(By.name("username")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
	
	}
}
