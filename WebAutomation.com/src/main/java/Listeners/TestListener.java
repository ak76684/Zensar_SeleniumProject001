package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.BaseTest;
import Util.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed — Capturing Screenshot");

        // Get driver from test class
        Object testClass = result.getInstance();

   
        WebDriver driver =
                ((BaseTest) testClass).driver;

        String testName = result.getName();

        ScreenshotUtil.captureScreenshot(
                driver,
                testName);
    }
}