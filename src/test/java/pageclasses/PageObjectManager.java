package pageclasses;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class PageObjectManager {
	
	public WebDriver driver;
	public ExtentTest logger;
	
	public LandingPage landingPage;
	public TopDealsPage topDealsPage;
	
	public PageObjectManager(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver, logger);
		
		return landingPage;
	}
	
	public TopDealsPage getTopDealsPage() {
		topDealsPage = new TopDealsPage(driver, logger);
		
		return topDealsPage;
	}

}
