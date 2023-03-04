package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import browserFactory.BrowserFactory;
import helper.Utility;

public class ExtentTestNGListener implements ITestListener {

	ExtentReports extent = ExtentManager.getInstance();

	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		System.out.println("LOG:INFO - Starting Listener Creating Test For Report");
		
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

		parentTest.set(extentTest);

	}

	public void onTestSuccess(ITestResult result) {
		parentTest.get().pass("Test Passed");
	}

	public void onTestFailure(ITestResult result) {

		String screenshot=Utility.captureScreenshotInBase64(BrowserFactory.getBrowserInstance());
		
		parentTest.get().fail("Test Failed "+result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());

	}

	public void onTestSkipped(ITestResult result) {

		parentTest.get().skip("Test Skipped "+result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("LOG:INFO - Appending result to the report");
	}

}
