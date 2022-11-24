package main.practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class BasicAuth {
	public static String logIn = "admin";
	public static String pass = "admin";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://"+logIn+":"+pass+"@the-internet.herokuapp.com/basic_auth");
		WebElement success = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper crede')]"));
		if(success.isDisplayed()) System.out.println("YOU ARE GOOD");
		driver.quit();
	}
}
