package syntaxWebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://syntaxprojects.com/basic-checkbox-demo.php");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement checkBox = driver.findElement(By.id("isAgeSelected"));
		checkBox.click();
		
		
		WebElement isCheckBoxChecked = driver.findElement(By.id("txtAge"));
		String result = isCheckBoxChecked.getText();
		
		boolean isDisplayed = (!result.isEmpty());
		
		String s = (isDisplayed) ? "Check Box is checked (result is visible below) --> PASSED" : "Check Box is NOT checked (result is invisible below) --> FAILED";
		System.out.println(s);
		
		
		//-------------------------------------------------------------------------------------------------------------
		//Multiple check box DEMO
		
		WebElement unCheckBox1 = driver.findElement(By.xpath("//input[@value='Check All']"));
		unCheckBox1.click();
		
		Thread.sleep(2000);
		
		String[] element = {"//input[@value='Option-1']", "//input[@value='Option-2']", "//input[@value='Option-3']", "//input[@value='Option-4']"};
		for (String i : element) {
			driver.findElement(By.xpath(i)).click();
		}
		Thread.sleep(2000);
		
		WebElement unCheckBox2 = driver.findElement(By.xpath("//input[@value='Check All']"));
		unCheckBox2.click();
		
		//Dynamic CheckBox
		
		WebElement lastCheckBox = driver.findElement(By.xpath("//input[@onclick='myFunction()']"));
		lastCheckBox.click();
		Thread.sleep(5000);
		
		driver.quit();
		
		/*
			WebElement message = driver.findElement(By.xpath("//div[@id='div']//child::p"));
			Thread.sleep(5000);
			
			String s2 = (message.isEnabled())?"Message is displayed --> Passed":"Message is NOT displayed --> FAILED";
				driver.quit();
				System.out.println(s2);
		*/
	}
}
