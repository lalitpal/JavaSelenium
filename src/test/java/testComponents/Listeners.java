package testComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import LalitPal.OpenCart.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //ThreadSafe
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		//test.log(Status.PASS, "Test Passed");
		test.fail(result.getThrowable());
		
		//1. Take Screenshot
		
		//2. Attach it to Report
		
	}
	
	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
		
	}
	
	
	
//	@Override
//	public void onFinish(ITestResult result) {
//		
//		extent.flush();
//		
//	}
	


}
