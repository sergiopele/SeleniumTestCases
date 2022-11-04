package SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class hw1 {
	public static void main(String[] args) {
		//@Before test
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		
		//@Text case
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//catch all category options
		WebElement cateory = driver.findElement(By.name("_sacat"));
		
		Select extractCategories = new Select(cateory);
		List<WebElement> getAllCategory = extractCategories.getOptions();
		for (WebElement webElement : getAllCategory) {
			String category = webElement.getText();
			System.out.println(category);
		}
		
		
		extractCategories.selectByVisibleText("Computers/Tablets & Networking");
		
		//click on "search button"
		WebElement searchButton = driver.findElement(By.id("gh-btn"));
		searchButton.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//catch title
		String title = driver.getTitle();
		System.out.println(title);
		
		String result = (title.equals("Computers, Laptops, Tablets & Network Hardware for Sale - eBay") ? "Title is verified" : "Title is NOT verified");
		System.out.println(result);
		
		//@Ater test
		driver.quit();
		
		
	}
}
