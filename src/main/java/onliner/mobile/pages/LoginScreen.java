package onliner.mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends AbstractScreen {

	public LoginScreen(AppiumDriver<MobileElement> driver){
		super(driver);
	}

	@AndroidFindBy(id = "by.onliner.ab:id/login")
	private MobileElement loginField;

	@AndroidFindBy(id = "by.onliner.ab:id/password")
	private MobileElement passwordField;

	@AndroidFindBy(id = "by.onliner.ab:id/makeLogin")
	private MobileElement buttonEnter;
	
	@AndroidFindBy(id = "by.onliner.ab:id/snackbar_text")
	private MobileElement errorMessage;

	public void fillTheFields(String login, String password) {
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
	}

	public void clickButtonEnter() {
		buttonEnter.click();
	}
	
	public boolean isErrorMessageVisible() {
		return errorMessage.isDisplayed();
	}

}
