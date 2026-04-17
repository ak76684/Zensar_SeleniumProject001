package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderFile {

	private static final Properties PROPERTIES = new Properties();

	static {
		String path = "src/main/resource/config.properties";
		try {
			FileInputStream fis = new FileInputStream(path);
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
	
	public static String getSecure(String key) {
	    String value = System.getenv(key);

	    if (value != null && !value.isEmpty()) {
	        return value;
	    }

	    value = System.getProperty(key);

	    return PROPERTIES.getProperty(key);
	}

}
