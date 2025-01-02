package com.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homepagelink;

	@FindBy(xpath = "//a[text()='Services']")
	private WebElement serviceslink;
	
	@FindBy(xpath = "//a[text()='About Us']")
	private WebElement aboutuslink;
	
	@FindBy(xpath = "//a[text()='Gallery']")
	private WebElement gallerylink;
	
	@FindBy(xpath = "//a[text()='Contact Us']")
	private WebElement contactuslink;
	
	@FindBy(xpath = "//a[text()='Logins']")
	private WebElement loginslink;
	
	@FindBy(xpath = "//a[text()='Book an Appointment']")
	private WebElement bookappointmentlink;
	
	@FindBy(xpath = "(//button[text()='Click Here'])[1]")
	private WebElement patientloginbutton;
	
	@FindBy(xpath = "(//button[text()='Click Here'])[2]")
	private WebElement doctorloginbutton;
	
	@FindBy(xpath = "(//button[text()='Click Here'])[3]")
	private WebElement adminloginbutton;
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomepagelink() {
		return homepagelink;
	}

	public WebElement getServiceslink() {
		return serviceslink;
	}

	public WebElement getAboutuslink() {
		return aboutuslink;
	}

	public WebElement getGallerylink() {
		return gallerylink;
	}

	public WebElement getContactuslink() {
		return contactuslink;
	}

	public WebElement getLoginslink() {
		return loginslink;
	}

	public WebElement getBookappointmentlink() {
		return bookappointmentlink;
	}

	public WebElement getPatientloginbutton() {
		return patientloginbutton;
	}

	public WebElement getDoctorloginbutton() {
		return doctorloginbutton;
	}

	public WebElement getAdminloginbutton() {
		return adminloginbutton;
	}
	
}
