package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUp {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		WebElement loginBox = driver.findElement(By.id("txtUsername"));
		javascriptExecutor.executeScript("arguments[0].style.backgroundColor='blue'",loginBox);
		//driver.quit();
	}
}
