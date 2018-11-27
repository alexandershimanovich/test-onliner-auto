package onliner.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MotoPage extends AbstractPage {

	@FindBy(xpath = "//i[@class='icon mb']//following-sibling::h1")
	private WebElement mainLogo;

	public String getMainLogo() {
		return mainLogo.getText();
	}

}
