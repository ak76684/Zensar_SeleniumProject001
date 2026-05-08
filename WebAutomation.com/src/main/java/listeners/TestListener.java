package listeners;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import io.qameta.allure.Allure;

public class TestListener implements ITestListener {

    // =========================================
    // TEST SUCCESS
    // =========================================
    @Override
    public void onTestSuccess(ITestResult result) {

        WebDriver driver = getDriver(result);

        if (driver == null) {

            System.out.println("Driver is NULL");
            return;
        }

        System.out.println("Test Passed: " + result.getName());

        // Execution Time
        long executionTime =
                result.getEndMillis() - result.getStartMillis();

        Allure.addAttachment(
                "Execution Time",
                executionTime + " ms"
        );

        // Current URL
        try {

            Allure.addAttachment(
                    "Current URL",
                    driver.getCurrentUrl()
            );

        } catch (Exception e) {

            Allure.addAttachment(
                    "Current URL",
                    "Unable to capture URL"
            );
        }

        // Lightweight Success Log
        String successLog =
                "Test Case Passed Successfully\n"
                + "Test Name : " + result.getName() + "\n"
                + "Status    : PASSED\n"
                + "Browser   : " + driver.getClass().getSimpleName();

        Allure.addAttachment(
                "Execution Log",
                successLog
        );
    }

    // =========================================
    // TEST FAILURE
    // =========================================
    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = getDriver(result);

        if (driver == null) {

            System.out.println("Driver is NULL");
            return;
        }

        System.out.println("Test Failed: " + result.getName());

        // Attach Screenshot
        attachScreenshot(driver);

        // Attach Failure Details
        if (result.getThrowable() != null) {

            Allure.addAttachment(
                    "Failure Reason",
                    result.getThrowable().toString()
            );

            Allure.addAttachment(
                    "Stack Trace",
                    getStackTrace(result.getThrowable())
            );
        }
    }

    // =========================================
    // TEST SKIPPED
    // =========================================
    @Override
    public void onTestSkipped(ITestResult result) {

        Allure.addAttachment(
                "Skipped Test",
                result.getName()
        );
    }

    // =========================================
    // SCREENSHOT ATTACHMENT
    // =========================================
    private void attachScreenshot(WebDriver driver) {

        byte[] screenshot =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

        System.out.println("Screenshot Size: " + screenshot.length);

        Allure.getLifecycle().addAttachment(
                "Failure Screenshot",
                "image/png",
                "png",
                new ByteArrayInputStream(screenshot)
        );
    }

    // =========================================
    // GET DRIVER
    // =========================================
    private WebDriver getDriver(ITestResult result) {

        try {

            return ((BaseTest) result.getInstance()).driver;

        } catch (Exception e) {

            return null;
        }
    }

    // =========================================
    // STACK TRACE FORMATTER
    // =========================================
    private String getStackTrace(Throwable throwable) {

        StringBuilder sb = new StringBuilder();

        for (StackTraceElement element : throwable.getStackTrace()) {

            sb.append(element.toString())
              .append("\n");
        }

        return sb.toString();
    }
}