package SeleniumClass;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

public class hw {
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://chercher.tech/practice/frames");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement frame = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame);
		
		WebElement topic= driver.findElement(By.tagName("input"));
		topic.sendKeys("DONE");
		
		WebElement innerFrame = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(innerFrame);
		
		WebElement checkkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkkBox.click();
		
		driver.switchTo().defaultContent();
		
		
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		
		WebElement selectBox = driver.findElement(By.id("animals"));
		Select select=new Select(selectBox);
		select.selectByVisibleText("Baby Cat");
		
		driver.quit();
		
		
		
	}
}
