package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.WebDriverFactory;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 10;

    private WaitUtils() {
    }

    private static WebDriverWait getWait(int timeout) {

        WebDriver driver = WebDriverFactory.getDriver();

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(timeout)
        );
    }

    public static void waitForVisibility(WebElement element) {

        getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickability(WebElement element) {

        getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForInvisibility(WebElement element) {

        getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForText(WebElement element, String text) {

        getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitForPageLoad() {

        WebDriver driver = WebDriverFactory.getDriver();

        getWait(DEFAULT_TIMEOUT).until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }
}