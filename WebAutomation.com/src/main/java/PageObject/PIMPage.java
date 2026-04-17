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

    
    @FindBy(xpath ="//a[text()='Add Employee']")
    private WebElement addEmployeeHeader;
    
    
    @FindBy(xpath ="//label[normalize-space()='Username']/following::input[1]")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[normalize-space()='Password']/following::input[1]")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[normalize-space()='Confirm Password']/following::input[1]")
    private WebElement confirmPasswordInput;

    @FindBy(xpath ="//label[normalize-space()='Enabled']")
    private WebElement statusEnabledOption;

    @FindBy(xpath ="//label[normalize-space()='Disabled']")
    private WebElement statusDisabledOption;

    
    
  public void clickPIMMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenuButton)).click();
        
    }

    public void clickAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton)).click();
        
    }

    
    public boolean isAddEmployeeHeaderDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addEmployeeHeader)).isDisplayed();
    }

    public  void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        
    }

    public void enterMiddleName(String middleName) {
        middleNameInput.clear();
        middleNameInput.sendKeys(middleName);
       
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        
    }

    public void enterEmployeeId(String employeeId) {
        employeeIdInput.clear();
        employeeIdInput.sendKeys(employeeId);
       
    }

    public PIMPage setCreateLoginDetails(boolean enable) {
        if (createLoginDetailsToggle != null) {
            boolean isSelected = createLoginDetailsToggle.getAttribute("class").contains("oxd-switch-input--active")
                    || createLoginDetailsToggle.getAttribute("aria-checked").equalsIgnoreCase("true");
            if (enable != isSelected) {
                createLoginDetailsToggle.click();
            }
        }
        return this;
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }

    public boolean isAddEmployeeSectionDisplayed() {
        return addEmployeeHeader.isDisplayed();
    }
    
    public void  enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        
    }

    public void  enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
       
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
       
    }

    public void selectStatusEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(statusEnabledOption)).click();
        
    }

    public  selectStatusDisabled() {
        wait.until(ExpectedConditions.elementToBeClickable(statusDisabledOption)).click();
        
    }

    public boolean isStatusEnabledSelected() {
        return statusEnabledOption.isSelected();
    }

    public boolean isStatusDisabledSelected() {
        return statusDisabledOption.isSelected();
    }

    
    
}
