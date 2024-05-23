package MyProject.MakeMyTripTests;

import org.testng.annotations.Test;

import MyProject.MakeMyTrip.BaseClass.BaseClass;
import MyProject.MakeMyTripPageObjects.HomePage;

public class HomePageTest extends BaseClass{

	@Test
	public void homeTest() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.testSteps();
	}
}
