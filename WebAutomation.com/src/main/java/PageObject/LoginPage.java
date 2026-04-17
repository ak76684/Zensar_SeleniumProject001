package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(name = "username")
	public WebElement usernameInput;

	@FindBy(name = "password")
	public WebElement passwordInput;

	@FindBy(xpath =  "//button[@type='submit']")
	public WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUsername(String username) {
		usernameInput.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public String login(String username, String password) {
		waitForPageLoad();
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		clickLogin();
		return getPageTitle();
		
	}

	public boolean isLoginPageDisplayed() {
		waitForPageLoad();
		return usernameInput.isDisplayed() && passwordInput.isDisplayed();
	}

}
