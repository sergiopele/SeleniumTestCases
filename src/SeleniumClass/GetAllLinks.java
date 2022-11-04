package SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class GetAllLinks {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		ArrayList<WebElement> allLinksOnWeb = new ArrayList<>(driver.findElements(By.tagName("a")));
		System.out.println(allLinksOnWeb.size());
		
		for (WebElement links : allLinksOnWeb) {
			String link = links.getAttribute("href");
			System.out.println(link);
		}
		driver.quit();
	}
}
