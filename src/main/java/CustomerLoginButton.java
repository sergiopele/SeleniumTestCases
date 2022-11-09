package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Test Steps:
1. Launch Browser
2. Navigate to gcrShop User Interface Login Page (https://gcreddy.com/project/login.php)
3. Enter E-Mail Address
4. Enter Password
5. Click “Sign In” Button

Input Data/Test Data:
E-mail Address: meghala1234S@gmail.com
Password: xyz4321

Verification Point:
Verify the Existence of the “Log Off” Link…
 */

public class CustomerLoginButton {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://gcreddy.com/project/login.php");
		driver.findElement(By.xpath("//input[@name='email_address']")).sendKeys("meghala1234S@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("xyz4321");
		
		driver.findElement(By.id("tdb1")).click();
		
		Thread.sleep(4000);
		
		try {
			boolean logOutButton = driver.findElement(By.linkText("Log Off")).isDisplayed();
			if (logOutButton) {
				System.out.println("Log off button exist --- PASSED");
			}
		} catch (NoSuchElementException e1) {
			System.out.println("Log off button doesn't exist --- FAIL");
		}
		driver.close();
		
	}
}
