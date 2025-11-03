package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	private PropertiesUtil() {

	}

	public static String readFromProperties(String key) {
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/config/qa.properties");
		Properties prop = new Properties();
		FileReader fr;
		String data = null;
		try {
			fr = new FileReader(file);
			prop.load(fr);
			data = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

}
