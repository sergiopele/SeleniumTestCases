package main.java.syntaxWebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtons {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://syntaxprojects.com/index.php");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement roundTabs = driver.findElement(By.xpath("//span[contains(@class,'two')]"));
		roundTabs.click();
		
		WebElement selectChoice = driver.findElement(By.xpath("//a[3][@class='list-group-item']"));
		selectChoice.click();
		
		Thread.sleep(2000);
		
		WebElement radioButtonMale = driver.findElement(By.xpath("//input[contains(@value,'Male')]"));
		
		radioButtonMale.click();
		
		
		WebElement checkButton = driver.findElement(By.id("buttoncheck"));
		checkButton.click();
		
		Thread.sleep(2000);
		
		WebElement radioButtonFemale = driver.findElement(By.xpath("//input[@value='Female']"));
		radioButtonFemale.click();
		
		checkButton.click();
		
		Thread.sleep(2000);
		
		String[] multipleRadioButton = {"//input[@name='gender']", "//input[contains(@value,'50')]", "//button[contains(text(),'values')]"};
		for (String i : multipleRadioButton) {
			driver.findElement(By.xpath(i)).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(1000);
		
		driver.quit();
	}
	
}
