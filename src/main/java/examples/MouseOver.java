package main.java.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class MouseOver {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		WebElement artCategory = driver.findElement(By.xpath("(//a[text()='Collectibles & Art'])[2]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(artCategory).perform();
		action.click().perform();
		
	}
}
