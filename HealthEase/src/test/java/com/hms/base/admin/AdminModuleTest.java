package com.hms.base.admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hms.generic.baseclassutility.BaseClass;
import com.hms.generic.listenerutilities.UtilityObject;
import com.hms.objectrepository.AdminHomePage;
import com.hms.objectrepository.DoctorSpecializationPage;
import com.hms.objectrepository.ReportsPage;

/**
 * @author Vineeth Kumar C
 */

@Listeners(com.hms.generic.listenerutilities.ListenerUtility.class)
public class AdminModuleTest extends BaseClass {
	
	public AdminHomePage adminhomepage;
	public ReportsPage reportspage;
	public DoctorSpecializationPage doctorspecializationpage;

	@Test(priority = 0, groups = "smoke")
	public void managePatientPage() throws IOException {
		adminhomepage = new AdminHomePage(driver);
		boolean dasboard = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"));
		Assert.assertTrue(dasboard);
		adminhomepage.managepatientlink();
		boolean viewpatient = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("viewpatienttitle"));
		Assert.assertTrue(viewpatient);
		UtilityObject.getTest().log(Status.INFO,"Manage Patient page has been displayed");
}
	
	@Test(priority = 1, groups = "smoke")
	public void manageUserPage() throws IOException {
		adminhomepage = new AdminHomePage(driver);
		boolean dasboard = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"));
		Assert.assertTrue(dasboard);
		adminhomepage.manageuserlink();
		boolean manageuser = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("manageusertitle"));
		Assert.assertTrue(manageuser);
		UtilityObject.getTest().log(Status.INFO,"Manage Users page has been displayed");
}
	
	@Test(priority = 2, groups = "smoke")
	public void userlogs() throws IOException {
		adminhomepage = new AdminHomePage(driver);
		boolean dasboard = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"));
		Assert.assertTrue(dasboard);
		adminhomepage.getUsersessionlogslink().click();
		boolean usersession = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("usersessiontitle"));
		Assert.assertTrue(usersession);
		UtilityObject.getTest().log(Status.INFO,"User Session Logs has been displayed");
}
	
	@Test(priority = 3, groups = "regression")
	public void patientReportsPage() throws IOException {
		adminhomepage = new AdminHomePage(driver);
		reportspage = new ReportsPage(driver);
		boolean dasboard = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"));
		Assert.assertTrue(dasboard);
		adminhomepage.betweendateslink();
		boolean reports = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("reportstitle"));
		Assert.assertTrue(reports);
		reportspage.reportDate(javautility.getCalculatedDateDDMMYYY(-30), javautility.getSystemDateDDMMYYYY());
		boolean viewpatient = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("viewpatienttitle"));
		Assert.assertTrue(viewpatient);
		boolean headerdate = reportspage.getHeader().getText().contains(javautility.getCalculatedDateYYYYMMDD(-30));
		Assert.assertTrue(headerdate);
		UtilityObject.getTest().log(Status.INFO,"Reports have been generated");
}

	@Test(priority = 4, groups = "regression")
	public void individualPatientReportPage() throws IOException {
		adminhomepage = new AdminHomePage(driver);
		reportspage = new ReportsPage(driver);
		boolean dasboard = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"));
		Assert.assertTrue(dasboard);
		adminhomepage.betweendateslink();
		boolean reports = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("reportstitle"));
		Assert.assertTrue(reports);
		reportspage.reportDate(javautility.getCalculatedDateDDMMYYY(-30), javautility.getSystemDateDDMMYYYY());
		boolean viewpatient = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("viewpatienttitle"));
		Assert.assertTrue(viewpatient);
		boolean headerdate = reportspage.getHeader().getText().contains(javautility.getCalculatedDateYYYYMMDD(-30));
		Assert.assertTrue(headerdate);
		UtilityObject.getTest().log(Status.INFO,"Reports have been generated");
		reportspage.getReportviewlink().click();
		boolean individualreport = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("individualpatienttitle"));
		Assert.assertTrue(individualreport);
		UtilityObject.getTest().log(Status.INFO,"Individual Reports has been generated");
}
	
	@Test(priority = 5, groups = "regression")
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
