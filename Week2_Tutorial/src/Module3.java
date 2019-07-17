import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Module3 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/shangeetha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		WebDriverUtils utils = new WebDriverUtils(driver);
		driver.navigate().to("https://wikipedia.org");
		
		utils.takeScreenShot("Wikipedia_home_page");
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("#www-wikipedia-org > p > small:nth-child(2)")).click();
		utils.takeScreenShot("Wiki_terms_of_use");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("#footer-places-privacy > a")).click();
		utils.takeScreenShot("Wiki_privacy");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
