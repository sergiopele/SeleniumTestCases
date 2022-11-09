package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropDown {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://syntaxprojects.com/basic-select-dropdown-demo.php");
		
		
		WebElement dropDown = driver.findElement(By.className("form-control"));
		Select select = new Select(dropDown);
		
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			if (text.equals("Friday")) {
				select.selectByIndex(i);
			}
		}
		
		WebElement multiSelectDrop = driver.findElement(By.id("multi-select"));
		Select multi = new Select(multiSelectDrop);
		
		List<WebElement> multDrop = multi.getOptions();
		for (int i = 0; i < multDrop.size(); i++) {
			multi.selectByIndex(i);
		}
		multi.deselectAll();
		
		boolean isMultiselect = multi.isMultiple();
		System.out.println(isMultiselect);
		
	}
}
