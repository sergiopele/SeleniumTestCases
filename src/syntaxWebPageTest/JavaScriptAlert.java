package syntaxWebPageTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://syntaxprojects.com/index.php");
		driver.findElement(By.xpath("//a[text()=' Start Practising ']")).click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='list-group-item'][5]")).click();
		
		WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click me!']"));
		clickButton.click();
		
		//Switch to alert box
		
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		Thread.sleep(2000);
		
		alert1.accept();
		
		//switch back to parent(Main) window
		
		driver.switchTo().parentFrame();
		
		//I create loop to perform all possible scenarios with pop up window  (ok / cancel)
		
		for (int i = 0; i < 2; i++) {
			
			WebElement clickButton2 = driver.findElement(By.xpath("(//button[text()='Click me!'])[2]"));
			clickButton2.click();
			
			Alert alert2 = driver.switchTo().alert();
			System.out.println(alert2.getText() + (i + 1));
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			if (i == 0) {
				alert2.accept();
				Thread.sleep(1000);
				
			} else {
				alert2.dismiss();
				Thread.sleep(1000);
			}
			System.out.println(driver.findElement(By.id("confirm-demo")).getText());
		}
		
		WebElement clickButton3 = driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
		clickButton3.click();
		
		Thread.sleep(2000);
		
		//in this case we have alert prompt window (have to enter value in window)
		
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		Thread.sleep(2000);
		
		//here I use "sendKeys" method to fill up textBox
		
		alert3.sendKeys("It's Serhii's test performance");
		Thread.sleep(1000);
		
		alert3.accept();
		
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'You have')]")).getText());
		Thread.sleep(2000);
		
		driver.quit();
		
	}
}
