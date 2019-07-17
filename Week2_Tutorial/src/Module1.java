import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Module1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/shangeetha/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://docs.seleniumhq.org/");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("#menu_download a")).click();
		List<WebElement> contents = driver.findElements(By.cssSelector("h3"));
		for (int i = 0; i < contents.size(); i++) {
			WebElement temp = contents.get(i);
			System.out.println("Next to the Tag, we have found : " + temp.getText());
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
