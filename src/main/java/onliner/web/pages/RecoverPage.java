package onliner.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecoverPage extends AbstractPage {

	@FindBy(xpath = "//input[@placeholder ='Ник, e-mail или номер телефона']")
	private WebElement inputRecoverMail;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonFurther;

	@FindBy(xpath = "//*[contains(text(), 'Такой пользователь не зарегистрирован')]")
	private WebElement errorRecoverMessage;
	
	@FindBy(xpath = "//*[contains(text(), 'Проверьте ваш')]")
	private WebElement successRecoverMessage;

	public RecoverPage enterRecoverMail(String mail) {
		inputRecoverMail.sendKeys(mail);
		return this;
	}

	public RecoverPage clickButtonFurther() {
		buttonFurther.click();
		return this;
	}

	public boolean isErrorRecoverMessageDisplayed() {
		return errorRecoverMessage.isDisplayed();
	}
	
	public boolean isSuccessRecoverMessageDisplayed() {
		return successRecoverMessage.isDisplayed();
	}

}
