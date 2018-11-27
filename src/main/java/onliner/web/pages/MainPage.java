package onliner.web.pages;

import static onliner.utils.PropertiesReader.getPropertyValue;

import java.util.List;

import onliner.utils.PropertiesNames;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	private static final String BASE_URL = getPropertyValue(PropertiesNames.BASE_URL.toString());

	@FindBy(xpath = "//i[@class='icon ab']//following-sibling::h1")
	private WebElement mainLogo;

	@FindBy(xpath = "//div[@id = 'userbar']//following-sibling::div[text()]")
	private WebElement buttonLogIn;

	@FindBy(xpath = "//span[@class='project-navigation__sign']")
	private List<WebElement> listOfNavigationsButton;

	public MainPage open() {
		driver.get(BASE_URL);
		return this;
	}

	public String getMainLogo() {
		return mainLogo.getText();
	}

	public LogInPage clicklogInButton() {
		buttonLogIn.click();
		return new LogInPage();
	}

	public MotoPage clickNavigationButton(String name) {
		for (WebElement element : listOfNavigationsButton) {
			if (element.getText().equalsIgnoreCase(name)) {
				element.click();
				break;
			}
		}
		return new MotoPage();
	}
}
