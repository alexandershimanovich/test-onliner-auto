package onliner.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

	@FindBy(xpath = "//div[@class='auth-form__field']//input[@type='text']")
	private WebElement inputLogIn;

	@FindBy(xpath = "//div[@class='auth-form__field']//input[@type='password']")
	private WebElement inputPassword;

	@FindBy(xpath = "//button[contains(text(), 'Войти')]")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//*[contains(text(), 'Неверный логин или пароль')]")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//*[contains(text(), 'Зарегистрироваться на Onliner')]")
	private WebElement buttonRegisterOnOnliner;

	@FindBy(xpath = "//*[contains(text(), 'Я не помню пароль')]")
	private WebElement buttonDontRememberPassword;
	
	public LogInPage enterLogIn(String login) {
		inputLogIn.sendKeys(login);
		return this;
	}

	public LogInPage enterPassword(String password) {
		inputPassword.sendKeys(password);
		return this;
	}

	public ProfilePage clickSubmitButton() {
		buttonSubmit.click();
		return new ProfilePage();
	}

	public boolean isErrorMessageEnable() {
		return errorMessage.isEnabled();
	}
	
	public RegisterPage clickButtonRegisterOnOnliner() {
		buttonRegisterOnOnliner.click();
		return new RegisterPage();
	}
	
	public RecoverPage clickButtonDontRememberPassword() {
		buttonDontRememberPassword.click();
		return new RecoverPage();
	}


}
