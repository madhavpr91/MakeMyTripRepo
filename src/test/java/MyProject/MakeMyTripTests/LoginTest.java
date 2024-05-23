package MyProject.MakeMyTripTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import MyProject.MakeMyTrip.BaseClass.BaseClass;
import MyProject.MakeMyTripPageObjects.LoginPage;

public class LoginTest extends BaseClass {


	@Test
	public void loginTest1() {
		
		LoginPage lp = new LoginPage(driver);
		lp.verifyLoginPage();
		lp.loginWithPersonalAccountType();
		lp.mobileVerifycontinueButton();
		lp.loginWithMyBizAccountType();
		lp.emailVerifyContinueButton();
		lp.verifyEmailIdErrorMessage();
		lp.exitLoginpage();
	}
	
}
