package onliner.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import onliner.web.driver.WebDriverSingleton;

public abstract class AbstractPage {

	protected WebDriver driver;

	protected AbstractPage() {
		driver = WebDriverSingleton.getInstance();
		PageFactory.initElements(driver, this);
	}
}