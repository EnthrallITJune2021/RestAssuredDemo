package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	public static final ExtentReports extentReport = new ExtentReports();
	
	public synchronized static ExtentReports creatExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");
		reporter.config().setReportName("API Test Execution");
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Tester", System.getProperty("user.name"));
		extentReport.setSystemInfo("Environment", "QA");
		return extentReport;
	}
}
