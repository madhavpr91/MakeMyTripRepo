package MyProject.MakeMyTrip.BaseClass;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



public class BaseClass {
	
	public static WebDriver driver;
	

	@BeforeSuite 
	public void launchBrowser() {
		System.out.println("This is beforeSuite");
		driver = DriverInitialization.getDriver();
//		context.setAttribute("WebDriver", driver);
		driver.get("https://www.makemytrip.com/");
	}
	
	
	@BeforeMethod
	public void beforeMehtod() {
		System.out.println("This is beforeMehtod");
		
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is beforeClass");
		
	} 
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("This is afterSuite");
		
	} 
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is afterMethod");
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	@AfterClass
	public void afterClass() {
		System.out.println("This is afterClass");
		
		}
}
