import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
Test Steps:
1. Launch Browser
2. Launch Customer Registration Page in gcrShop application User Interface (https://gcreddy.com/project/create_account.php)
3. Enter all mandatory fields
4. Click the “Continue” Button

Verification Point:
Capture the Conformation message and compare it with the expected message

Expected result:
Your Account Has Been Created!

 */


public class CustomerRegistration {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://gcreddy.com/project/create_account.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("gender")).click();
		driver.findElement(By.name("firstname")).sendKeys("Ronald");
		
		driver.findElement(By.name("lastname")).sendKeys("Smith");
		driver.findElement(By.id("dob")).sendKeys("10/10/2000");
		
		driver.findElement(By.name("email_address")).sendKeys("qwert" + Math.random() + "gmail.com");
		driver.findElement(By.name("street_address")).sendKeys("Waterloo Ste");
		
		driver.findElement(By.name("postcode")).sendKeys("K0023W");
		driver.findElement(By.name("city")).sendKeys("Toronto");
		
		driver.findElement(By.name("state")).sendKeys("ON");
		Select countrySelect = new Select(driver.findElement(By.name("country")));
		countrySelect.selectByVisibleText("Canada");
		
		driver.findElement(By.name("telephone")).sendKeys("12345678");
		
		String password = "0987654331";
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("confirmation")).sendKeys(password);
		
		driver.findElement(By.id("tdb4")).click();
		String comfirmation = driver.findElement(By.tagName("h1")).getText();
		
		if (comfirmation.equals("Your Account Has Been Created!")) {
			System.out.println("Test --- PASSED");
		} else {
			System.out.println("Test --- FAILED");
		}
		driver.close();
		
	}
}
