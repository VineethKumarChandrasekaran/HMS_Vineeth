package com.hms.base.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hms.generic.baseclassutility.BaseClass;
import com.hms.generic.listenerutilities.UtilityObject;
import com.hms.objectrepository.AdminHomePage;

public class ManagePatient extends BaseClass {

	public AdminHomePage adminhomepage;
	@Test(groups = "smoke")
	public void managePatientPage() throws IOException {
		adminhomepage = new AdminHomePage(driver);
		boolean dasboard = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"));
		Assert.assertTrue(dasboard);
		adminhomepage.managepatientlink();
		boolean viewpatient = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("viewpatienttitle"));
		Assert.assertTrue(viewpatient);
		UtilityObject.getTest().log(Status.INFO,"Manage Patient page has been displayed");
	}
}
