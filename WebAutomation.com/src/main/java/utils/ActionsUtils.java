package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import base.WebDriverFactory;

public class ActionsUtils {

    private ActionsUtils() {
    }

    public static void click(WebElement element) {

        WaitUtils.waitForClickability(element);

        element.click();
    }

    public static void type(WebElement element, String value) {

        WaitUtils.waitForVisibility(element);

        element.clear();

        element.sendKeys(value);
        
    }

    public static void jsClick(WebElement element) {

        WebDriver driver = WebDriverFactory.getDriver();

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                element
        );
    }

    public static void scrollIntoView(WebElement element) {

        WebDriver driver = WebDriverFactory.getDriver();

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                element
        );
    }

    public static void hover(WebElement element) {

        WebDriver driver = WebDriverFactory.getDriver();

        Actions actions = new Actions(driver);

        actions.moveToElement(element)
               .perform();
    }

    public static String getText(WebElement element) {

        WaitUtils.waitForVisibility(element);

        return element.getText();
    }

    public static boolean isDisplayed(WebElement element) {

        try {

            WaitUtils.waitForVisibility(element);

            return element.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}