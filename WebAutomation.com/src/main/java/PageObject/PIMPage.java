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

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(name = "employeeId")
    private WebElement employeeIdInput;

    @FindBy(css = "button[type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//label[.//span[text()='Create Login Details']]/../div")
    private WebElement createLoginDetailsToggle;

    @FindBy(xpath = "//a[.//span[text()='PIM'] or .//p[text()='PIM']] | //button[.//span[text()='PIM']]")
    private WebElement pimMenuButton;

    @FindBy(xpath = "//button[normalize-space()='+ Add'] | //a[normalize-space()='+ Add']")
    private WebElement addEmployeeButton;

    @FindBy(xpath = "//h6[contains(text(), 'Add Employee')] | //h1[contains(text(), 'Add Employee')]")
    private WebElement addEmployeeHeader;

    public PIMPage clickPIMMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenuButton)).click();
        return this;
    }

    public PIMPage clickAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton)).click();
        return this;
    }

    public PIMPage waitForAddEmployeePage() {
        wait.until(ExpectedConditions.visibilityOf(addEmployeeHeader));
        return this;
    }

    public PIMPage enterFirstName(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput)).clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public PIMPage enterMiddleName(String middleName) {
        wait.until(ExpectedConditions.elementToBeClickable(middleNameInput)).clear();
        middleNameInput.sendKeys(middleName);
        return this;
    }

    public PIMPage enterLastName(String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastNameInput)).clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public PIMPage enterEmployeeId(String employeeId) {
        wait.until(ExpectedConditions.elementToBeClickable(employeeIdInput)).clear();
        employeeIdInput.sendKeys(employeeId);
        return this;
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
}
