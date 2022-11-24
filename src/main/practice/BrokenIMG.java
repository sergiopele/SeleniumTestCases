package main.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;
import java.util.List;

public class BrokenIMG {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/broken_images");
		List<WebElement>images = new LinkedList<>(driver.findElements(By.tagName("img")));
		int brokenImgCount=0;
		for(WebElement w:images){
			if(w.getAttribute("naturalWidth").equals("0")) brokenImgCount++;System.out.println(w.getLocation());
		}
		System.out.println("Number of broken img: "+brokenImgCount);
		driver.quit();
	}
}
