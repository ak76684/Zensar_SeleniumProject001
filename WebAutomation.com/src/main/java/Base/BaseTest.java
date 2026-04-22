package Base;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import Base.WebDriverFactory;

public class BaseTest {

	public WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverFactory.initDriver();
		driver = WebDriverFactory.getDriver();
		driver.get(PropertyReaderFile.get("base.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		WebDriverFactory.quitDriver();
	}


}
