package MyProject.MakeMyTrip.NewListnerPack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import MyProject.MakeMyTrip.BaseClass.BaseClass;

public class TestListner extends  BaseClass implements ITestListener {
	
	  private static ExtentReports extent;
	  private static ExtentTest test;
	  private WebDriver driver;

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("This is onStart method");
	        
	        // Initialize Extent Reports
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	        htmlReporter.config().setDocumentTitle("Test Report");
	        htmlReporter.config().setReportName("MakeMyTrip Automation Test Results");
	        htmlReporter.config().setTheme(Theme.STANDARD);

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Host Name", "YourHost");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User Name", "YourName");

	        // Set WebDriver from context
	        driver = (WebDriver) context.getAttribute("WebDriver");
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("This is onTestStart method");
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("This is onTestSuccess method");
	        test.pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("This is onTestFailure method");
	        test.fail("Test Failed");
	        test.fail(result.getThrowable());
	        
	        // Capture and attach the screenshot
	        try {
	            String screenshotPath = screenCapture(result.getMethod().getMethodName());
	            test.addScreenCaptureFromPath(screenshotPath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("This is onTestSkipped method");
	        test.skip("Test Skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("This is onFinish method");
	        extent.flush();
	    }

	    private String screenCapture(String methodName) throws IOException {
	        // Create the screenshots directory if it doesn't exist
	        File screenshotDir = new File("screenshots");
	        if (!screenshotDir.exists()) {
	            screenshotDir.mkdir();
	        }

	        // Capture the screenshot and create a temporary file
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        // Create the destination file path with timestamp
	        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	        String destFilePath = "screenshots/" + methodName + "_" + timestamp + ".png";
	        File destFile = new File(destFilePath);

	        // Copy the file to the destination
	        Files.copy(srcFile.toPath(), destFile.toPath());

	        return destFilePath;
	    }
	
}
