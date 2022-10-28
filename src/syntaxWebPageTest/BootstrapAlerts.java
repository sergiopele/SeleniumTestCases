package syntaxWebPageTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BootstrapAlerts {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		BootstrapAlerts bootstrapAlerts = new BootstrapAlerts();
		driver.get("https://syntaxprojects.com/bootstrap-alert-messages-demo.php");
		
		//String array of button cascade was created to automatise clicking & checking does certain button displayed required color notification
		
		String[] buttons = {"autoclosable-btn-success", "normal-btn-success", "autoclosable-btn-warning", "normal-btn-warning",
				"autoclosable-btn-danger", "normal-btn-danger", "autoclosable-btn-info", "normal-btn-info"};
		
		
		for (String button : buttons) {
			bootstrapAlerts.timeWait(driver, 1);
			
			WebElement a = driver.findElement(By.id(button));
			a.click();
			
		}
		driver.findElement(By.linkText("Alerts & Modals")).click();
		
		bootstrapAlerts.timeWait(driver, 3);
		driver.findElement(By.xpath("//a[@href='bootstrap-modal-demo.php']")).click();
		
		bootstrapAlerts.timeWait(driver, 3);
		driver.findElement(By.xpath("//a[@href='#myModal0']")).click();
		
		driver.findElement(By.linkText("Save changes")).click();
		bootstrapAlerts.timeWait(driver,2);
		
		driver.findElement(By.xpath("//a[@data-toggle='modal' and @href='#myModal']")).click();
		bootstrapAlerts.timeWait(driver,1);
		
		driver.findElement(By.xpath("//a[@data-toggle='modal' and @href='#myModal2']")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[6]/a[2]")).click();
		bootstrapAlerts.timeWait(driver,2);
		
		
		
	}
	
	
	void timeWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
