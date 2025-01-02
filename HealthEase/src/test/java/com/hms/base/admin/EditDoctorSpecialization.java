package com.hms.base.admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hms.generic.baseclassutility.BaseClass;
import com.hms.generic.databaseutilities.DatabaseUtility;
import com.hms.generic.excelutilities.ExcelUtility;
import com.hms.generic.fileutilities.FileUtility;
import com.hms.generic.javautilities.JavaUtility;
import com.hms.generic.listenerutilities.UtilityObject;
import com.hms.generic.webdriverutilities.WebdriverUtility;
import com.hms.objectrepository.AdminHomePage;
import com.hms.objectrepository.DoctorSpecializationPage;
import com.hms.objectrepository.LoginPage;
import com.hms.objectrepository.ReportsPage;
import com.hms.objectrepository.WelcomePage;

public class EditDoctorSpecialization extends BaseClass {
	public AdminHomePage adminhomepage;
	public DoctorSpecializationPage doctorspecializationpage;

	@Test(groups = "regression")
	public void editDoctorSpecializationPage() throws IOException {
		adminhomepage = new AdminHomePage(driver);
		doctorspecializationpage = new DoctorSpecializationPage(driver);
		boolean dasboard = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"));
		Assert.assertTrue(dasboard);
		adminhomepage.editdoctorspecializationlink();
		boolean doctorspecialization = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("doctorspecializationtitle"));
		Assert.assertTrue(doctorspecialization);
		webdriverutility.jsScrollToBottom(driver);
		String before = doctorspecializationpage.getDoctorspecializationtext().getText();
		doctorspecializationpage.getEditbutton().click();
		boolean editdoctorspecialization = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("editdoctorspecializationtitle"));
		Assert.assertTrue(editdoctorspecialization);
		doctorspecializationpage.editDoctorSpecilization(fileutility.getDataFromPropertyFile("doctorspecialization"));
		UtilityObject.getTest().log(Status.INFO,driver.findElement(By.xpath("//p[@style='color:red;']")).getText());
		adminhomepage.editdoctorspecializationlink();
		String after = doctorspecializationpage.getDoctorspecializationtext().getText();
		Assert.assertNotEquals(before, after);
		UtilityObject.getTest().log(Status.INFO,after + " Specialization Updated");
}
}