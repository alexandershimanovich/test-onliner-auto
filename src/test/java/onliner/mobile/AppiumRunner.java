package onliner.mobile;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "pretty", "json:target/cucumber-report.json", "html:target/cucumber-report",
		"com.epam.reportportal.cucumber.StepReporter" }, features = {"src/test/resources/mobile/"}, glue = {
				"onliner.mobile" })
public class AppiumRunner extends AbstractTestNGCucumberTests {
}