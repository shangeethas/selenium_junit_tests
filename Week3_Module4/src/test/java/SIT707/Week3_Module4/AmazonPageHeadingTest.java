package SIT707.Week3_Module4;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPageHeadingTest {
	WebDriver driver;
	ExcelFileHandler excelFileHandler;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/shangeetha/Downloads/chromedriver");
		driver = new ChromeDriver();
		excelFileHandler = new ExcelFileHandler();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void shouldTestPageHeading() {
		List<List<String>> data = excelFileHandler.readFromFile("FormNames.xlsx");
		List<String> results = new ArrayList<String>();
		results.add("Results");
		
		driver.navigate().to("https://www.amazon.com.au/");
		for(int i = 1; i < data.size(); i++) { //row exclude heading
			for (int j =0; j < data.size(); j++) { //column
				System.out.println(data.get(i).get(j).toString());
				driver.findElement(By.name(data.get(i).get(j).toLowerCase() + "_field")).
				sendKeys(data.get(i).get(++j).toLowerCase()); //find the element
				j++;
				
			}
		}
		driver.findElement(By.cssSelector("#nav-orders > span.nav-line-2")).click();
		if (driver.getTitle().contains("Contact Confirmation")) {
			results.add("PASS");
		}else {
			results.add("FAIL");
		}
		excelFileHandler.writeToFile("src/FormResults.xlsx", results);
	}
}
