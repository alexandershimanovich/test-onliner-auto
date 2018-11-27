package onliner.mobile.driver;

import static onliner.utils.PropertiesReader.getPropertyValue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import onliner.utils.PropertiesNames;

public class AppiumDriverManager {

	private static final int IMPLICIT_WAIT = Integer
			.parseInt(getPropertyValue(PropertiesNames.IMPLICIT_WAIT.toString()));

	protected static AppiumDriver<MobileElement> driver;

	private AppiumDriverManager() {
	}

	protected static void createAndroidDriver() {
		File appDirectory = new File(getPropertyValue(PropertiesNames.APP_DIR.toString()));
		File app = new File(appDirectory, getPropertyValue(PropertiesNames.APP_NAME.toString()));

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PLATFORM_NAME,
				getPropertyValue(PropertiesNames.PLATFORM_NAME.toString()));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				getPropertyValue(PropertiesNames.PLATFORM_VERSION.toString()));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				getPropertyValue(PropertiesNames.DEVICE_NAME.toString()));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		try {
			driver = new AndroidDriver<MobileElement>(
					new URL(getPropertyValue(PropertiesNames.APPIUM_DRIVER_LOCAL_SERVICE.toString())), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public static AppiumDriver<MobileElement> getAndroidDriver() {
		if (driver == null) {
			createAndroidDriver();
		}
		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
