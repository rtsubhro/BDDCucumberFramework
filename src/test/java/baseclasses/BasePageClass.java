package baseclasses;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageclasses.LandingPage;
import utils.TestContextSetup;

public class BasePageClass extends BaseTestClass {
	
	//public ExtentTest logger;

	public BasePageClass(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		this.driver = driver;
		this.logger = logger;
		//PageFactory.initElements(driver, this);
	}

	/**
	 * Open Application
	 * 
	 * @param websiteURLKey
	 */
	public LandingPage openApplication(String websiteURL) {
		try {
			logger.log(Status.INFO, "Opening the website : " + websiteURL);
						
			driver.get(websiteURL);
			// logger.log(Status.PASS, "Successfully opened the website : " + websiteURL);
			reportPass(websiteURL + " URL identified and opened successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
		}
		// waitForPageLoad();
		
		LandingPage landingPage = new LandingPage(driver, logger);
		
		PageFactory.initElements(driver, landingPage);
		return landingPage;
		// return PageFactory.initElements(driver, LandingPage.class);
	}

	/**
	 * Gets The Page Title
	 * 
	 * @param expectedValue
	 */
	public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			reportPass(
					"Actual Page Title : " + driver.getTitle() + " - equals - Expected Page Title : " + expectedTitle);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Accept Java Script Alert ***********************/
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			// logger.log(Status.PASS, "Page Alert Accepted");
			reportPass("Page Alert Accepted");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Cancel Java Script Alert ***********************/
	public void cancelAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			// logger.log(Status.PASS, "Page Alert Rejected");
			reportPass("Page Alert Rejected");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Select value From DropDown ***********************/
	public void selectDropDownValue(WebElement webElement, String optionValue) {
		try {
			Select select = new Select(webElement);
			select.selectByVisibleText(optionValue);
			// logger.log(Status.PASS, "Selected the option : " + optionValue);
			reportPass("Selected the option : " + optionValue);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Verify Element is Present ***********************/
	public void veriyElementIsDisplayed(WebElement webElement) {
		try {
			if (webElement.isDisplayed()) {
				reportPass(webElement + " is displayed");
			} else {
				reportFail(webElement + " is not displayed");
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Get All Elements of DropDown ***********************/
	public List<WebElement> getAllElementsOfDropDown(WebElement webElement) {
		try {
			Select select = new Select(webElement);
			List<WebElement> allElements = select.getOptions();
			return allElements;
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return null;
	}

	/*********************
	 * Reporting Functions
	 *************************************/

	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		//takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	/**
	 * Close the Browser Window
	 */
	public void tearDown() {
		driver.close();
	}

	/**
	 * Quit the Browser
	 */
	public void quitBrowser() {
		driver.quit();
	}

}
