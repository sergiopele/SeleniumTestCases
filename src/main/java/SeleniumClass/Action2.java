package main.java.SeleniumClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act = new Actions(driver);
		act.contextClick(rightClick).perform();
		WebElement quit = driver.findElement(By.xpath("//span[text()='Quit']"));
		
		act.moveToElement(quit).click().build().perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.quit();
		
		
		
	}
}
