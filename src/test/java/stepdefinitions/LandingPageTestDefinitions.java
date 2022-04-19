package stepdefinitions;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import baseclasses.BasePageClass;
import baseclasses.BaseTestClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageclasses.LandingPage;
import utils.TestContextSetup;

public class LandingPageTestDefinitions extends BaseTestClass {

	TestContextSetup testContextSetup;

	public LandingPage landingPage;

	public String landingPage_ProductName;

	public LandingPageTestDefinitions(TestContextSetup testContextSetup) {
		super(testContextSetup.driver, testContextSetup.logger);
		this.testContextSetup = testContextSetup;
		this.driver = testContextSetup.driver;
		this.logger = testContextSetup.logger;
	}

	@Given("^User is on GreenKart Landing Page$")
	public void user_is_on_greenkart_landing_page() throws Throwable {

		testContextSetup.logger = report.createTest("Search Product by Shortname");

		//loadProjectConfigProperties();
		invokeBrowser("browserName");

		testContextSetup.logger.log(Status.INFO, "Invoked Browser : " + props.getProperty("browserName"));

		BasePageClass basePage = new BasePageClass(driver, testContextSetup.logger);

		PageFactory.initElements(driver, basePage);

		testContextSetup.landingPage = basePage.openApplication(props.getProperty("websiteURL"));

		testContextSetup.driver = driver;

		PageFactory.initElements(driver, testContextSetup.landingPage);

	}

	@When("^User searches for a product with shortname (.+) and actual product name is extracted$")
	public void user_searches_for_a_product_with_shortname_something_and_actual_product_name_is_extracted(
			String strArg1) throws Throwable {
		testContextSetup.landingPage = testContextSetup.landingPage.searchProductByShortName(strArg1);

		PageFactory.initElements(driver, testContextSetup.landingPage);

		Thread.sleep(2000);

		testContextSetup.landingPage = testContextSetup.landingPage.retrieveAndSetProductName();

		PageFactory.initElements(driver, testContextSetup.landingPage);

		Thread.sleep(2000);

		testContextSetup.landingPage_ProductName = testContextSetup.landingPage.getProductName();

		testContextSetup.driver = driver;

		PageFactory.initElements(driver, testContextSetup.landingPage);
	}

	@And("^User increments the Quantity (.+) times and Adds to Cart$")
	public void user_increments_the_quantity_times_and_adds_to_cart(String increment) throws Throwable {

		int increment_Count = Integer.parseInt(increment);

		for (int counter = 1; counter <= increment_Count; counter++) {
			testContextSetup.landingPage = testContextSetup.landingPage.clickIncrementLink();

			PageFactory.initElements(driver, testContextSetup.landingPage);
		}

		Thread.sleep(2000);

		testContextSetup.landingPage = testContextSetup.landingPage.clickAddToCartButton();

		testContextSetup.driver = driver;

		PageFactory.initElements(driver, testContextSetup.landingPage);

		Thread.sleep(2000);
	}

	@And("^User clicks on Cart$")
	public void user_clicks_on_cart() throws Throwable {

		testContextSetup.landingPage = testContextSetup.landingPage.clickCartIconLink();

		testContextSetup.driver = driver;

		PageFactory.initElements(driver, testContextSetup.landingPage);

		Thread.sleep(2000);
	}

}
