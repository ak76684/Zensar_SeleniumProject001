package Base;
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
	}

	@AfterMethod
	public void tearDown() {
		WebDriverFactory.quitDriver();
	}


}
