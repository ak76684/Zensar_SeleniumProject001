
package WebAutomation.com.WebAutomation.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BranchSmokeTestTestNG {

    @Test
    public void smokeTest() throws InterruptedException  {

        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://www.google.com");
        //System.out.println("TestNG branch test running");

        Thread.sleep(5000);
        driver.quit();
    }
}
