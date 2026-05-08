package base;
import org.testng.annotations.AfterMethod;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import base.WebDriverFactory;
import groovy.cli.Option;

@Listeners({
    io.qameta.allure.testng.AllureTestNg.class,
    listeners.TestListener.class,
   // utils.RetryTransformer.class
})

public class BaseTest {

	public WebDriver driver;
	@Parameters("browser")
	
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("") String browser) {
		
		if (browser==null || browser.trim().isEmpty()) {
			
			browser = PropertyReaderFile.get("browser");
			System.out.println(
	                "Browser picked from property file : "
	                + browser);
		}else {

	        System.out.println(
	                "Browser picked from testng.xml : "
	                + browser
	        );
	    }
		
		WebDriverFactory.initDriver(browser);
		driver = WebDriverFactory.getDriver();
		driver.get(PropertyReaderFile.get("base.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	
	
	@AfterMethod(alwaysRun = true)
    public void tearDown() {

        // DO NOT quit before listener execution

        if (driver != null) {

            driver.quit();
        }
    }
	


}
