package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseclasses.BasePageClass;
import utils.GenericUtils;

public class LandingPage extends BasePageClass {

	public String productName;

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		this.driver = driver;
		this.logger = logger;
	}

	@FindBy(xpath = "//input[@type='search']")
	WebElement search_textbox;

	@FindBy(className = "product-name")
	WebElement productName_field;

	@FindBy(linkText = "Top Deals")
	WebElement topDealsLink;

	@FindBy(className = "increment")
	WebElement incrementLink;

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//img[@alt='Cart']")
	WebElement cartIconLink;

	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	WebElement proceedToCheckoutBtn;

	public LandingPage searchProductByShortName(String productShortName) {

		try {
			search_textbox.sendKeys(productShortName);
			reportPass("Successfully entered product short name : " + productShortName + " in search box");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		LandingPage landingPage = new LandingPage(driver, logger);

		PageFactory.initElements(driver, landingPage);

		return landingPage;
	}

	public LandingPage retrieveAndSetProductName() {

		try {
			productName = productName_field.getText().split("-")[0].trim();
			reportPass("Successfully retrieved product name : " + productName + " from Landing Page");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		LandingPage landingPage = new LandingPage(driver, logger);

		landingPage.productName = productName;

		PageFactory.initElements(driver, landingPage);

		return landingPage;
	}

	public String getProductName() {
		return this.productName;
	}

	public TopDealsPage clickTopDealsLink() {
		try {
			topDealsLink.click();
			reportPass("Successfully clicked on Top Deals link");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		GenericUtils genericUtils = new GenericUtils(driver);
		genericUtils.switchtoChildWindow();

		TopDealsPage topDealsPage = new TopDealsPage(driver, logger);

		PageFactory.initElements(driver, topDealsPage);

		return topDealsPage;
	}

	public LandingPage clickIncrementLink() {
		try {
			incrementLink.click();
			reportPass("Successfully clicked on Increment icon link");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		if (driver == null)
			System.out.println("*** LPage Step 5 driver is null ***");

		LandingPage landingPage = new LandingPage(driver, logger);

		PageFactory.initElements(driver, landingPage);

		return landingPage;
	}

	public LandingPage clickAddToCartButton() {
		try {
			addToCartBtn.click();
			reportPass("Successfully clicked Add To Cart button");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		LandingPage landingPage = new LandingPage(driver, logger);

		PageFactory.initElements(driver, landingPage);

		return landingPage;
	}

	public LandingPage clickCartIconLink() {
		try {
			cartIconLink.click();
			reportPass("Successfully clicked Cart Icon link");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		LandingPage landingPage = new LandingPage(driver, logger);

		PageFactory.initElements(driver, landingPage);

		return landingPage;
	}

	public CheckoutPage clickProceedToCheckoutBtn() {
		try {
			proceedToCheckoutBtn.click();
			reportPass("Successfully clicked Proceed to Checkout Button");
		} catch (Exception e) {
			reportFail(e.getMessage());
			e.printStackTrace();
		}

		CheckoutPage checkoutPage = new CheckoutPage(driver, logger);

		PageFactory.initElements(driver, checkoutPage);

		return checkoutPage;
	}

}
