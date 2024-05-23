package MyProject.MakeMyTripPageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import MyProject.MakeMyTrip.BaseClass.BaseClass;

public class HomePage extends BaseClass{

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	@FindBy (xpath = "//div[@class='chHeaderContainer']/descendant::span[text()='Flights' and contains(@class,'headerIcon')]")
	WebElement FlightsLbl;
	
	@FindBy (xpath ="//div[text()='Regular']")
	WebElement flightsPageValidationTxt;
	
	@FindBy (xpath = "//div[@class='chHeaderContainer']/descendant::span[text()='Hotels' and contains(@class,'headerIcon')]")
	WebElement hotelsLbl;
	
	@FindBy(xpath = "//span[text()='Group Deals']")
	WebElement hotelsValidationTxt;
	
	@FindBy (xpath = "//div[@class='chHeaderContainer']/descendant::span[text()='Homestays & Villas' and contains(@class,'headerIcon')]")
	WebElement homeStaysAndVillasLbl;
	
	@FindBy (xpath = "//a[text()='Homestay - Villas, Apartments & more.']")
	WebElement homeStaysValidatesTxt;
	
	@FindBy (xpath = "//div[@class='chHeaderContainer']/descendant::span[text()='Holiday Packages' and contains(@class,'headerIcon')]")
	WebElement holidayPackagesLbl;
	
	@FindBy (xpath = "//span[text()='Trending']")
	WebElement holidayPageValidatesTxt;
	
	@FindBy (xpath = "//div[@class='chHeaderContainer']/descendant::span[text()='Trains' and contains(@class,'headerIcon')]")
	WebElement trainsLbl;
	
	@FindBy (xpath = "//span[text()='Check PNR Status']")
	WebElement trainsPageValidatesTxt;
	
	@FindBy (xpath = "//div[@class='chHeaderContainer']/descendant::span[text()='Buses' and contains(@class,'headerIcon')]")
	WebElement busesLbl;
	
	@FindBy (xpath = "//a[text()='Travelling with a group? Hire a bus.']")
	WebElement busPageValidatesTxt;
	
	@FindBy (xpath = "//div[@class='chHeaderContainer']/descendant::span[text()='Cabs' and contains(@class,'headerIcon')]")
	WebElement cabsLbl;
	
	@FindBy(xpath = "//li[text()='Outstation Round-Trip']")
	WebElement cabsPageValidateTxt;
	
	@FindBy (xpath = "//div[@class='chHeaderContainer']/descendant::span[text()='Forex Card & Currency' and contains(@class,'headerIcon')]")
	WebElement forexCardAndCurrencyLbl;
	
	@FindBy (xpath = "//div[@class='chHeaderContainer']/descendant::span[text()='Travel Insurance' and contains(@class,'headerIcon')]")
	WebElement travelInsuranceLbl;
	
	@FindBy(xpath = "//span[@class='commonModal__close']")
	WebElement closeBtn;
	
	public void flightClick() {
		System.out.println(driver);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(FlightsLbl));
		FlightsLbl.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("flights"), currentUrl);
	}
	public void hotelsClick() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(hotelsLbl));
		hotelsLbl.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("hotels"), currentUrl);
	}
	public void homeStaysAndVillasClick() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(homeStaysAndVillasLbl));
		homeStaysAndVillasLbl.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("homestays"), currentUrl);
	}
	public void holidayPackagesClick() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(holidayPackagesLbl));
		holidayPackagesLbl.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("holidays-india"), currentUrl);
	}
	public void trainsClick() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(trainsLbl));
		trainsLbl.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("railways"), currentUrl);
	}
	
	public void busesClick() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(busesLbl));
		busesLbl.click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("bus-tickets"), currentUrl);
	}
	
	public void cabsClick() throws InterruptedException {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(cabsLbl));
		cabsLbl.click();
		wait.until(ExpectedConditions.visibilityOf(cabsPageValidateTxt));
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("cabs"), "cabs page not navigated");
	}

	public void forexAndCurrency() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(forexCardAndCurrencyLbl));
		forexCardAndCurrencyLbl.click();
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("forex"), currentUrl);
	
	}
	
	public void testSteps() throws InterruptedException {
		flightClick();
		hotelsClick();
		homeStaysAndVillasClick();
		holidayPackagesClick();
		trainsClick();
		busesClick();
		cabsClick();
		forexAndCurrency();
		
	}

}
