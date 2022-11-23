package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Keys {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		
		WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
		userName.sendKeys("Tester");
		WebElement pass= driver.findElement(By.id("ctl00_MainContent_password"));
		pass.sendKeys("test",org.openqa.selenium.Keys.ENTER);
		driver.quit();
	}
}
