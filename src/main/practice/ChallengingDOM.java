package main.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;
import java.util.List;

public class ChallengingDOM {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		List<WebElement> elements = new LinkedList<>(driver.findElements(By.xpath("//tbody//tr//td")));
		for (WebElement w : elements
		) {
			if (w.getText().contains("Phaedrum")) {
				//System.out.println(w.getText());
			}
		}
		
		List<WebElement> row = new LinkedList<>(driver.findElements(By.xpath("//tbody//tr")));
		int rows = row.size();
		List<WebElement> column = new LinkedList<>(driver.findElements(By.xpath("//tbody//tr//td")));
		int columns = column.size();
		int target = 4; //print all 4th column
		for (int i = 1; i <=rows; i++) {
			for (int j = 1; j <=columns; j++) {
				if (j == target) {
					System.out.println(driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[" + j + "]")).getText());
				}
			}
		}
		
		driver.quit();
		
		
	}
}
