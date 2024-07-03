package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter Reporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String reportName;
	
	@Override
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Finding the time stamp for report name.
		reportName = "Test-Report - " + timeStamp;
		
		Reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + reportName); // Specifying location of the report.
		
		Reporter.config().setDocumentTitle("FurAutomation"); // Report Title
		Reporter.config().setReportName("PetStore User API"); // Report Name
		Reporter.config().setTheme(Theme.DARK); // Report Theme
		
		extent = new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Application", "FurStore User API");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Username", System.getProperty("user.name"));
		extent.setSystemInfo("User", "Aryan");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed!");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.FAIL, "Test Failed.");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test Skipped.");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush(); // This method needs to be called for the reports to be generated!!
		
	}

}
