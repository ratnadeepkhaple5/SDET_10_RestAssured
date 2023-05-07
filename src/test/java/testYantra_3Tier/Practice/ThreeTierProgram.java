package testYantra_3Tier.Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgYantra.GenericLibrary.DatabaseUtility;
import com.rmgYantra.GenericLibrary.JavaUtility;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ThreeTierProgram {

	
	@Test
	public void threeTierPro() throws AWTException, InterruptedException, SQLException {
	/**
	 * creating project in front layer
	 */
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8084");
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		Thread.sleep(2000);
	//pass data in textfield & click on create project	
		String projectName = "DMK_Firm"+JavaUtility.getRandomNumber();
		System.out.println(projectName);
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		WebElement element = driver.findElement(By.name("teamSize"));
		//passing data in disabled text-field
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='20'", element);
		
		driver.findElement(By.name("createdBy")).sendKeys("RajniKant");
		//select data from dropdown
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sl=new Select(ele);
		sl.selectByVisibleText("Created");
		Thread.sleep(2000);
		//click on submit button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
	
		List<WebElement> tableData = driver.findElements(By.xpath("//table"));
		for (WebElement webEle : tableData) {
			System.out.println(webEle.getText());
			if (webEle.getText().contains(projectName)) {
				System.out.println(projectName+" <-Data found");
				break;
			} else {
				System.out.println("data  not found");
			}
		}
		String projectid = driver.findElement(By.xpath("//table//tbody/tr[last()]//td[1]")).getText();
		System.out.println(projectid);
		driver.manage().window().minimize();
		
		Thread.sleep(5000);
	/**
	 *get in backEnd Layer	
	 */
		 Response resp = given()
		.pathParam("proId", projectid)
		 .when()
		.get("http://localhost:8084/projects/{proId}");
		 resp.prettyPrint();
		
		 /*
		List<String> actProName = resp.jsonPath().get("projectName");
		//System.out.println(actProName);
		for (int i = 0; i < actProName.size(); i++) {
			String actProjectName = actProName.get(i);
			if (projectName.equals(actProjectName)) {
				System.out.println(actProjectName+" data available");
				resp.prettyPrint();
			break;
			}
			//Assert.assertEquals(actProjectName, projectName);
		}	
		*/
		 
		 /**
		  *validating on database layer 
		  */
		 
		 DatabaseUtility dutil=new DatabaseUtility();
		 dutil.createConnWithDB();
		 ResultSet result = dutil.executeQuery("select project_name from project;");

		 while (result.next()) {

			 if (projectName.equals(result.getString(1))) {

				 System.out.println("data found in database-> "+projectName);
			 }

		 }
	}
}
