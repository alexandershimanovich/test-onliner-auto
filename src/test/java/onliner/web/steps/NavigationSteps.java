package onliner.web.steps;

import static org.testng.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import onliner.web.pages.MainPage;
import onliner.web.pages.MotoPage;

public class NavigationSteps {

	private MainPage mainPage;
	private MotoPage motoPage;

	@Given("^I open ab.onliner.by$")
	public void iOpenAbOnlinerBy() {
		mainPage = new MainPage();
		mainPage.open();
	}

	@Then("^I see main logo \"([^\"]*)\"$")
	public void iSeeMainLogo(String mainLogotext) {
		assertEquals(mainPage.getMainLogo(), mainLogotext);
	}

	@When("^I click on section \"([^\"]*)\"$")
	public void iClickOnSectionMoto(String nameSection) {
		mainPage.clickNavigationButton(nameSection);
	}

	@Then("^I see main section moto logo \"([^\"]*)\"$")
	public void iSeeSectionNotoLogo(String mainLogotext) {
		motoPage = new MotoPage();
		assertEquals(motoPage.getMainLogo(), mainLogotext);
	}

}
