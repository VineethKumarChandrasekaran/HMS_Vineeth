package com.hms.base.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hms.generic.baseclassutility.BaseClass;
import com.hms.generic.listenerutilities.UtilityObject;
import com.hms.objectrepository.AdminHomePage;

public class ManageUser extends BaseClass {
	
	public AdminHomePage adminhomepage;
	@Test(groups = "smoke")
	public void manageUserPage() throws IOException {
		adminhomepage = new AdminHomePage(driver);
		boolean dasboard = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"));
		Assert.assertTrue(dasboard);
		adminhomepage.manageuserlink();
		boolean manageuser = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("manageusertitle"));
		Assert.assertTrue(manageuser);
		UtilityObject.getTest().log(Status.INFO,"Manage Users page has been displayed");
}

	}

