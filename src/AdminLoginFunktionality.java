import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. Launch Browser
2. Navigate / launch /load login page of admin interface of the gcrShop application
(http://gcreddy.com/project/admin/login.php)
3. Enter valid “Username”
4. Enter valid “Password”
5. Click on “Login” Button
6. Capture the current URL
7. Close the Browser window

Verification Point
Compare the captured URL with Expected

Input / Test Data:
Username = gcreddy
Password = Temp@2020

Expected Result:
http://gcreddy.com/project/admin/index.php

Actual Result: * After Test Case Execution

Test Result: pass/fail (* After Test Case Execution)


 */

public class AdminLoginFunktionality {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://gcreddy.com/project/admin/login.php");
		
		driver.findElement(By.name("username")).sendKeys("gcreddy");
		driver.findElement(By.name("password")).sendKeys("Temp@2020");
		driver.findElement(By.id("tdb1")).click();
		
		
		try {
			boolean status = driver.findElement(By.linkText("Logoff")).isDisplayed();
			
			if (status) {
				System.out.println("Test result --- PASSED");
			}
		} catch (NoSuchElementException e1) {
			System.out.println("Test result --- FAILED");
		}
		driver.close();
	}
}
