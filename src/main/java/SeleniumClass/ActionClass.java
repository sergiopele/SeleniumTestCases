package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		WebElement languageButton = driver.findElement(By.xpath("//p[contains(text(),'Drag me')]"));
		WebElement dopHere = driver.findElement(By.xpath("//p[contains(text(),'Drop')]"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(languageButton,dopHere).perform();
		driver.switchTo().defaultContent();
		driver.quit();
	}
}
