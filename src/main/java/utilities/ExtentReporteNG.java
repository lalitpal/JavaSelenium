package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporteNG {
	
	public static ExtentReports getReportObject() {
	
	String path = System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports report = new ExtentReports();
	report.attachReporter(reporter);
	report.setSystemInfo("QA", "Lalit Pal");
	return report;
	
	}
}
