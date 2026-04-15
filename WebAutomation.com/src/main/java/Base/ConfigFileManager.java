package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileManager {

	private static final Properties PROPERTIES = new Properties();

	static {
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			PROPERTIES.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config file");
		}
	}

	public static String get(String key) {
		String value = System.getProperty(key);
		return value != null ? value : PROPERTIES.getProperty(key);
	}

	public static boolean getBoolean(String key) {
		return Boolean.parseBoolean(get(key));
	}

}
