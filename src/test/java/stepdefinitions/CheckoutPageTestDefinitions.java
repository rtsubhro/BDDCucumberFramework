package stepdefinitions;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import baseclasses.BaseTestClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class CheckoutPageTestDefinitions extends BaseTestClass {

	public TestContextSetup testContextSetup;

	public CheckoutPageTestDefinitions(TestContextSetup testContextSetup) {
		super(testContextSetup.driver, testContextSetup.logger);
		this.testContextSetup = testContextSetup;
		this.driver = testContextSetup.driver;
		this.logger = testContextSetup.logger;
	}

	@And("^User Proceeds to Checkout$")
	public void user_proceeds_to_checkout() throws Throwable {

		testContextSetup.checkoutPage = testContextSetup.landingPage.clickProceedToCheckoutBtn();

		Thread.sleep(2000);
	}

	@Then("^Product Name on both Landing Page and Checkout Page should match$")
	public void product_name_on_both_landing_page_and_checkout_page_should_match() throws Throwable {

		testContextSetup.logger.log(Status.INFO,
				"Landing Page Product Name is : " + testContextSetup.landingPage_ProductName);

		testContextSetup.logger.log(Status.INFO,
				"Checkout Page Product Name is : " + testContextSetup.checkoutPage_ProductName);

		try {
			Assert.assertEquals(testContextSetup.landingPage_ProductName, testContextSetup.checkoutPage_ProductName);
			testContextSetup.logger.pass("Landing Page Product Name : " + testContextSetup.landingPage_ProductName
					+ " Matches Checkout Page Product Name : " + testContextSetup.checkoutPage_ProductName);
		} catch (AssertionError e) {
			Assert.fail("Landing Page Product Name : " + testContextSetup.landingPage_ProductName
					+ " Does Not Match Checkout Page Product Name : " + testContextSetup.checkoutPage_ProductName);
			testContextSetup.logger.fail("Landing Page Product Name : " + testContextSetup.landingPage_ProductName
					+ " Does Not Match Checkout Page Product Name : " + testContextSetup.checkoutPage_ProductName);
		}

	}

	@And("^Product Name and Quantity on Checkout Page are extracted$")
	public void product_name_and_quantity_on_checkout_page_are_extracted() throws Throwable {

		testContextSetup.checkoutPage = testContextSetup.checkoutPage.retrieveAndSetProductName();

		Thread.sleep(2000);

		testContextSetup.checkoutPage_ProductName = testContextSetup.checkoutPage.getProductName();

		Thread.sleep(2000);

		testContextSetup.checkoutPage = testContextSetup.checkoutPage.retrieveAndSetQuantity();

		Thread.sleep(2000);

		testContextSetup.checkoutPage_Quantity = testContextSetup.checkoutPage.getQuantity();

		Thread.sleep(2000);

	}

	@And("^Quantity on Checkout Page should equal (.+) plus One$")
	public void quantity_on_checkout_page_should_equal_plus_one(String increment) throws Throwable {

		int increment_counter = Integer.parseInt(increment);

		testContextSetup.logger.log(Status.INFO, "Increment is : " + increment_counter);

		testContextSetup.logger.log(Status.INFO,
				"Quantity from Checkout Page is : " + testContextSetup.checkoutPage_Quantity);

		try {
			Assert.assertEquals(testContextSetup.checkoutPage_Quantity, increment_counter + 1);
			testContextSetup.logger.pass("Quantity from Checkout Page : " + testContextSetup.checkoutPage_Quantity
					+ " Matches Increment : " + increment_counter + " plus One");
		} catch (AssertionError e) {
			testContextSetup.logger.fail("Quantity from Checkout Page : " + testContextSetup.checkoutPage_Quantity
					+ " Does Not Match Increment : " + increment_counter + " plus One");
			Assert.fail("Quantity from Checkout Page : " + testContextSetup.checkoutPage_Quantity
					+ " Does Not Match Increment : " + increment_counter + " plus One");
		}

	}

	@And("^Apply button should be visible on Checkout Page$")
	public void apply_button_should_be_visible_on_checkout_page() throws Throwable {

		testContextSetup.checkoutPage = testContextSetup.checkoutPage.applyBtn_display();

		Thread.sleep(2000);

		try {
			Assert.assertTrue(testContextSetup.checkoutPage.applyBtn_isPresent);
			testContextSetup.logger.pass("Apply Button is Displayed on Checkout Page");
		} catch (AssertionError e) {
			testContextSetup.logger.fail("Apply Button is Not Displayed on Checkout Page");
			Assert.fail("Apply Button is Not Displayed on Checkout Page");
		}

	}

	@And("^Place Order button should be visible on Checkout Page$")
	public void place_order_button_should_be_visible_on_checkout_page() throws Throwable {

		testContextSetup.checkoutPage = testContextSetup.checkoutPage.placeOrderBtn_display();

		Thread.sleep(2000);

		try {
			Assert.assertTrue(testContextSetup.checkoutPage.placeOrderBtn_isPresent);
			testContextSetup.logger.pass("Place Order Button is Displayed on Checkout Page");
		} catch (AssertionError e) {
			testContextSetup.logger.fail("Place Order Button is Not Displayed on Checkout Page");
			Assert.fail("Place Order is Not Displayed on Checkout Page");
		}

	}
}
