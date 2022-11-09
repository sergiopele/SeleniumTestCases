package SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class iFrame {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.get("https://syntaxprojects.com/bootstrap-iframe.php");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("FrameOne")));
		WebElement frame = driver.findElement(By.name("FrameOne"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("asdfdsaf");
		driver.switchTo().parentFrame();
		
		WebElement frame2 = driver.findElement(By.name("FrameTwo"));
		driver.switchTo().frame(frame2);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@tabindex='3']")));
		
		driver.findElement(By.xpath("//button[@tabindex='3']")).click();
	}
}
