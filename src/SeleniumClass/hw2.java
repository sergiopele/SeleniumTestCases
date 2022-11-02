package SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class hw2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		
		WebElement loginBox = driver.findElement(By.id("txtUsername"));
		loginBox.sendKeys("Admin");
		
		WebElement submitButton = driver.findElement(By.id("btnLogin"));
		submitButton.click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement catchPasswordIsEmpty = driver.findElement(By.xpath("//span[contains(text(),'Password cannot')]"));
		
		System.out.println("is 'Password cannot be empty' displayed? "+catchPasswordIsEmpty.isDisplayed());
		
	}
}
