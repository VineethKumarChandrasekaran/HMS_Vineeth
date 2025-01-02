package com.hms.generic.listenerutilities;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.hms.generic.baseclassutility.BaseClass;
import com.hms.generic.javautilities.JavaUtility;
import com.hms.generic.webdriverutilities.WebdriverUtility;

public class ListenerUtility implements ITestListener,ISuiteListener,IRetryAnalyzer{
	
	JavaUtility javautility = new JavaUtility();
	WebdriverUtility webdriverutility = new WebdriverUtility();
	public ExtentReports extentreports;
	public ExtentTest test;

	@Override
	public boolean retry(ITestResult result) {
		int count = 0,limit = 5;
		if(count<limit) {
			count++;
			return true;
		}
		return false;
	}
	
	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/"+suite.getName()+"_"+javautility.getLocalDateTime());
		extentreports = new ExtentReports();
		extentreports.attachReporter(spark);
	}

	@Override
	public void onFinish(ISuite suite) {
		extentreports.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extentreports.createTest(result.getName());
		UtilityObject.setTest(test);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+" is Failed");
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64), result.getName()+javautility.getLocalDateTime());
		try {
			webdriverutility.takeScreenshot(BaseClass.sdriver, javautility.getLocalDateTime(), result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName()+" is Passed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName()+" is Skipped");
	}
	
}
