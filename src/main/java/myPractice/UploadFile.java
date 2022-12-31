package main.java.myPractice;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class UploadFile {
	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		/*
		driver.get("http://the-internet.herokuapp.com/upload");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement chooseFile = driver.findElement(By.id("file-upload"));
		Actions act = new Actions(driver);
		act.moveToElement(chooseFile).click().build().perform();
		chooseFile.sendKeys("/Users/sergiopele/Desktop/1.png");
		WebElement submit = driver.findElement(By.id("file-submit"));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//*[starts-with(text(),'Click')]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("(//*[starts-with(text(),'Click')])[2]")).click();
		alert.dismiss();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("(//*[starts-with(text(),'Click')])[3]")).click();
		alert.sendKeys("holly molly");
		alert.accept();
		 */
		/*driver.get("https://the-internet.herokuapp.com/key_presses");
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.id("target"));
		element.click();
		act.sendKeys(Keys.ESCAPE).build().perform();
		act.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ALT).build().perform();
		 */
		
		
		
	}
}
