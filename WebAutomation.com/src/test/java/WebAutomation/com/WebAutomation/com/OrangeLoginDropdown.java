
package WebAutomation.com.WebAutomation.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeLoginDropdown {

    @Test
    public void loginAndSearchByUserRole() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open
        driver.get("https://opensource-demo.orangehrmlive.com");

        // Login
        Thread.sleep(4000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Go to Admin page
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Admin']")).click();

        // ✅ Select User Role = Admin
        Thread.sleep(3000);
        WebElement userRoleDropdown =
                driver.findElement(By.xpath("//label[text()='User Role']/following::div[contains(@class,'oxd-select-text')][1]"));
        userRoleDropdown.click();

        // Select "Admin" from dropdown
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();

        // ✅ Click Search
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        // Hold to see result
        Thread.sleep(3000);
        driver.quit();
    }
}

