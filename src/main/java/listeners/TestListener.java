package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;

import utils.ExtentReport;
import utils.ExtentReportManager;

public class TestListener implements ITestListener{

	private static String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}
	
    @Override
    public void onStart(ITestContext iTestContext) {
        Log.builder().build().setDetails("I am in onStart method " + iTestContext.getName());
        //info("I am in onStart method " + iTestContext.getName());
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
    	Log.builder().build().setDetails("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        ExtentReportManager.extentReport.flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
    	Log.builder().build().setDetails(getTestMethodName(iTestResult) + " test is starting.");
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    	Log.builder().build().setDetails(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReports log operation for passed tests.
    	ExtentReport.getTest().log(Status.PASS, "Test passed");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
    	Log.builder().build().setDetails(getTestMethodName(iTestResult) + " test is failed.");
        //Get driver from BaseTest and assign to local webdriver variable.
        ExtentReport.getTest().log(Status.FAIL, "Test Failed");
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    	Log.builder().build().setDetails(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
    	ExtentReport.getTest().log(Status.SKIP, "Test Skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    	Log.builder().build().setDetails("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}