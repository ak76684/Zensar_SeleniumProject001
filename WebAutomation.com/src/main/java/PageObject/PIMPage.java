package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//span[text()='PIM']") 
    private WebElement pimMenuButton;
    
    @FindBy(xpath = "//button[contains(@class,'oxd-button') and normalize-space()='Add']")
    private WebElement addEmployeeButton;
    
    @FindBy(name="firstName")
    private WebElement firstNameInput;

    
   
}
