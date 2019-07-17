import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Module4 {

	public static void main(String[] args) throws Exception  {
		System.setProperty("webdriver.chrome.driver", "/Users/shangeetha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		WebDriverUtils util = new WebDriverUtils(driver);
		driver.navigate().to("https://www.google.com.au/maps/");
		
		//Search Flinders Street Station
		driver.findElement(By.tagName("input")).sendKeys("Flinders Street Station");
		driver.findElement(By.cssSelector("button.searchbox-searchbutton")).click();
		try {
			Thread.sleep(4000);
			util.takeScreenShot("Flinders Street Station");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Search Federation Square
		driver.findElement(By.cssSelector("a.gsst_a")).click(); // clear input
		driver.findElement(By.tagName("input")).sendKeys("Federation Square");
		driver.findElement(By.cssSelector("button.searchbox-searchbutton")).click();
		try {
			Thread.sleep(4000);
			util.takeScreenShot("Federation Square");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Search Great Ocean Road
		driver.findElement(By.cssSelector("a.gsst_a")).click(); // clear input
		driver.findElement(By.tagName("input")).sendKeys("Great Ocean Road");
		driver.findElement(By.cssSelector("button.searchbox-searchbutton")).click();
		try {
			Thread.sleep(4000);
			util.takeScreenShot("Great Ocean Road");
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();

	}

}
