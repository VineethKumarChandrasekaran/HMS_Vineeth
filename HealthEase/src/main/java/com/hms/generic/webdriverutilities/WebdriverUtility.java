package com.hms.generic.webdriverutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author VineethKumar
 */
public class WebdriverUtility {

	// This method is used to maximize the window
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// This method is used to minimize the window
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	// This method is used to navigate to next page
	public void navigatenextpage(WebDriver driver) {
		driver.navigate().forward();
	}

	// This method is used to navigate to next page
	public void navigatepreviouspage(WebDriver driver) {
		driver.navigate().back();
	}

	// This method is used to refresh
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	// This method is used for implicit wait
	public void implicitwait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	// This method is used for trigger url
	public void launchURL(WebDriver driver, String url) {
		driver.get(url);
	}

	// This method is used to get the Page Title
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	// This method is used to get the Page URL
	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	// This method is used for explicit wait until title get displayed
	public void explicitwaitTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs(title));
	}

	// This method is used for explicit wait until url get displayed
	public void explicitwaitUrl(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlToBe(url));
	}

	// This method is used for explicit wait until element get displayed
	public void explicitwaitElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// This method is used to capture the size of the window
	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();
	}

	// This method is used to capture the position of the element
	public Point getPosition(WebDriver driver, WebElement element) {
		return element.getLocation();
	}

	// This method is used to switch windows
	public void switchWindow(WebDriver driver, String url) {
		// Capturing the Window ids
		Set<String> windows = driver.getWindowHandles();
		// Navigate to all the windows
		for (String wid : windows) {
			driver.switchTo().window(wid);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(url)) {
				break;
			}
		}
	}

	// This method is used to switch tabs
	public void switchTab(WebDriver driver, String title) {
		Set<String> windows = driver.getWindowHandles();
		List<String> tabs = new ArrayList<>(windows);
		for (String tab : tabs) {
			driver.switchTo().window(tab);
			String acttitle = driver.getTitle();
			if (acttitle.contains(title)) {
				break;
			}
		}
	}

	// This method is used to right click
	public void rightClick(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick().perform();
	}

	// This method is used to double click
	public void doubleClick(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick().perform();
	}

	// This method is used to double click on Webelement
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// This method is used to click&hold
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}

	// This method is used to mouse hover on element
	public void mouseHoverElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// This method is used to mouse hover on element using offsets
	public void mouseHoverElement(WebDriver driver, WebElement element, int x, int y) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element, x, y).perform();
	}

	// This method is used to drag and drop
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	// This method is used to drag and drop
	public void dragAndDrop(WebDriver driver, WebElement element, int x, int y) {
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(element, x, y).perform();
	}

	// This method is used to scroll to element
	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(element).perform();
	}

	// This method is used to scroll to element
	public void scrollByAmount(WebDriver driver, int x, int y) {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(x, y).perform();
	}

	// This method is used to scroll to element with Point
	public void scrollByAmount(WebDriver driver, Point point) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0]);", point.getY());
	}

	// This method is used to scroll to element with Point
	public Point getLocation(WebElement element) {
		return element.getLocation();
	}

	// This method is used to scroll to element with Point Width
	public int getLocationWidth(WebElement element) {
		return element.getLocation().getX();
	}

	// This method is used to scroll to element with Point Width
	public int getLocationHeight(WebElement element) {
		return element.getLocation().getY();
	}

	// This method is used to switchTo Frame by WebElement
	public void switchToFrame(WebDriver driver, WebElement frame) {
		driver.switchTo().frame(frame);
	}

	// This method is used to switchTo Frame by Index
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	// This method is used to switchTo Frame by ID
	public void switchToFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	// This method is used to switchTo Parentframe
	public void switchToFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	// This method is used to select dropdown by ID
	public void selectDropdownByIndex(WebDriver driver, WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// This method is used to select dropdown by value
	public void selectDropdownByValue(WebDriver driver, WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// This method is used to select dropdown by visibleText
	public void selectDropdownByText(WebDriver driver, WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// This method is used to switchTo Alert
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	// This method is used to switchTo Alert and Accept
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// This method is used to switchTo Alert and Dismiss
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// This method is used to switchTo Alert and Send Data
	public void switchToAlertAndSendData(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	// This method is used to switchTo Alert and Get Text
	public String switchToAlertAndSendData(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	// This method is used to scroll using Javascript Executor
	public void jsScroll(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	// This method is used to click using Javascript Executor
	public void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", element);
	}

	// This method is used to scroll to bottom using Javascript Executor
	public void jsScrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// This method is used to TakeScreenshot with TimeStamp
	public void takeScreenshot(WebDriver driver, String timestamp, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempscreenshot = ts.getScreenshotAs(OutputType.FILE);
		File permanentscreenshot = new File("./Screenshots/ "+ screenshotname +"_"+ timestamp + ".png");
		FileUtils.copyFile(tempscreenshot, permanentscreenshot);
	}

	// This method is used to quit the browser
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	// This method is used to close the browser
	public void closeBrowser(WebDriver driver) {
		driver.close();
	}
}
