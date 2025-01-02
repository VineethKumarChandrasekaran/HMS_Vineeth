package com.hms.base.admin;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hms.generic.baseclassutility.BaseClass;
import com.hms.generic.listenerutilities.UtilityObject;
import com.hms.objectrepository.AdminHomePage;

public class UserSessionLogs extends BaseClass {
	public AdminHomePage adminhomepage;
	@Test(groups = "smoke")
	public void userlogs() throws IOException {
		adminhomepage = new AdminHomePage(driver);
		boolean dasboard = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("dashboardtitle"));
		Assert.assertTrue(dasboard);
		adminhomepage.getUsersessionlogslink().click();
		boolean usersession = webdriverutility.getPageTitle(driver).contains(fileutility.getDataFromPropertyFile("usersessiontitle"));
		Assert.assertTrue(usersession);
		UtilityObject.getTest().log(Status.INFO,"User Session Logs has been displayed");
}
}
