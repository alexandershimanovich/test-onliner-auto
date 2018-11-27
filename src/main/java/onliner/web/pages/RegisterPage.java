package onliner.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends AbstractPage{

	@FindBy(xpath = "//*[contains(text(), 'Зарегистрироваться')]")
	private WebElement buttonRegistering;

	public boolean isButtonRegisteringEnable() {
		return buttonRegistering.isEnabled();
	}
}
