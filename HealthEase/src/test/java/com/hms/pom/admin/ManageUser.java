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

public class ManageUser {
	public static WebDriver driver;
	public WelcomePage welcomepage;
	public LoginPage loginpage;
	public AdminHomePage adminhomepage;
	public ReportsPage reportspage;
	@Test
	public void manageUserPage() throws IOException {
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
        		adminhomepage.getUserslink().click();
        		adminhomepage.getManageuserslink().click();
        	}
        	if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("manageusertitle"))) {
        		System.out.println("Manage Users page has been displayed");
        	}else {
        		System.out.println("Manage Users page has not been displayed");
        	}
            webdriverutility.minimizeWindow(driver);
          webdriverutility.quitBrowser(driver);
    	}

	}

	}

