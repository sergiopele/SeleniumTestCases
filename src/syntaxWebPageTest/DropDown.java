package syntaxWebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropDown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://syntaxprojects.com/index.php");
		
		driver.findElement(By.xpath("//span[contains(@class,'two')]")).click();
		driver.findElement(By.xpath("//a[@class='list-group-item'][4]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		
		//I want to choose Friday in the list
		
		Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='select-demo']")));
		selectDay.selectByVisibleText("Friday");
		
		WebElement displayResult = driver.findElement(By.xpath("//p[@class='selected-value']"));
		System.out.println(displayResult.getText());
		
		Thread.sleep(2000);
		
		WebElement multiSelElement = driver.findElement(By.xpath("//select[@id='multi-select']"));
		Select multipleSelect = new Select(multiSelElement);
		String[] optionInBox = {"California", "Florida", "New Jersey", "New York", "Ohio", "Texas", "Pennsylvania", "Washington"};
		
		//Firstly I want chose all elements in dropBox
		
		for (String i : optionInBox) {
			multipleSelect.selectByVisibleText(i);
		}
		Thread.sleep(2000);
		
		//After I want unSelect all elements
		
		for (String j : optionInBox) {
			multipleSelect.deselectByVisibleText(j);
		}
		
		//Press button "First Selected"
		
		WebElement firstSelected = driver.findElement(By.xpath("//button[text()='First Selected']"));
		firstSelected.click();
		
		//visible text of result below is:
		
		WebElement visibleResult = driver.findElement(By.xpath("//p[@class='getall-selected']"));
		System.out.println(visibleResult.getText());
		Thread.sleep(2000);
		
		//I want click on "Get All Selected" button
		
		WebElement GetAllSelected = driver.findElement(By.xpath("//button[text()='Get All Selected']"));
		GetAllSelected.click();
		
		Thread.sleep(2000);
		
		driver.quit();
	}
}
