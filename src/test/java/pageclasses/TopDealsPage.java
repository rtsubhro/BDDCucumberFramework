package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseclasses.BasePageClass;

public class TopDealsPage extends BasePageClass {

	public String productName;

	public TopDealsPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		this.driver = driver;
		this.logger = logger;
	}

	@FindBy(xpath = "//input[@type='search']")
	WebElement topDeals_search_box;

	@FindBy(xpath = "//tr/td[1]")
	WebElement productName_field;

	public TopDealsPage enterProductShortName(String productShortName) {
		try {
			topDeals_search_box.sendKeys(productShortName);
			reportPass("Successfully entered product short name : " + productShortName + " in Top Deals search box");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		TopDealsPage topDealsPage = new TopDealsPage(driver, logger);
		
		PageFactory.initElements(driver, topDealsPage);

		return topDealsPage;

	}

	public TopDealsPage retrieveAndSetProductName() {

		try {
			productName = productName_field.getText();
			reportPass("Successfully retrieved product name : " + productName + " from Top Deals Page");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		TopDealsPage topDealsPage = new TopDealsPage(driver, logger);
		
		topDealsPage.productName = productName;

		PageFactory.initElements(driver, topDealsPage);

		return topDealsPage;
	}

	public String getProductName() {
		return this.productName;
	}

}
