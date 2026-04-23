package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(name = "username")
	public WebElement usernameInput;

	@FindBy(name = "password")
	public WebElement passwordInput;

	@FindBy(xpath =  "//button[@type='submit']")
	public WebElement loginButton;

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	public WebElement profileDropdown;
	
	@FindBy(xpath="//a[@href='/web/index.php/auth/logout']")
	public WebElement logoutButton;
	
	
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
		System.out.println("Typing Username..."+username);
		System.out.println("Typing Password..."+password);
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		clickLogin();
		wait.until(ExpectedConditions
		        .visibilityOfElementLocated(
		        By.xpath("//h6[text()='Dashboard']")));
		return getPageTitle();
		
	}

	public boolean isLoginPageDisplayed() {
		waitForPageLoad();
		return usernameInput.isDisplayed() && passwordInput.isDisplayed();
	}
	
	public void clickLogout() {
		profileDropdown.click();
		logoutButton.click();
	}

}
