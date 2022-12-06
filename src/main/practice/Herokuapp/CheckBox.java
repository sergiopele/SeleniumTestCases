package main.practice.Herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBox {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		
		if(!(checkBox1.isSelected())) checkBox1.click();
		if((checkBox2.isSelected())) checkBox2.click();
		
		System.out.println("is checkbox 1 selected: "+checkBox1.isSelected()+"\nis checkbox 2 deselected: "+!checkBox2.isSelected());
		driver.quit();
		
	}
}
