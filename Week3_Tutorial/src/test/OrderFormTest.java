package test;

import org.junit.Test;
import org.openqa.selenium.By;

import junit.framework.Assert;

public class OrderFormTest extends AbstractTestDriver{
	
	@SuppressWarnings("deprecation")
	@Test
	public void shouldPopulateForm() {
		//Navigate to Amazon Web site
		driver.navigate().to("https://www.amazon.com.au/");
		
		//Click on Orders Form
		driver.findElement(By.cssSelector("#nav-orders > span.nav-line-2")).click();
		
		//Populate Order Form
		driver.findElement(By.name(propertyManager.orderFormEmailField)).sendKeys(propertyManager.orderFormEmailValue);
		driver.findElement(By.name("password")).sendKeys("test password");
		
		//Submit Order Form
		driver.findElement(By.id("signInSubmit")).click();
		
		//Check whether error message has been received
		Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("There was a problem"));
	}

}
