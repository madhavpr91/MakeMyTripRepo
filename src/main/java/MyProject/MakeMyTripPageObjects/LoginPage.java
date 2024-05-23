package MyProject.MakeMyTripPageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.BaseClassFinder;

import com.github.javafaker.Faker;

import MyProject.MakeMyTrip.BaseClass.BaseClass;
import MyProject.MakeMyTrip.interfacesPackages.InterfaceLoginPage;

public class LoginPage extends BaseClass {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		 this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(xpath = "//p[text()='Sign up/Login now to']")
	WebElement signupText;
	
	@FindBy(xpath = "//li[text()='Personal Account']")
	WebElement personalAccountHeader;
	
	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
	WebElement mobileNumeberInput;
	
	@FindBy(xpath = "//span[text()='Continue']/..")
	WebElement continueBtn;
	
	@FindBy(xpath = "//li[text()='MyBiz Account']")
	WebElement myBizAccount;
	
	@FindBy(xpath = "//input[@placeholder='Enter your work email id']")
	WebElement emailIdInput;
	
	@FindBy(xpath = "//span[text()='CONTINUE']")
	WebElement emailIdContinueBtn;
	
	@FindBy(xpath = "//span[text()='Invalid phone number']")
	WebElement mobileErrorMessage;
	
	@FindBy(xpath = "//p[text()='Please enter valid Email address']")
	WebElement errorMessage;
	
	@FindBy(xpath = "//span[@data-cy='closeModal']")
	WebElement loginPageCloseBtn;

	@FindBy(xpath = "//img[@alt='Make My Trip']")
	WebElement makeMyTripLogo;
	
	public void verifyLoginPage() {
		System.out.println(driver);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(personalAccountHeader));
	}

	
	public void loginWithPersonalAccountType() {
		Faker faker = new Faker();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(personalAccountHeader));
		String name = faker.number().digits(10);
		mobileNumeberInput.sendKeys(name);
		
	}

	
	public void mobileVerifycontinueButton() {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();	
	}

	
	public void verifyLoginPerAccouErrorMessage() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(mobileErrorMessage));
		
	}

	
	public void loginWithMyBizAccountType() {
		myBizAccount.click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(emailIdInput));
		
	}

	
	public void emailVerifyContinueButton() {
//		Faker faker = new Faker();
		emailIdInput.sendKeys("text@gmail");
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(emailIdContinueBtn));
		emailIdContinueBtn.click();
				
		
	}

	
	public void verifyEmailIdErrorMessage() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		Assert.assertTrue(errorMessage.isDisplayed(),"Email error message not displayed must should be visible");
		
	}
	
	public void exitLoginpage() {
		personalAccountHeader.click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(loginPageCloseBtn));
//		Actions action = new Actions(driver);
//		action.moveToElement(loginPageCloseBtn).perform();
		loginPageCloseBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loginPageCloseBtn));
		Assert.assertTrue(makeMyTripLogo.isDisplayed(), "not navigated at Home page");
	}
	
}
