package testrunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepdefinitions", tags = "@CheckoutTest or @ProductTest", monochrome = true, 
plugin = {"pretty", "html:test-output/html-reports/cucumber.html", "json:test-output/json-reports/cucumber.json", "junit:test-output/xml-reports/cucumber.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:test-output/failed-scenarios/failed-scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
