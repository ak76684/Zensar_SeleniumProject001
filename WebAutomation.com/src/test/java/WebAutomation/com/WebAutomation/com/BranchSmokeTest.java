
package WebAutomation.com.WebAutomation.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BranchSmokeTest {

    public static void main(String[] args) throws Exception {

        System.out.println("PROGRAM STARTED");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        Thread.sleep(5000); // browser ko 5 sec dikhne do
        driver.quit();
    }
}