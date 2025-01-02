package com.hms.pom.admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.hms.generic.databaseutilities.DatabaseUtility;
import com.hms.generic.excelutilities.ExcelUtility;
import com.hms.generic.fileutilities.FileUtility;
import com.hms.generic.javautilities.JavaUtility;
import com.hms.generic.webdriverutilities.WebdriverUtility;
import com.hms.objectrepository.AdminHomePage;
import com.hms.objectrepository.LoginPage;
import com.hms.objectrepository.ReportsPage;
import com.hms.objectrepository.WelcomePage;

public class IndividualPatientReport {
	public static WebDriver driver;
	public WelcomePage welcomepage;
	public LoginPage loginpage;
	public AdminHomePage adminhomepage;
	public ReportsPage reportspage;
	@Test
	public void individualPatientReportPage() throws IOException {
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
		welcomepage = new WelcomePage(driver);
		loginpage = new LoginPage(driver);
		adminhomepage = new AdminHomePage(driver);
		reportspage = new ReportsPage(driver);
		webdriverutility.maximizeWindow(driver);
		webdriverutility.implicitwait(driver,10);
		webdriverutility.launchURL(driver, fileutility.getDataFromPropertyFile("url"));
		welcomepage.getLoginslink().click();
		welcomepage.getAdminloginbutton().click();
		webdriverutility.switchTab(driver, fileutility.getDataFromPropertyFile("adminlogintitle"));
        if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("adminlogintitle"))) {
        	loginpage.getUsernametextfield().clear();
        	loginpage.getUsernametextfield().sendKeys(fileutility.getDataFromPropertyFile("username"));
        	loginpage.getPasswordtextfield().clear();
        	loginpage.getPasswordtextfield().sendKeys(fileutility.getDataFromPropertyFile("password"));
        	loginpage.getLoginbutton().click();
        	if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"))) {
        		adminhomepage.getReportslink().click();
        		adminhomepage.getBetweendateslink().click();
        	}
        	if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("reportstitle"))) {
    			reportspage.getFromdate().sendKeys(javautility.getCalculatedDateDDMMYYY(-30));
    			reportspage.getTodate().sendKeys(javautility.getSystemDateDDMMYYYY());
    			reportspage.getSubmit().click();
    		}
    		if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("viewpatienttitle"))) {
    			if(reportspage.getHeader().getText().contains(javautility.getCalculatedDateYYYYMMDD(-30))) {
    				System.out.println("Reports have been generated");
    				reportspage.getReportviewlink().click();
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
    
    webdriverutility.minimizeWindow(driver);
   webdriverutility.quitBrowser(driver);
	}

}
