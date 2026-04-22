package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.BasePage;

public class RecruitmentPage extends BasePage {
	@FindBy(xpath = "//span[normalize-space()='Recruitment']")
	public WebElement recruitmentMenu;


	@FindBy(xpath="//input[@placeholder='From']//following-sibling::i")
	public WebElement fromDropdown;
	
	@FindBy(xpath="//input[@placeholder='To']//following-sibling::i")
	public WebElement toDropdown;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	public WebElement candidateNameInput;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	public WebElement errorMessage;
	
	@FindBy(xpath="//div[@class='oxd-calendar-date --selected --today']")
	public WebElement todayDate;
	
	@FindBy(xpath="//button[text()=' Search ']")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[text()='No Records Found']")
	public WebElement noRecordFoundOption;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span")
	public WebElement recordsFoundText;
	
	
	public RecruitmentPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnRecruitment() {
		wait.until(ExpectedConditions
                .elementToBeClickable(recruitmentMenu));
		recruitmentMenu.click();;
	
	}
	
	
	public void selectFromDropdown(String dropdownName, String value) {

	    try {

	        // Step 1 — Click dropdown
	        String dropdownXpath =
	            "//label[normalize-space()='"+dropdownName+"']" +
	            "/ancestor::div[contains(@class,'oxd-input-group')]" +
	            "//div[contains(@class,'oxd-select-text')]";

	        WebElement dropdown =
	            wait.until(ExpectedConditions
	            .elementToBeClickable(By.xpath(dropdownXpath)));

	        dropdown.click();

	        // Step 2 — Wait for list to appear
	        wait.until(ExpectedConditions
	            .visibilityOfElementLocated(
	            By.xpath("//div[@role='listbox']")));

	        // Step 3 — Get all options
	        List<WebElement> options =
	            driver.findElements(
	            By.xpath("//div[@role='listbox']//span"));

	        boolean found = false;

	        // Step 4 — Loop through options
	        for (WebElement option : options) {

	            String text = option.getText().trim();

	            if (text.equalsIgnoreCase(value)) {

	                option.click();

	                System.out.println(
	                    "Selected value: " + value);

	                found = true;

	                break;
	            }
	        }

	        // Step 5 — If not found
	        if (!found) {

	            System.out.println(
	                "Value NOT found in dropdown: " + value);

	        }

	    }
	    catch (Exception e) {

	        System.out.println(
	            "Dropdown NOT found: " + dropdownName);

	    }
	}
	
	public void enterValueInCandidateNameFieldAndValidate(String text) {
		candidateNameInput.sendKeys(text);
		noRecordFoundOption.click();
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		errorMessage.getText().compareTo("Invalid");
		candidateNameInput.clear();
		
	}
	
	public void selectDate() {
		fromDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(todayDate));
		todayDate.click();
		toDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(todayDate));
		todayDate.click();
		
	}
	public void clickSearchAndvalidate() {
		searchButton.click();
		wait.until(ExpectedConditions.visibilityOf(recordsFoundText));
		String text=recordsFoundText.getText();
		System.out.println(text);
	}
}


