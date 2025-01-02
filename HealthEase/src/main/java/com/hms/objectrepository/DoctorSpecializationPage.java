package com.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorSpecializationPage {
	
	@FindBy(xpath = "//tr[td[contains(text(),'19.')]]/td[@class='hidden-xs']")
	private WebElement doctorspecializationtext;
	
	@FindBy(xpath = "(//i[@class='fa fa-pencil'])[19]")
	private WebElement editbutton;
	
	@FindBy(xpath = "//input[@name='doctorspecilization']")
	private WebElement doctorspecilizationtextfield;
	
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement updatebutton;
	
	public DoctorSpecializationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDoctorspecializationtext() {
		return doctorspecializationtext;
	}

	public WebElement getEditbutton() {
		return editbutton;
	}

	public WebElement getDoctorspecilizationtextfield() {
		return doctorspecilizationtextfield;
	}

	public WebElement getUpdatebutton() {
		return updatebutton;
	}

	public void editDoctorSpecilization(String specialization) {
		getDoctorspecilizationtextfield().clear();
		getDoctorspecilizationtextfield().sendKeys(specialization);
		getUpdatebutton().click();
	}
}
