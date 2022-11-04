package SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class checkBoxes {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://syntaxprojects.com/basic-checkbox-demo.php");
		List<WebElement> checkBox1 = driver.findElements(By.className("cb1-element"));
		
		for (WebElement boxes : checkBox1
		) {
			String list = boxes.getAttribute("value");
			if (list.equals("Option-3")) {
				boxes.click();
			}
		}
		Thread.sleep(2000);
		driver.quit();
		
		
	}
}
