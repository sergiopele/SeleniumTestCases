import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonBuyingAutomation {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("performance_glitch_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@id='item_3_img_link']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Smith");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("K0W34P");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		Thread.sleep((2000));
		
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		
		Thread.sleep((2000));
		
		driver.quit();
		
	}
}
