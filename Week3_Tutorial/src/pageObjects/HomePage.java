package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public OrderPage clickOnOrder() {
		System.out.println("HomePage::clickOnOrder called");
		WebElement element = driver.findElement(By.cssSelector("#nav-orders > span.nav-line-2"));
		element.click();
		return new OrderPage(driver);
		
	}

}
