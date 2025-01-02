package com.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	private WebElement dashboardlink;
	
	@FindBy(xpath = "//span[contains(text(),'Doctors')]")
	private WebElement doctorslink;
	
	@FindBy(xpath = "//span[contains(text(),'Doctor Specialization')]")
	private WebElement doctorspecializationlink;
	
	@FindBy(xpath = "//span[contains(text(),'Add Doctor')]")
	private WebElement adddoctorlink;
	
	@FindBy(xpath = "//span[contains(text(),'Manage Doctors')]")
	private WebElement managedoctorlink;
	
	@FindBy(xpath = "//span[contains(text(),'Users')]")
	private WebElement userslink;
	
	@FindBy(xpath = "//span[contains(text(),'Manage Users')]")
	private WebElement manageuserslink;
	
	@FindBy(xpath = "//span[contains(text(),'Patients')]")
	private WebElement patientslink;
	
	@FindBy(xpath = "//span[contains(text(),'Manage Patients')]")
	private WebElement managepatientslink;
	
	@FindBy(xpath = "//span[contains(text(),'Appointment History')]")
	private WebElement appointmenthistorylink;
	
	@FindBy(xpath = "//span[contains(text(),'Conatctus Queries')]")
	private WebElement conatctusquerieslink;
	
	@FindBy(xpath = "//span[contains(text(),'Unread Query')]")
	private WebElement unreadquerylink;
	
	@FindBy(xpath = "//span[contains(text(),'Read Query')]")
	private WebElement readquerylink;
	
	@FindBy(xpath = "//span[contains(text(),'Doctor Session Logs')]")
	private WebElement doctorsessionlogslink;
	
	@FindBy(xpath = "//span[contains(text(),'User Session Logs')]")
	private WebElement usersessionlogslink;
	
	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	private WebElement reportslink;
	
	@FindBy(xpath = "//span[contains(text(),'B/w dates reports')]")
	private WebElement betweendateslink;
	
	@FindBy(xpath = "//span[contains(text(),'Pages')]")
	private WebElement pageslink;
	
	@FindBy(xpath = "//span[contains(text(),'About Us')]")
	private WebElement aboutuslink;
	
	@FindBy(xpath = "//span[contains(text(),'Cotnact Us')]")
	private WebElement contactuslink;
	
	@FindBy(xpath = "//span[contains(text(),'Patient Search')]")
	private WebElement patientsearchlink;
	
	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement profiledropdown;
	
	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	private WebElement changepasswordlink;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logoutlink;
	
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDashboardlink() {
		return dashboardlink;
	}

	public WebElement getDoctorslink() {
		return doctorslink;
	}

	public WebElement getDoctorspecializationlink() {
		return doctorspecializationlink;
	}

	public WebElement getAdddoctorlink() {
		return adddoctorlink;
	}

	public WebElement getManagedoctorlink() {
		return managedoctorlink;
	}

	public WebElement getUserslink() {
		return userslink;
	}

	public WebElement getManageuserslink() {
		return manageuserslink;
	}

	public WebElement getPatientslink() {
		return patientslink;
	}

	public WebElement getManagepatientslink() {
		return managepatientslink;
	}

	public WebElement getAppointmenthistorylink() {
		return appointmenthistorylink;
	}

	public WebElement getConatctusquerieslink() {
		return conatctusquerieslink;
	}

	public WebElement getUnreadquerylink() {
		return unreadquerylink;
	}

	public WebElement getReadquerylink() {
		return readquerylink;
	}

	public WebElement getDoctorsessionlogslink() {
		return doctorsessionlogslink;
	}

	public WebElement getUsersessionlogslink() {
		return usersessionlogslink;
	}

	public WebElement getReportslink() {
		return reportslink;
	}

	public WebElement getBetweendateslink() {
		return betweendateslink;
	}

	public WebElement getPageslink() {
		return pageslink;
	}

	public WebElement getAboutuslink() {
		return aboutuslink;
	}

	public WebElement getContactuslink() {
		return contactuslink;
	}

	public WebElement getPatientsearchlink() {
		return patientsearchlink;
	}

	public WebElement getProfiledropdown() {
		return profiledropdown;
	}

	public WebElement getChangepasswordlink() {
		return changepasswordlink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	public void logout() {
		getProfiledropdown().click();
		getLogoutlink().click();
	}
	
	public void betweendateslink() {
		getReportslink().click();
		getBetweendateslink().click();
	}
	
	public void managepatientlink() {
		getPatientslink().click();
		getManagepatientslink().click();
	}
	
	public void manageuserlink() {
		getUserslink().click();
		getManageuserslink().click();
	}
	
	public void editdoctorspecializationlink() {
		getDoctorslink().click();
		getDoctorspecializationlink().click();
	}
}
