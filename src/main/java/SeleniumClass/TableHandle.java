package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class TableHandle {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		List<WebElement>rows = driver.findElements(By.xpath("//tr[contains(@style,'box-sizing:')]"));
		for (WebElement r:rows
			 ) {
			if(r.getText().contains("Google")){
				System.out.println(r.getText());
			}
		}
		
		driver.quit();
	}
}
