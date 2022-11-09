package SeleniumClass;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class alertWindows {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://syntaxprojects.com/javascript-alert-box-demo.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement jsAlert = driver.findElement(By.xpath("//button[text()='Click me!']"));
		jsAlert.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement jsAlert2 = driver.findElement(By.xpath("(//button[text()='Click me!'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", jsAlert2);
		
		jsAlert2.click();
		driver.switchTo().alert();
		alert.dismiss();
		
		jsAlert2.click();
		driver.switchTo().alert();
		alert.accept();
		
		WebElement jsAlert3 = driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
		jsAlert3.click();
		
		
		driver.switchTo().alert();
		alert.sendKeys("I was here");
		alert.accept();
		
		driver.quit();
		
		
	}
}
