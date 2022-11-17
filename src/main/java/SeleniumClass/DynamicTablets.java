package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicTablets {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
		
		WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
		userName.sendKeys("Tester");
		
		WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
		password.sendKeys("test");
		
		WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
		loginButton.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> secondColum = driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[3]"));
		List<WebElement>checkBoxes=driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[1]"));
		
		for (int i = 0; i < secondColum.size(); i++) {
			String text =secondColum.get(i).getText();
			if (text.equalsIgnoreCase("ScreenSaver")) {
				System.out.println(i+1);
				checkBoxes.get(i).click();
			}
			
		}
		driver.quit();
	}
}
