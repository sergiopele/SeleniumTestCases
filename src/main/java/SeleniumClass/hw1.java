package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class hw1 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		
		//navigate to google.com
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String parentWindow = driver.getWindowHandle();
		//click on "Help"
		WebElement helpButton = driver.findElement(By.linkText("Help"));
		helpButton.click();
		//go back to parent	Window
		driver.switchTo().window(parentWindow);
		//click on "Privacy"
		WebElement privacyButton = driver.findElement(By.linkText("Privacy"));
		privacyButton.click();
		
		ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement community = driver.findElement(By.linkText("Community"));
		community.click();
		
		driver.switchTo().window(windows.get(0));
		WebElement usernameBox = driver.findElement(By.xpath("//input[@autocomplete='username']"));
		usernameBox.sendKeys("It's me");
		driver.quit();
		
		
		
		
		
		
		
		
	}
}
