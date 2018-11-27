package onliner.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppMainScreen extends AbstractScreen {

	public AppMainScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(accessibility = "Navigate up")
	private MobileElement menuButton;

	@AndroidFindBy(id = "by.onliner.ab:id/button_authenticate")
	private MobileElement logInButton;

	@AndroidFindBy(id = "by.onliner.ab:id/button_exit")
	private MobileElement exitButton;

	@AndroidFindBy(id = "by.onliner.ab:id/button_action")
	private MobileElement actionButton;

	@AndroidFindBy(id = "by.onliner.ab:id/text_summary")
	private MobileElement summaryText;

	public boolean isMenuButtonVisible() {
		return menuButton.isDisplayed();
	}

	public void clickOnMenuButton() {
		menuButton.click();
	}

	public void clickOnLogInButton() {
		logInButton.click();
	}

	public void clickOnLogOutButton() {
		exitButton.click();
	}

	public boolean isExitButtonVisible() {
		return exitButton.isEnabled();
	}

	public boolean isLoginButtonVisible() {
		return logInButton.isEnabled();
	}

}
