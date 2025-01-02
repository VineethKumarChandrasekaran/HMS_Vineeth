package com.hms.generic.listenerutilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObject {
	
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static void setTest (ExtentTest stest) {
		test.set(stest);
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver (WebDriver sdriver) {
		driver.set(sdriver);
	}

}
