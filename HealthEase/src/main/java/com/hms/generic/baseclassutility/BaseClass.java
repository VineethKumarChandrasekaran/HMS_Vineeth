package com.hms.generic.baseclassutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.hms.generic.databaseutilities.DatabaseUtility;
import com.hms.generic.excelutilities.ExcelUtility;
import com.hms.generic.fileutilities.FileUtility;
import com.hms.generic.javautilities.JavaUtility;
import com.hms.generic.listenerutilities.UtilityObject;
import com.hms.generic.webdriverutilities.WebdriverUtility;
import com.hms.objectrepository.AdminHomePage;
import com.hms.objectrepository.LoginPage;
import com.hms.objectrepository.WelcomePage;

public class BaseClass {
	public FileUtility fileutility = new FileUtility();
	public ExcelUtility excelutility = new ExcelUtility();
	public WebdriverUtility webdriverutility = new WebdriverUtility();
	public JavaUtility javautility = new JavaUtility();
	public DatabaseUtility databaseutility = new DatabaseUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"regression","smoke"})
	public void beforeSuite() throws SQLException {
	   databaseutility.getDBConnection(null, null, null);
	}
	
	 @Parameters("browser")
		@BeforeClass(groups = {"regression","smoke"})
		public void beforeClass(@Optional("chrome") String browser) throws IOException {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			webdriverutility.maximizeWindow(driver);
			webdriverutility.implicitwait(driver,10);
			webdriverutility.launchURL(driver, fileutility.getDataFromPropertyFile("url"));
			sdriver = driver;
			UtilityObject.setDriver(driver);
		}
	
	@BeforeMethod(groups = {"regression","smoke"})
	public void beforeMethod() throws IOException {
		WelcomePage welcomepage = new WelcomePage(driver);
		welcomepage.getLoginslink().click();
		welcomepage.getAdminloginbutton().click();
		webdriverutility.switchTab(driver, fileutility.getDataFromPropertyFile("adminlogintitle"));
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(fileutility.getDataFromPropertyFile("username"), fileutility.getDataFromPropertyFile("password"));  
	}
	
	@AfterMethod(groups = {"regression","smoke"})
	public void afterMethod() {
		AdminHomePage homepage = new AdminHomePage(driver);
		homepage.logout();
	}
	
	@AfterClass(groups = {"regression","smoke"})
	public void afterClass() {
		webdriverutility.minimizeWindow(driver);
		webdriverutility.quitBrowser(driver);
	}
	
	@AfterSuite(groups = {"regression","smoke"})
	public void afterSuite() {
		databaseutility.closeDBConnection();
	}
}
