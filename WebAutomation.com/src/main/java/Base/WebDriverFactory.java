package Base;
import Base.PropertyReaderFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

	private WebDriverFactory() {
	}

	public static void initDriver() {

		String browser = PropertyReaderFile.get("browser");
		boolean isHeadless = PropertyReaderFile.getBoolean("headless");

		WebDriver driver;

		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();

			if (isHeadless) {
				chromeOptions.addArguments("--headless=new");
			}

			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--disable-notifications");
//			chromeOptions.addArguments("--remote-allow-origins=*");
//			chromeOptions.addArguments("--incognito");

			driver = new ChromeDriver(chromeOptions);
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();

			if (isHeadless) {
				edgeOptions.addArguments("--headless=new");
			}

			edgeOptions.addArguments("--start-maximized");

			driver = new EdgeDriver(edgeOptions);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();

			if (isHeadless) {
				firefoxOptions.addArguments("--headless");
			}

			driver = new FirefoxDriver(firefoxOptions);
			break;

		default:
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}

		DRIVER.set(driver);
	}

	public static WebDriver getDriver() {
		return DRIVER.get();
	}

	public static void quitDriver() {
		if (DRIVER.get() != null) {
			DRIVER.get().quit();
			DRIVER.remove();
		}
	}

}
