package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest {
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
	
	@Test
	public void shouldBeAbleToSubmitForm() {
		driver.findElement(By.id("body_1_RegistrationDetailsCtrl_firstname")).sendKeys("First Name");
		driver.findElement(By.id("body_1_RegistrationDetailsCtrl_lastname")).sendKeys("Last Name");
		driver.findElement(By.id("body_1_RegistrationDetailsCtrl_postcode")).sendKeys("1111");
		driver.findElement(By.id("body_1_RegistrationDetailsCtrl_email")).sendKeys("testemail@email.com");
		driver.findElement(By.id("body_1_PasswordCtrl_password")).sendKeys("password12");
		driver.findElement(By.id("body_1_PasswordCtrl_confirmpassword")).sendKeys("password12");
		
		WebElement termsCheckBox = driver.findElement(By.id("body_1_tnc"));
		System.out.println("Terms and Conditions Check Box is enabled : " + termsCheckBox.isEnabled());
		
		Boolean isSelectedTCBox = termsCheckBox.isSelected();
		System.out.println("Terms and Conditions Check is selected : " + termsCheckBox.isSelected());
		if (isSelectedTCBox == false) {
			termsCheckBox.click();
		}
		
		WebElement promotionCheckBox = driver.findElement(By.id("body_1_promotion"));
		System.out.println("Promotions Check Box is enabled : " + promotionCheckBox.isEnabled());
		
		driver.findElement(By.id("RegisterButton")).click();		
		Assert.assertTrue(driver.getCurrentUrl().contains("register")); 
	} 
}
