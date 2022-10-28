import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCase4Adidas {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		TestCase4Adidas sleep = new TestCase4Adidas();
		
		driver.get("https://www.adidas.ca/en");
		driver.manage().deleteAllCookies();
		
		sleep.timeOuts(2, driver);
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='searchinput___19uW0']"));
		searchBox.sendKeys("Samba");
		searchBox.sendKeys(Keys.ENTER);
		
		sleep.timeOuts(2, driver);
		
		driver.findElement(By.xpath("//div[contains(@data-grid-id,'HQ7034')]")).click();
		sleep.timeOuts(2, driver);
		
		WebElement popUpWindow = driver.findElement(By.xpath("//button[@aria-label='Close']"));
		popUpWindow.click();
		
		sleep.timeOuts(3, driver);
		
		WebElement chooseSize = driver.findElement(By.xpath("//button[@class='gl-label size___2Jnft']"));
		chooseSize.click();
		
		WebElement addToBag = driver.findElement(By.xpath("//button[@class='gl-cta gl-cta--primary gl-cta--full-width']"));
		addToBag.click();
		
		sleep.timeOuts(2, driver);
		driver.findElement(By.xpath("//button[@class='gl-modal__close']")).click();
		
		
	}
	
	void timeOuts(int time, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
