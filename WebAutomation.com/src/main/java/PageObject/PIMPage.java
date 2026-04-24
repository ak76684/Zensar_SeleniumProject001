package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BasePage;


public class PIMPage extends BasePage {

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//span[text()='PIM']") 
    private WebElement pimMenuButton;
    
    @FindBy(xpath = "//button[contains(@class,'oxd-button') and normalize-space()='Add']")
    private WebElement addEmployeeButton;
    
    @FindBy(name="firstName")
    private WebElement firstNameInput;
    

    @FindBy(name="middleName")
    private WebElement middleNameInput;

    @FindBy(name="lastName")
    private WebElement lastNameInput;

    @FindBy(xpath="//label[normalize-space()='Employee Id']/following::input[1]")
    private WebElement employeeIdInput;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath ="//p[normalize-space()='Create Login Details']/following::input[@type='checkbox']")
    private WebElement createLoginDetailsToggle;



    
   
}
