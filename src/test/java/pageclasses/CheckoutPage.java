package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseclasses.BasePageClass;

public class CheckoutPage extends BasePageClass {

	public String productName;

	public int quantity;

	public boolean applyBtn_isPresent;

	public boolean placeOrderBtn_isPresent;

	public CheckoutPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		this.driver = driver;
		this.logger = logger;
	}

	@FindBy(css = "p.product-name")
	WebElement productName_field;

	@FindBy(className = "quantity")
	WebElement quantity_field;

	@FindBy(xpath = "//button[@class='promoBtn']")
	WebElement applyBtn;

	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement placeOrderBtn;

	public CheckoutPage retrieveAndSetProductName() {

		try {
			productName = productName_field.getText().split("-")[0].trim();
			reportPass("Successfully retrieved product name : " + productName + " from Checkout Page");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		CheckoutPage checkoutPage = new CheckoutPage(driver, logger);

		checkoutPage.productName = productName;

		PageFactory.initElements(driver, checkoutPage);

		return checkoutPage;
	}

	public String getProductName() {
		return this.productName;
	}

	public CheckoutPage retrieveAndSetQuantity() {
		try {
			String quantity_Str = quantity_field.getText().trim();
			quantity = Integer.parseInt(quantity_Str);
			reportPass("Successfully retrieved Quantity : " + quantity + " from Checkout Page");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		CheckoutPage checkoutPage = new CheckoutPage(driver, logger);

		checkoutPage.quantity = quantity;

		PageFactory.initElements(driver, checkoutPage);

		return checkoutPage;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public CheckoutPage applyBtn_display() {

		boolean applyBtn_displayed = false;
		try {
			applyBtn_displayed = applyBtn.isDisplayed();
			reportPass("Apply Button displayed on Checkout Page is : " + applyBtn_displayed);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		CheckoutPage checkoutPage = new CheckoutPage(driver, logger);

		checkoutPage.applyBtn_isPresent = applyBtn_displayed;

		PageFactory.initElements(driver, checkoutPage);

		return checkoutPage;
	}

	public CheckoutPage placeOrderBtn_display() {

		boolean placeorderBtn_displayed = false;
		try {
			placeorderBtn_displayed = placeOrderBtn.isDisplayed();
			reportPass("Place Order Button displayed on Checkout Page is : " + placeorderBtn_displayed);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		CheckoutPage checkoutPage = new CheckoutPage(driver, logger);

		checkoutPage.placeOrderBtn_isPresent = placeorderBtn_displayed;

		PageFactory.initElements(driver, checkoutPage);

		return checkoutPage;
	}

}
