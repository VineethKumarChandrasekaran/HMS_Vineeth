package com.hms.generic.admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hms.generic.databaseutilities.DatabaseUtility;
import com.hms.generic.excelutilities.ExcelUtility;
import com.hms.generic.fileutilities.FileUtility;
import com.hms.generic.javautilities.JavaUtility;
import com.hms.generic.webdriverutilities.WebdriverUtility;

public class EditDoctorSpecialization {
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
        	driver.findElement(By.xpath("//span[contains(text(),'Doctors')]")).click();
        	driver.findElement(By.xpath("//span[contains(text(),'Doctor Specialization')]")).click();
        	if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("doctorspecializationtitle"))) {
        		webdriverutility.jsScrollToBottom(driver);
        		String before = driver.findElement(By.xpath("//tr[td[contains(text(),'19.')]]/td[@class='hidden-xs']")).getText();
        		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[19]")).click();
        		if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("editdoctorspecializationtitle"))) {
        			driver.findElement(By.xpath("//input[@name='doctorspecilization']")).clear();
        			driver.findElement(By.xpath("//input[@name='doctorspecilization']")).sendKeys(fileutility.getDataFromPropertyFile("doctorspecialization"));
        			driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
        			System.out.println(driver.findElement(By.xpath("//p[@style='color:red;']")).getText());
        		}
        		driver.findElement(By.xpath("//span[contains(text(),'Doctors')]")).click();
            	driver.findElement(By.xpath("//span[contains(text(),'Doctor Specialization')]")).click();
            	String after = driver.findElement(By.xpath("//tr[td[contains(text(),'19.')]]/td[@class='hidden-xs']")).getText();
            	if(before.equals(after)) {
            		System.out.println(after+" Specialization Not Updated");
            	}else {
            		System.out.println(after+" Specialization Updated");
            	}
        	}
        	}
        }
        webdriverutility.minimizeWindow(driver);
        webdriverutility.quitBrowser(driver);
        }
}
