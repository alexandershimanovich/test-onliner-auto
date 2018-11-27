package onliner.web;

import org.testng.annotations.AfterSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import onliner.web.driver.WebDriverSingleton;

@CucumberOptions(plugin = { "pretty", "json:target/cucumber-report.json", "html:target/cucumber-report",
		"com.epam.reportportal.cucumber.StepReporter" }, features = "src/test/resources/web/", glue = { "onliner.web.steps" })
public class CucumberRunner extends AbstractTestNGCucumberTests {
	
	@AfterSuite
	public void close() {
		WebDriverSingleton.driverClose();
	}

}