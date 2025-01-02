package com.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name = "username")
	private WebElement usernametextfield;
	
	@FindBy(name = "password")
	private WebElement passwordtextfield;
	
	@FindBy(name = "submit")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//a[text()='Bacto Home Page']")
	private WebElement backtohomepagelink;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernametextfield() {
		return usernametextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public WebElement getBacktohomepagelink() {
		return backtohomepagelink;
	}
	
	public void login(String username, String password) {
		getUsernametextfield().clear();
		getUsernametextfield().sendKeys(username);
		getPasswordtextfield().clear();
		getPasswordtextfield().sendKeys(password);
		getLoginbutton().click();
	}

}
