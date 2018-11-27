package onliner.web.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import onliner.web.pages.LogInPage;
import onliner.web.pages.MainPage;
import onliner.web.pages.ProfilePage;
import onliner.web.pages.RecoverPage;
import onliner.web.pages.RegisterPage;

public class LoginSteps {

	private MainPage mainPage;
	private LogInPage loginPage;
	private ProfilePage profilePage;
	private RegisterPage registerPage;
	private RecoverPage recoverPage;

	@When("^I click button Entry$")
	public void iClickButtonEntry() {
		mainPage = new MainPage();
		mainPage.clicklogInButton();
	}

	@When("^I enter credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void iEnterCredentials(String mail, String password) {
		loginPage = new LogInPage();
		loginPage.enterLogIn(mail).enterPassword(password);
	}

	@When("^I click button Submit$")
	public void iClickButtonSubmit() {
		loginPage.clickSubmitButton();
	}

	@Then("^I redirect to profile page with title \"([^\"]*)\"$")
	public void iRedirectToProfilePageWithTitle(String title) {
		profilePage = new ProfilePage();
		assertEquals(profilePage.getTitle(), title);
	}

	@When("^I enter uncorrect credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void iEnterUncorrectCredentials(String login, String password) {
		loginPage = new LogInPage();
		loginPage.enterLogIn(login).enterPassword(password);
	}

	@Then("^I see error message uncorrect login or password$")
	public void iSeeErrorMessageUncorrectLoginOrPassword() {
		assertTrue(loginPage.isErrorMessageEnable());
	}

	@When("^I click button 'Register on onliner'$")
	public void iClickButtonRegisterOnOnliner() {
		loginPage = new LogInPage();
		loginPage.clickButtonRegisterOnOnliner();
	}

	@Then("^I redirect to register page and see button \"([^\"]*)\"$")
	public void iRedirectToRegisterPageAndSeeButtonRegistering(String nameOfButton) {
		registerPage = new RegisterPage();
		assertTrue(registerPage.isButtonRegisteringEnable());
	}

	@When("^I click button 'I dont remember password'$")
	public void iClickButtonIDontRememberPassword() {
		loginPage = new LogInPage();
		loginPage.clickButtonDontRememberPassword();
	}

	@When("^I enter correct email \"([^\"]*)\" and click button 'Further'$")
	public void iEnterCorrectEmailAndClickButtonFurther(String mail) {
		recoverPage = new RecoverPage();
		recoverPage.enterRecoverMail(mail).clickButtonFurther();
	}

	@Then("^I see success recover message$")
	public void iSeeSuccessRecoverRessage() {
		assertTrue(recoverPage.isSuccessRecoverMessageDisplayed());
	}

	@When("^I enter uncorrect email \"([^\"]*)\" and click button 'Further'$")
	public void iEnterUncorrectEmailAndClickButtonFurther(String mail) {
		recoverPage = new RecoverPage();
		recoverPage.enterRecoverMail(mail).clickButtonFurther();
	}

	@Then("^I see error recover message$")
	public void iSeeErrorRecoverMessage() {
		assertTrue(recoverPage.isErrorRecoverMessageDisplayed());
	}

}
