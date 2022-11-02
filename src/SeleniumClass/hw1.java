package SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class hw1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		
		WebElement loginBox = driver.findElement(By.id("txtUsername"));
		loginBox.sendKeys("Admin");
		
		WebElement passwordBox = driver.findElement(By.id("txtPassword"));
		passwordBox.sendKeys("Hum@nhrm123");
		
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		submitButton.click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement getVisualValueAdminWelcome = driver.findElement(By.xpath("//a[text()='Welcome Admin']"));
		
		System.out.println("is 'Welcome Admin' there on the top right corner "+getVisualValueAdminWelcome.isDisplayed());
		
		driver.quit();
	}
}
