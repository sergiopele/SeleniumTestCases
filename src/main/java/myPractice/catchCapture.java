package main.java.myPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class catchCapture {
	/*
	Test Steps:
1. Launch Browser
2. Navigate to the User Registration page (https://www.gcreddy.com/discussiongroup/ucp.php?mode=register)
3. Click “I agree to these terms” Button
4. Enter Username
5. Enter Email Address
6. Enter password
7. Confirm password
8. Enter Captcha (verification code)
9. Click Submit button

Verification Point:
Capture the confirmation message and compare it with expected

Expected:
Your account has been created.

Input Data / Test Data:
Name: Indianew
Email: Indianew12@gmail.com
Password: Abcd123
Confirmation:Abcd123
Confirmation code: * Dynamic Data
	 */
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gcreddy.com/discussiongroup/ucp.php?mode=register");
		
		driver.findElement(By.xpath(""));
	}
}
