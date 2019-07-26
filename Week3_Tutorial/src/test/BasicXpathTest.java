package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicXpathTest {
	
	@Test
	public void xPathTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/shangeetha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com.au/");
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"createAccountSubmit\"]")).click();
		
		driver.close();
	}

}
