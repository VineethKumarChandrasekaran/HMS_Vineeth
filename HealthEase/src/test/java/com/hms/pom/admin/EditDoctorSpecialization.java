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
import com.hms.objectrepository.DoctorSpecializationPage;
import com.hms.objectrepository.LoginPage;
import com.hms.objectrepository.ReportsPage;
import com.hms.objectrepository.WelcomePage;

public class EditDoctorSpecialization {
	public static WebDriver driver;
	public WelcomePage welcomepage;
	public LoginPage loginpage;
	public AdminHomePage adminhomepage;
	public ReportsPage reportspage;
	public DoctorSpecializationPage doctorspecializationpage;
	@Test
	public void editDoctorSpecializationPage() throws IOException {
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
		doctorspecializationpage = new DoctorSpecializationPage(driver);
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
        		adminhomepage.getDoctorslink().click();
        		adminhomepage.getDoctorspecializationlink().click();
            	if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("doctorspecializationtitle"))) {
            		webdriverutility.jsScrollToBottom(driver);
            		String before = doctorspecializationpage.getDoctorspecializationtext().getText();
            		doctorspecializationpage.getEditbutton().click();
            		if(webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("editdoctorspecializationtitle"))) {
            			doctorspecializationpage.getDoctorspecilizationtextfield().clear();
            			doctorspecializationpage.getDoctorspecilizationtextfield().sendKeys(fileutility.getDataFromPropertyFile("doctorspecialization"));
            			doctorspecializationpage.getUpdatebutton().click();
            			System.out.println(driver.findElement(By.xpath("//p[@style='color:red;']")).getText());
            		}
            		adminhomepage.getDoctorslink().click();
            		adminhomepage.getDoctorspecializationlink().click();
                	String after = doctorspecializationpage.getDoctorspecializationtext().getText();
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
