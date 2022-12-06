package main.practice.Herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/drag_and_drop");
		WebElement a = driver.findElement(By.id("column-a"));
		WebElement b = driver.findElement(By.id("column-b"));
		
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(a).moveToElement(b).release().build().perform();
		//actions.dragAndDrop(b,a).perform();
	}
}
