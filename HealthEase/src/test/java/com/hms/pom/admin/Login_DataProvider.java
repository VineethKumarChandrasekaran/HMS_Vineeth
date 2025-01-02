package com.hms.pom.admin;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

public class Login_DataProvider {
	public static WebDriver driver;
	public WelcomePage welcomepage;
	public LoginPage loginpage;
	public AdminHomePage adminhomepage;
	public ReportsPage reportspage;
	public FileUtility fileutility;
	public ExcelUtility excelutitilty;
	public JavaUtility javautility;
	public WebdriverUtility webdriverutility;
	public DatabaseUtility databaseutility;

	@Test(dataProvider = "login")
	public void managePatientPage(String browser, String module, String username, String password) throws IOException {
		fileutility = new FileUtility();
		excelutitilty = new ExcelUtility();
		javautility = new JavaUtility();
		webdriverutility = new WebdriverUtility();
		databaseutility = new DatabaseUtility();
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
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
		if (module.equalsIgnoreCase("admin")) {
			welcomepage.getLoginslink().click();
			welcomepage.getAdminloginbutton().click();
			webdriverutility.switchTab(driver, fileutility.getDataFromPropertyFile("adminlogintitle"));
			if (webdriverutility.getPageTitle(driver)
					.contains(fileutility.getDataFromPropertyFile("adminlogintitle"))) {
				loginpage.getUsernametextfield().clear();
				loginpage.getUsernametextfield().sendKeys(fileutility.getDataFromPropertyFile("username"));
				loginpage.getPasswordtextfield().clear();
				loginpage.getPasswordtextfield().sendKeys(fileutility.getDataFromPropertyFile("password"));
				loginpage.getLoginbutton().click();
				if (webdriverutility.getPageTitle(driver)
						.contains(fileutility.getDataFromPropertyFile("dashboardtitle"))) {
					System.out.println("Admin Home Page got displayed");
				} else {
					System.out.println("Admin Home Page not got displayed");
				}
			} else if (module.equalsIgnoreCase("patient")) {
				welcomepage.getLoginslink().click();
				welcomepage.getPatientloginbutton().click();
				webdriverutility.switchTab(driver, fileutility.getDataFromPropertyFile("adminlogintitle"));
				if (webdriverutility.getPageTitle(driver)
						.contains(fileutility.getDataFromPropertyFile("adminlogintitle"))) {
					loginpage.getUsernametextfield().clear();
					loginpage.getUsernametextfield().sendKeys(fileutility.getDataFromPropertyFile("username"));
					loginpage.getPasswordtextfield().clear();
					loginpage.getPasswordtextfield().sendKeys(fileutility.getDataFromPropertyFile("password"));
					loginpage.getLoginbutton().click();
					if (webdriverutility.getPageTitle(driver)
							.contains(fileutility.getDataFromPropertyFile("dashboardtitle"))) {
						System.out.println("Admin Home Page got displayed");
					} else {
						System.out.println("Admin Home Page not got displayed");
					}
				} else {
					welcomepage.getLoginslink().click();
					welcomepage.getDoctorloginbutton().click();
					webdriverutility.switchTab(driver, fileutility.getDataFromPropertyFile("adminlogintitle"));
					if (webdriverutility.getPageTitle(driver)
							.contains(fileutility.getDataFromPropertyFile("adminlogintitle"))) {
						loginpage.getUsernametextfield().clear();
						loginpage.getUsernametextfield().sendKeys(fileutility.getDataFromPropertyFile("username"));
						loginpage.getPasswordtextfield().clear();
						loginpage.getPasswordtextfield().sendKeys(fileutility.getDataFromPropertyFile("password"));
						loginpage.getLoginbutton().click();
						if (webdriverutility.getPageTitle(driver)
								.contains(fileutility.getDataFromPropertyFile("dashboardtitle"))) {
							System.out.println("Admin Home Page got displayed");
						} else {
							System.out.println("Admin Home Page not got displayed");
						}
					}

				}
			}
			webdriverutility.minimizeWindow(driver);
			webdriverutility.quitBrowser(driver);
		}
	}

	@DataProvider(name = "login")
	public Object[][] logindata() throws EncryptedDocumentException, IOException {
		excelutitilty = new ExcelUtility();
		int rowcount = excelutitilty.getRowCount("Login");
		Object[][] object = new Object[rowcount][4];
		for (int i = 0; i < rowcount; i++) {
			object[i][0] = excelutitilty.getDataFromExcel("Login", i + 1, 0);
			object[i][1] = excelutitilty.getDataFromExcel("Login", i + 1, 1);
			object[i][2] = excelutitilty.getDataFromExcel("Login", i + 1, 2);
			object[i][3] = excelutitilty.getDataFromExcel("Login", i + 1, 3);
		}
		return object;
	}
}
