package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed " + result.getStatus());
		System.out.println(result.getHost());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed " + result.getStatus());
		System.out.println(result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped " + result.getStatus());
	}

	public void onStart(ITestContext context) {
		System.out.println("Test Started");
	}

	public void onFinish(ITestContext context) {

		System.out.println("Test Finished");
	}

}
