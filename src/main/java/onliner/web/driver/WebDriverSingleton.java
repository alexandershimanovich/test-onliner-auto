package onliner.web.driver;

import java.util.concurrent.TimeUnit;

import static onliner.utils.PropertiesReader.getPropertyValue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import onliner.utils.PropertiesNames;

public abstract class WebDriverSingleton {

	private static WebDriver instance;
	private static final int IMPLICITLY_WAIT = Integer
			.parseInt(getPropertyValue(PropertiesNames.IMPLICIT_WAIT.toString()));

	private WebDriverSingleton() {
	}

	public static WebDriver getInstance() {
		if (instance == null) {
			return instance = init();
		}
		return instance;
	}

	private static WebDriver init() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static void driverClose() {
		if (instance != null) {
			instance.quit();
			instance = null;
		}
	}
}
