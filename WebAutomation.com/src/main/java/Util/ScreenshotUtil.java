package Util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        if (driver == null) {

            System.out.println("Driver is NULL — Screenshot not taken");
            return null;

        }

        try {

            // Wait to allow UI rendering
            Thread.sleep(800);

            // Ensure page fully loaded
            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            js.executeScript(
                "return document.readyState"
            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        String timestamp =
            new SimpleDateFormat("yyyyMMdd_HHmmss")
            .format(new Date());

        String folderPath =
            System.getProperty("user.dir")
            + "/screenshots/";

        File folder = new File(folderPath);

        if (!folder.exists()) {

            folder.mkdirs();

        }

        String screenshotPath =
            folderPath
            + testName + "_"
            + timestamp + ".png";

        File src =
            ((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.FILE);

        File dest =
            new File(screenshotPath);

        try {

            FileUtils.copyFile(src, dest);

            System.out.println(
                "Screenshot saved at: "
                + screenshotPath);

        }

        catch (IOException e) {

            e.printStackTrace();

        }

        return screenshotPath;
    }
}