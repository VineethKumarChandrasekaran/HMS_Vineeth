package com.hms.generic.admin;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hms.generic.databaseutilities.DatabaseUtility;
import com.hms.generic.excelutilities.ExcelUtility;
import com.hms.generic.fileutilities.FileUtility;
import com.hms.generic.javautilities.JavaUtility;
import com.hms.generic.webdriverutilities.WebdriverUtility;

public class IndividualPatientReport {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		FileUtility fileutility = new FileUtility();
		ExcelUtility excelutitilty = new ExcelUtility();
		JavaUtility javautility = new JavaUtility();
		WebdriverUtility webdriverutility = new WebdriverUtility();
		DatabaseUtility databaseutility = new DatabaseUtility();

		if (fileutility.getDataFromPropertyFile("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (fileutility.getDataFromPropertyFile("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		} 
		webdriverutility.maximizeWindow(driver);
		webdriverutility.implicitwait(driver,10);
		webdriverutility.launchURL(driver, fileutility.getDataFromPropertyFile("url"));
		driver.findElement(By.xpath("//a[text()='Logins']")).click();
		driver.findElement(By.xpath("(//button[text()='Click Here'])[3]")).click();
		webdriverutility.switchTab(driver, fileutility.getDataFromPropertyFile("adminlogintitle"));
        if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("adminlogintitle"))) {
        	driver.findElement(By.xpath("//input[@name='username']")).clear();
        	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(fileutility.getDataFromPropertyFile("username"));
        	driver.findElement(By.xpath("//input[@name='password']")).clear();
        	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(fileutility.getDataFromPropertyFile("password"));
        	driver.findElement(By.xpath("//button[@name='submit']")).click();
        	if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"))) {
        		driver.findElement(By.xpath("//span[contains(text(),'Reports')]")).click();
        		driver.findElement(By.xpath("//span[contains(text(),'B/w dates reports')]")).click();
        		if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("reportstitle"))) {
        			driver.findElement(By.xpath("//input[@id='fromdate']")).sendKeys(javautility.getCalculatedDateDDMMYYY(-30));
        			driver.findElement(By.xpath("//input[@id='todate']")).sendKeys(javautility.getSystemDateDDMMYYYY());
        			driver.findElement(By.xpath("//button[@id='submit']")).click();
        		}
        		if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("viewpatienttitle"))) {
        			if(driver.findElement(By.xpath("//h5[@align='center']")).getText().contains(javautility.getCalculatedDateYYYYMMDD(-30))) {
        				System.out.println("Reports have been generated");
        				driver.findElement(By.xpath("(//i[@class='fa fa-eye'])[1]")).click();
        				if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("individualpatienttitle"))) {
        					System.out.println("Individual Reports has been generated");
        				}else {
        					System.out.println("Individual Reports has not been generated");
        				}
        			
        			}else {
        				System.out.println("Reports have not been generated");
        			}
        		}
        	}
        }
        webdriverutility.minimizeWindow(driver);
      webdriverutility.quitBrowser(driver);
	}

}
