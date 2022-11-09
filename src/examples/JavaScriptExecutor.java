package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.javascript.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.title";
		String title = (String) js.executeScript(script);
		//js.executeScript("button button--pink button--small");
		System.out.println(title);
		//driver.quit();
		WebElement buttonHighlight = driver.findElement(By.xpath("//a[text()='Try JavaScript']"));
		js.executeScript("arguments[0].style.border='10px solid green'",buttonHighlight );
		Thread.sleep(4000);
		WebElement buttonWeb = driver.findElement(By.xpath("(//a[@target='_self'])[8]"));
		js.executeScript("arguments[0].scrollIntoView(true);",buttonWeb);
		js.executeScript("alert('Welcome to Hell');");
	}
}
