package SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class hw {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.id("customer.firstName")).sendKeys("MyName");
		driver.findElement(By.id("customer.lastName")).sendKeys("MyLastName");
		
		driver.findElement(By.id("customer.address.street")).sendKeys("myAddress");
		
		driver.findElement(By.id("customer.address.city")).sendKeys("MyCity");
		driver.findElement(By.id("customer.address.state")).sendKeys("myStateAdress");
		
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("KI98N32");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
		
		driver.findElement(By.id("customer.ssn")).sendKeys("456_545_534");
		driver.findElement(By.id("customer.username")).sendKeys("erwerwe");
		
		String pass = "mYpASWORD";
		driver.findElement(By.id("customer.password")).sendKeys(pass);
		driver.findElement(By.id("repeatedPassword")).sendKeys(pass);
		
		driver.findElement(By.xpath("//input[@value='Register']")).submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("MyFirstname");
		
		driver.findElement(By.name("lastname")).sendKeys("MyLastName");
		driver.findElement(By.name("reg_email__")).sendKeys("adfsdf@1234.com");
		
		driver.findElement(By.id("password_step_input")).sendKeys("12313455");
		
		Select select = new Select(driver.findElement(By.name("birthday_day")));
		select.selectByVisibleText("21");
		
		Select select2 = new Select(driver.findElement(By.name("birthday_month")));
		select2.selectByVisibleText("Mar");
		
		Select select3 = new Select(driver.findElement(By.name("birthday_year")));
		select3.selectByVisibleText("1996");
		
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
