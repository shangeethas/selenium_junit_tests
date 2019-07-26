package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.PropertyManager;

import org.junit.After;
import org.junit.Before;

public class AbstractTestDriver {
	
	protected WebDriver driver;
	protected PropertyManager propertyManager;
	
	@Before 
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/shangeetha/Downloads/chromedriver");
		driver = new ChromeDriver();
		propertyManager = new PropertyManager();
		propertyManager.generateProperty();
		
	}
	
	@After
	public void shutDown()
	{
		driver.close();
	}
}