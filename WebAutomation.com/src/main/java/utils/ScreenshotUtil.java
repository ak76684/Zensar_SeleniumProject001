//package Util;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//public class ScreenshotUtil {
//
//    public static String captureScreenshot(
//            WebDriver driver,
//            String testName) {
//
//        if (driver == null) {
//
//            System.out.println("Driver is NULL — Screenshot not taken");
//            return null;
//
//        }
//
//        try {
//
//            // Wait to allow UI rendering
//            Thread.sleep(800);
//
//            // Ensure page fully loaded
//            JavascriptExecutor js =
//                    (JavascriptExecutor) driver;
//
//            js.executeScript(
//                "return document.readyState"
//            );
//
//        }
//
//        catch (Exception e) {
//
//            e.printStackTrace();
//
//        }
//
//        String timestamp =
//            new SimpleDateFormat("yyyyMMdd_HHmmss")
//            .format(new Date());
//
//        String folderPath =
//            System.getProperty("user.dir")
//            + "/screenshots/";
//
//        File folder = new File(folderPath);
//
//        if (!folder.exists()) {
//
//            folder.mkdirs();
//
//        }
//
//        String screenshotPath =
//            folderPath
//            + testName + "_"
//            + timestamp + ".png";
//
//        File src =
//            ((TakesScreenshot) driver)
//            .getScreenshotAs(OutputType.FILE);
//
//        File dest =
//            new File(screenshotPath);
//
//        try {
//
//            FileUtils.copyFile(src, dest);
//
//            System.out.println(
//                "Screenshot saved at: "
//                + screenshotPath);
//
//        }
//
//        catch (IOException e) {
//
//            e.printStackTrace();
//
//        }
//
//        return screenshotPath;
//    }
//    
//    public static byte[] captureScreenshotForAllure(WebDriver driver) {
//
//        if (driver == null) {
//            return null;
//        }
//
//        return ((TakesScreenshot) driver)
//                .getScreenshotAs(OutputType.BYTES);
//    }
//}


package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private static final String SCREENSHOT_DIR =
            System.getProperty("user.dir") + "/screenshots/";

    // Capture and SAVE screenshot (for local/debugging)
    public static String captureAndSave(WebDriver driver, String testName) {

        if (driver == null) {
            throw new RuntimeException("Driver is NULL — Cannot capture screenshot");
        }

        waitForPageLoad(driver);

        String timestamp = getTimestamp();

        createFolderIfNotExists();

        String filePath = SCREENSHOT_DIR + testName + "_" + timestamp + ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(filePath));
        } catch (IOException | WebDriverException e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }

        return filePath;
    }

    // Capture screenshot for Allure (NO file saving)
    public static byte[] captureForAllure(WebDriver driver) {

        if (driver == null) {
            return new byte[0];
        }

        try {
            waitForPageLoad(driver);
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            return new byte[0];
        }
    }

    // Wait until page fully loaded
    private static void waitForPageLoad(WebDriver driver) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(d ->
                            ((JavascriptExecutor) d)
                                    .executeScript("return document.readyState")
                                    .equals("complete")
                    );
        } catch (Exception ignored) {
        }
    }

    // Timestamp generator
    private static String getTimestamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
    }

    // Ensure folder exists
    private static void createFolderIfNotExists() {
        File folder = new File(SCREENSHOT_DIR);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }
}