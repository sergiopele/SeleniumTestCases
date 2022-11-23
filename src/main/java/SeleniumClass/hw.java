package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class hw {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement login = driver.findElement(By.id("txtUsername"));
		login.sendKeys(configSetup("userName"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys(configSetup("password"));
		WebElement logIn = driver.findElement(By.id("btnLogin"));
		logIn.click();
		WebElement recrutButton = driver.findElement(By.xpath("//b[text()='Recruitment']//parent::a"));
		recrutButton.click();
		WebElement calendarBox = driver.findElement(By.id("candidateSearch_fromDate"));
		calendarBox.click();
		
		Select month = new Select(driver.findElement(By.className("ui-datepicker-month")));
		month.selectByVisibleText(configSetup("month"));
		Select year = new Select(driver.findElement(By.className("ui-datepicker-year")));
		year.selectByVisibleText(configSetup("year"));
		
		List<WebElement> day = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//child::tbody//tr//td"));
		
		for (WebElement days : day) {
			if (days.getText().equalsIgnoreCase(configSetup("day"))) {
				days.click();
			}
		}
		
		driver.quit();
		
		
	}
	
	public static String configSetup(String target) {
		String path = "src/main/java/fileToRead/Test.property";
		Properties properties = null;
		FileInputStream fileInputStream = null;
		String outPut = null;
		
		try {
			properties = new Properties();
			fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
			outPut = properties.get(target).toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return outPut;
		
	}
}
