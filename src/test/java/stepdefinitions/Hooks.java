package stepdefinitions;

import com.aventstack.extentreports.Status;

import baseclasses.BaseTestClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.CaptureScreenshot;
import utils.DateUtils;
import utils.TestContextSetup;

public class Hooks extends BaseTestClass {

	public TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		super(testContextSetup.driver, testContextSetup.logger);
		this.testContextSetup = testContextSetup;
		this.driver = testContextSetup.driver;
		this.logger = testContextSetup.logger;
	}

	@After
	public void setTestResult() {

		/*
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
		 */

		testContextSetup.baseTestClass.report.flush();

		testContextSetup.driver.quit();

	}

	@AfterStep
	public void addScreenshotOnFailure(Scenario scenario) {

		if(scenario.isFailed()) {
			String fileName = scenario.getName() + "_" + DateUtils.getTimeStamp();
			
			String screenShotPath = CaptureScreenshot.takeScreenShot(testContextSetup.driver, fileName);
			
			byte[] fileContent = CaptureScreenshot.generateFileContent(testContextSetup.driver);
			
			testContextSetup.logger.log(Status.FAIL, scenario.getName());
			testContextSetup.logger.fail("Screen Shot : " + testContextSetup.logger.addScreenCaptureFromPath(screenShotPath));
			
			scenario.attach(fileContent, "image/png", fileName);
		}
		
	}

}
