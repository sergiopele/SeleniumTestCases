package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.DocFlavor;
import java.util.concurrent.TimeUnit;

public class LocatingElements {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys("blaBla");
		
		
		driver.findElement(By.id("pass")).sendKeys("passwordHere");
		
		driver.findElement(By.xpath("//button[@type='submit']"));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(By.linkText("Forgotten password?")).click();
		driver.findElement(By.linkText("Create New Account")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}
}
