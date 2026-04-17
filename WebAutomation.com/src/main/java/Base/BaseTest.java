package Base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Base.WebDriverFactory;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverFactory.initDriver();
		driver = WebDriverFactory.getDriver();
		driver.get(PropertyReaderFile.get("base.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown() {
		WebDriverFactory.quitDriver();
	}


}
