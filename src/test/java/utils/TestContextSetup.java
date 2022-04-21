package utils;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import baseclasses.BaseTestClass;
import pageclasses.CheckoutPage;
import pageclasses.LandingPage;
import pageclasses.PageObjectManager;
import pageclasses.TopDealsPage;
import stepdefinitions.CheckoutPageTestDefinitions;
import stepdefinitions.LandingPageTestDefinitions;

public class TestContextSetup {

	public WebDriver driver;

	public ExtentTest logger;

	public PageObjectManager pageObjectManager;

	public BaseTestClass baseTestClass;

	public LandingPage landingPage;

	public String landingPage_ProductName;

	public TopDealsPage topDealsPage;

	public String topDealsPage_ProductName;

	public CheckoutPage checkoutPage;

	public String checkoutPage_ProductName;

	public int checkoutPage_Quantity;

	public TestContextSetup() {
		pageObjectManager = new PageObjectManager(driver, logger);

		baseTestClass = new BaseTestClass(driver, logger);
	}

}
