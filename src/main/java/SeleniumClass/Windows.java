package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Windows {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String parent = driver.getWindowHandle();
		
		WebElement privacyButton = driver.findElement(By.linkText("Privacy"));
		privacyButton.click();
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		
		WebElement helpButton = driver.findElement(By.linkText("Help"));
		helpButton.click();
		driver.switchTo().window(parent);
		
		ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.id("policychanges"));
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		
		driver.switchTo().window(windows.get(2));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		WebElement visibleElement = driver.findElement(By.xpath("//h2[text()='Protect your account']"));
		js.executeScript("arguments[0].scrollIntoView();", visibleElement);
		driver.quit();
		
	}
}
