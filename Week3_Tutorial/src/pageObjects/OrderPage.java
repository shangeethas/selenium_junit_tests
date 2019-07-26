package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends AbstractPage {

	public OrderPage(WebDriver driver) {
		super(driver);
	}
	
	public OrderPage fillFormWithData() {
		System.out.println("OrderPage::fillFormWithData called");
		driver.findElement(By.name("email")).sendKeys("test@email");
		driver.findElement(By.name("password")).sendKeys("test password");
		return new OrderPage(driver);		
	}
	
	public OrderResultPage submitForm() {
		System.out.println("OrderPage::submitForm called");
		driver.findElement(By.id("signInSubmit")).click();
		return new OrderResultPage(driver);		
	}
}
