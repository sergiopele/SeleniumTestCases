package main.java.SeleniumClass;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.System.*;

public class hw {
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkBox.click();
		
		WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
		removeButton.click();
		
		
		String addButton = "//button[text()='Add']";
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
		WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
		out.println("Is message 'It's gone' present on the page: "+message.isDisplayed());
		
		WebElement add = driver.findElement(By.xpath(addButton));
		add.click();
		
		
		WebElement enable = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
		enable.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
		
		WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
		out.println("Is TextBox enable: "+ textBox.isEnabled());
		textBox.sendKeys("qweqrwerqew");
		enable.click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button[@onclick='swapInput()']"),"Enable"));
		out.println("Is TextBox enable: "+ textBox.isEnabled());
		
		driver.quit();
		
		
		
	}
}
