package main.java.myPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. Launch the Browser
2. Navigate to wikipedia.org selenium page
3. Click the “Create account” link
4. Capture the URL
5. Navigate back to Selenium Page
6. Click the “selenium.dev” link
7. Capture the URL
8. Close the Browser

Verification Point/s:
1. Verify if the 1st URL is an Internal link
2. Verify if the 2nd URL is an External link

Input Data/Test Data:
NA
 */

public class Main {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://en.wikipedia.org/wiki/Selenium_(software)#Selenium_WebDriver");
		driver.findElement(By.linkText("Create account")).click();
		
		String url = driver.getCurrentUrl();
		
		if (url.contains("wikipedia.org")) {
			System.out.println(url+"- it's internal link --- PASSED");
		} else {
			System.out.println(url+"- it's external link --- FAIL");
		}
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("selenium.dev")).click();
		
		String url2 = driver.getCurrentUrl();
		
		if (url2.contains("selenium.dev")) {
			System.out.println(url2+" it's external link --- PASSED");
		} else {
			System.out.println(url2+" it's internal link --- FAIL");
		}
		driver.close();
	}
}