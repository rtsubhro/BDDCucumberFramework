package stepdefinitions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import baseclasses.BaseTestClass;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageclasses.TopDealsPage;
import utils.CaptureScreenshot;
import utils.TestContextSetup;

public class TopDealsPageTestDefinitions extends BaseTestClass {

	TestContextSetup testContextSetup;

	// public TopDealsPage topDealsPage;

	// public String topDealsPage_ProductName;

	public TopDealsPageTestDefinitions(TestContextSetup testContextSetup) {
		super(testContextSetup.driver, testContextSetup.logger);
		this.testContextSetup = testContextSetup;
	}
	
	/*public TopDealsPageTestDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}*/

	@Then("^actual product name on both Landing Page and Top Deals Page should match$")
	public void actual_product_name_on_both_landing_page_and_top_deals_page_should_match() throws Throwable {

		testContextSetup.logger.log(Status.INFO,
				"Top Deals Page Product Name is : " + testContextSetup.topDealsPage_ProductName);
		testContextSetup.logger.log(Status.INFO,
				"Landing Page Product Name is : " + testContextSetup.landingPage_ProductName);

		try {
			Assert.assertEquals(testContextSetup.landingPage_ProductName, testContextSetup.topDealsPage_ProductName);
			testContextSetup.logger.pass("Landing Page Product Name: " + testContextSetup.landingPage_ProductName
					+ " matches Top Deals Page Product Name: " + testContextSetup.topDealsPage_ProductName);
		} catch (AssertionError e) {
			testContextSetup.logger.fail("Landing Page Product Name: " + testContextSetup.landingPage_ProductName
					+ " does not match Top Deals Page Product Name: " + testContextSetup.topDealsPage_ProductName);
			Assert.fail("Landing Page Product Name: " + testContextSetup.landingPage_ProductName
					+ " does not match Top Deals Page Product Name: " + testContextSetup.topDealsPage_ProductName);
		}

	}

	@And("^User also searches for a product on Top Deals page with the same shortname (.+) and actual product name is extracted$")
	public void user_also_searches_for_a_product_on_top_deals_page_with_the_same_shortname_something_and_actual_product_name_is_extracted(
			String strArg1) throws Throwable {

		testContextSetup.topDealsPage = testContextSetup.landingPage.clickTopDealsLink();

		Thread.sleep(2000);

		testContextSetup.topDealsPage = testContextSetup.topDealsPage.enterProductShortName(strArg1);

		Thread.sleep(2000);

		testContextSetup.topDealsPage = testContextSetup.topDealsPage.retrieveAndSetProductName();

		Thread.sleep(2000);

		testContextSetup.topDealsPage_ProductName = testContextSetup.topDealsPage.getProductName();
	}

	/*
	 * @After public void SetTestResult() {
	 * 
	 * 
	 * String screenShotPath = CaptureScreenshot.takeScreenShot(driver,
	 * CaptureScreenshot.generateScreenshotFileName(result));
	 * 
	 * if (result.getStatus() == ITestResult.FAILURE) { logger.log(Status.FAIL,
	 * result.getName()); logger.log(Status.FAIL, result.getThrowable());
	 * logger.fail("Screen Shot: " +
	 * logger.addScreenCaptureFromPath(screenShotPath)); } else if
	 * (result.getStatus() == ITestResult.SUCCESS) { logger.log(Status.PASS,
	 * result.getName()); logger.pass("Screen Shot: " +
	 * logger.addScreenCaptureFromPath(screenShotPath)); } else if
	 * (result.getStatus() == ITestResult.SKIP) { logger.skip("Test Case : " +
	 * result.getName() + " has been skipped"); }
	 * 
	 * 
	 * report.flush();
	 * 
	 * driver.quit(); }
	 */

}
