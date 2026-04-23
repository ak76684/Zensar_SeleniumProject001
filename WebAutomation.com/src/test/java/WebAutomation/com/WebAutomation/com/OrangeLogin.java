package WebAutomation.com.WebAutomation.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeLogin {

    @Test
    public void loginAndGoToAdmin() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open
        driver.get("https://opensource-demo.orangehrmlive.com");

        // Login
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Go to Admin page
       //Thread.sleep(3000); // simple wait
        //driver.findElement(By.xpath("//span[text()='Admin']")).click();

       // Thread.sleep(3000); // just to see result
        driver.quit();
    }
}


