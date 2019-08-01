package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AlertWindowTest {
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/shangeetha/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.bunnings.com.au/register");
	}
	
	@After
	public void shutDown() {
		driver.close();
	}
	
	/*@Test
	public void alertTest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.id("modalWindowRegisterBtn")).click();
		
		driver.findElement(By.id("firstName")).sendKeys("");
		driver.findElement(By.id("modalWindowRegisterStep1CreateAcctBtn")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertTrue(alert.getText().contains("Your Free Design"));
		alert.accept();
	}*/

	@Test
	public void windowTest() {

		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.className("social-channels_icon--instagram")).click();
		
		
		for (String currentWindow : driver.getWindowHandles()) {
			driver.switchTo().window(currentWindow);
		}
		
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("instagram"));
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
		
	} 
}
