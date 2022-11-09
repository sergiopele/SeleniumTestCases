package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. Launch the Browser
2. Navigate to Google Home page (“https://www.google.co.in”)
3. Return the “Gmail” displayed status

Verification Point/s:
Verify the existence of “Gmail” Link

Input Data:
NA
 */

public class GmailTestCase {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in");
		try {
			boolean status = driver.findElement(By.linkText("Gmail")).isDisplayed();
			
			if (status) {
				System.out.println("Link exist --- PASSED");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Gmail Link Not Exists – Failed");
		}
		
		driver.close();
		
		
	}
}
