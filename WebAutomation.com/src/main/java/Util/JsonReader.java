package Util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonReader {
	

	private static final ObjectMapper mapper = new ObjectMapper();

	public static <T> T getTestData(String fileName
			, Class<T> clazz) {
		try {
			return mapper.readValue(new File("src/main/resources/testdata/" + fileName), clazz);
		} catch (Exception e) {
			throw new RuntimeException("Failed to read JSON file: " + fileName, e);
		}
	}

}
