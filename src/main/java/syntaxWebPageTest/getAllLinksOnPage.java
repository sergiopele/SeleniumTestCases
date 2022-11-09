package main.java.syntaxWebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class getAllLinksOnPage {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://syntaxprojects.com/data-list-filter-demo.php");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		
		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println("Links on this page : " + allLinks.get(i).getAttribute("href"));
			System.out.println("Links on the page : " + allLinks.get(i).getText());
		}
		driver.quit();
	}
}
