package com.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage {
	
	@FindBy(id = "fromdate")
	private WebElement fromdate;
	
	@FindBy(id = "todate")
	private WebElement todate;
	
	@FindBy(id = "submit")
	private WebElement submit;
	
	@FindBy(xpath = "(//i[@class='fa fa-eye'])[1]")
	private WebElement reportviewlink;
	
	@FindBy(xpath = "//h5[@align='center']")
	private WebElement header;
	
	public ReportsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFromdate() {
		return fromdate;
	}

	public WebElement getTodate() {
		return todate;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getReportviewlink() {
		return reportviewlink;
	}

	public WebElement getHeader() {
		return header;
	}
	
	public void reportDate(String fromdate, String todate) {
		getFromdate().sendKeys(fromdate);
	    getTodate().sendKeys(todate);
		getSubmit().click();
	}
}
