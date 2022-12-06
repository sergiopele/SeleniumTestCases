package main.practice.Herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;
import java.util.List;

public class AddRemoveElements {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		WebElement addFile = driver.findElement(By.xpath("//button[text()='Add Element']"));
		//how many elements you want add  5
		for(int i=0;i<5;i++){
			addFile.click();
		}
		List<WebElement>deleteButton = new LinkedList<>(driver.findElements(By.xpath("//button[@class='added-manually']")));
		//what elements u want delete then 1th and 4th
		for(int i=0;i<deleteButton.size();i++){
			if(i==0||i==3){
				deleteButton.get(i).click();
			}
		}
		driver.quit();
		
	}
}
