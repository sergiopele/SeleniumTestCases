import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedirectionAdminToUser {
	/*
	Business Rule: It has to redirect from Admin to the User interface, before admin login, and after admin login.

Test Steps:
1. Launch Browser
2. Navigate to the admin interface of the application (http://gcreddy.com/project/admin/login.php)
3. Click the “Online Catalog” link
4. Capture the current URL
5. Back to the previous page
6. Enter valid Username
7.Enter valid Password
8. Click the Login button
9. Capture the current URL
10. Click the “Online Catalog” link
11. Capture the current URL
12. Close Browser window

Verification Points:
1. Verify page redirecting functionality from admin to user interface before login
2. Verify page redirecting functionality from admin to user interface after login

Input / test data:
Username:
Password:

Expected:
1. http://gcreddy.com/project/
2. http://gcreddy.com/project/
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://gcreddy.com/project/admin/login.php");
		
		driver.findElement(By.xpath("//a[@class='headerLink']")).click();
		Thread.sleep(2000);
		
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		System.out.println(url);
		
		if (url.equals("http://gcreddy.com/project/")) {
			System.out.println("Before login - page redirects from admin to user interface before login --- PASSED");
		} else {
			System.out.println("Before login - page didn't redirect from admin to user interface before login --- FAILED");
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("gcreddy");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Temp@2020");
		
		driver.findElement(By.xpath("//button[@id='tdb1']")).click();
		Thread.sleep(2000);
		String url1 = driver.getCurrentUrl();
		
		if (url1.equals("http://gcreddy.com/project/admin/login.php")) {
			driver.findElement(By.xpath("//a[@class='headerLink']")).click();
		}
		
		
		String url2 = driver.getCurrentUrl();
		System.out.println(url2);
		boolean result = url2.equals("http://gcreddy.com/project/");
		if (result) {
			System.out.println("After Login – Page is redirecting from admin to user interface – Passed");
		} else {
			System.out.println("After Login – Page is Not redirecting from admin to user interface – Failed");
		}
		
		driver.quit();
		
		
	}
}
