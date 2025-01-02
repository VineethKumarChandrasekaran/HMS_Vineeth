package com.hms.base.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hms.generic.baseclassutility.BaseClass;
import com.hms.generic.listenerutilities.UtilityObject;
import com.hms.objectrepository.AdminHomePage;
import com.hms.objectrepository.ReportsPage;

public class PatientReports extends BaseClass {
	public AdminHomePage adminhomepage;
	public ReportsPage reportspage;

	@Test(groups = "regression")
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
}
