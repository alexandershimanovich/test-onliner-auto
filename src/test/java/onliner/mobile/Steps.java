package onliner.mobile;

import cucumber.api.java.en.*;
import onliner.mobile.pages.*;

import static onliner.utils.PropertiesReader.getPropertyValue;

import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import onliner.mobile.driver.AppiumDriverManager;
import onliner.utils.PropertiesNames;

public class Steps {

	private AppMainScreen appMainScreen;
	private LoginScreen loginScreen;

	protected AppiumDriver<MobileElement> driver;

	@Given("^I install and open onliner app$")
	public void iInstallAndOnlinerApp() {
		driver = AppiumDriverManager.getAndroidDriver();
	}

	@And("^I close app$")
	public void iCloseApp() {
		driver.closeApp();
	}

	@Then("^I see menu button$")
	public void iSeeMenuButton() {
		appMainScreen = new AppMainScreen(driver);
		Assert.assertTrue(appMainScreen.isMenuButtonVisible());
	}

	@Given("^I open Onliner app on mobile device$")
	public void iOpenOnlinerApp() {
		driver = AppiumDriverManager.getAndroidDriver();
		Activity activity = new Activity(getPropertyValue(PropertiesNames.APP_PACKAGE.toString()),
				getPropertyValue(PropertiesNames.APP_ACTIVITY.toString()));
		((AndroidDriver<MobileElement>) driver).startActivity(activity);
	}

	@Given("^I open logIn menu$")
	public void iOpenLogInMenu() {
		appMainScreen = new AppMainScreen(driver);
		appMainScreen.clickOnMenuButton();
		appMainScreen.clickOnLogInButton();
	}

	@When("^I enter login \"([^\"]*)\", password \"([^\"]*)\" and click enter button$")
	public void iEnterLoginPasswordAndClickEnterButton(String login, String password) {
		loginScreen = new LoginScreen(driver);
		loginScreen.fillTheFields(login, password);
		driver.hideKeyboard();
		loginScreen.clickButtonEnter();
	}

	@Then("^I see button logOut$")
	public void iSeeButtonLogOut() {
		appMainScreen = new AppMainScreen(driver);
		Assert.assertTrue(appMainScreen.isExitButtonVisible());
	}

	@Then("^I see error message$")
	public void iSeeErrorMessage() {
		appMainScreen = new AppMainScreen(driver);
		Assert.assertTrue(loginScreen.isErrorMessageVisible());
	}

	@And("^I click button logOut$")
	public void iClickButtonLogOut() {
		appMainScreen = new AppMainScreen(driver);
		appMainScreen.clickOnLogOutButton();
	}

	@Then("^I see button login$")
	public void iSeeButtonLogIn() {
		appMainScreen = new AppMainScreen(driver);
		Assert.assertTrue(appMainScreen.isLoginButtonVisible());
	}

	@Given("^I open menu$")
	public void iOpenMenu() {
		appMainScreen = new AppMainScreen(driver);
		appMainScreen.clickOnMenuButton();
	}

}