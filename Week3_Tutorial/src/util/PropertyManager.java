package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
	
	public String orderFormEmailField = "";
	public String orderFormEmailValue = "";
	
	public void generateProperty() {
		Properties properties = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream("src/parameters.properties");
			properties.load(input);
			
			orderFormEmailField = properties.getProperty("name_field").toString();
			orderFormEmailValue = properties.getProperty("name_value").toString();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
