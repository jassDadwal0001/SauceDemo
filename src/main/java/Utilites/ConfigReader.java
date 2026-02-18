package Utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	
	public ConfigReader() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+ "/src/main/java/configuration/config_properties.properties");
		prop = new Properties();
		prop.load(fis);
	}
	
	public String getProperty(String Key)
	{
		return prop.getProperty(Key);
	}
	
}
