package SeleniumClass;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class hw {
	public static void main(String[] args) throws InterruptedException {
		
		//@Before test
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//@Test Case
		
		//click on "Create New Account" button
		WebElement createNewAccButton = driver.findElement(By.linkText("Create New Account"));
		createNewAccButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//fill sign up fields
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("It's me");
		
		WebElement surName = driver.findElement(By.name("lastname"));
		surName.sendKeys("Here is my surname");
		
		WebElement phoneEmail= driver.findElement(By.name("reg_email__"));
		phoneEmail.sendKeys("123 456 789");
		
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		password.sendKeys("*********");
		
		//Select boxes
		WebElement birthDay = driver.findElement(By.name("birthday_day"));
		Select selectBirthday = new Select(birthDay);
		//input 12
		selectBirthday.selectByVisibleText("12");
		
		WebElement birthMoth = driver.findElement(By.name("birthday_month"));
		Select selectMoth = new Select(birthMoth);
		//input March
		selectMoth.selectByVisibleText("Mar");
		
		WebElement birthdayYear = driver.findElement(By.name("birthday_year"));
		Select selectBirthdayYear = new Select(birthdayYear);
		//input 1996
		selectBirthdayYear.selectByValue("1996");
		
		//radioButton
		WebElement gender = driver.findElement(By.xpath("//input[@value='2']"));
		gender.click();
		
		
		//@After test
		driver.quit();
		
		
	}
}
