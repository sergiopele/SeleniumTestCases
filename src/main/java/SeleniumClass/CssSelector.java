package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://syntaxprojects.com/basic-radiobutton-demo.php");
		WebElement radioButtonMale = driver.findElement(By.cssSelector("input[value^='Male']"));
		
		System.out.println("is radioButton Male enabled? " + radioButtonMale.isEnabled());
		
		System.out.println("is radioButtonMale displayed? " + radioButtonMale.isDisplayed());
		
		if (!radioButtonMale.isSelected()) {
			radioButtonMale.click();
		}
		
		System.out.println("is radioButton Male selected? " + radioButtonMale.isSelected());
		
		WebElement checkButton = driver.findElement(By.id("buttoncheck"));
		checkButton.click();
		
		WebElement catchVisibleText = driver.findElement(By.xpath("//p[@class='radiobutton']"));
		System.out.println(catchVisibleText.getText());
		
	}
}
