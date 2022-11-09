package main.java.syntaxWebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BootstrapAlerts {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		BootstrapAlerts bootstrapAlerts = new BootstrapAlerts();
		driver.get("https://syntaxprojects.com/bootstrap-alert-messages-demo.php");
		
		//String array of button cascade was created to automatise clicking & checking does certain button displayed required color notification
		
		String[] buttons = {"autoclosable-btn-success", "normal-btn-success", "autoclosable-btn-warning", "normal-btn-warning",
				"autoclosable-btn-danger", "normal-btn-danger", "autoclosable-btn-info", "normal-btn-info"};
		
		String[] messageBox = {"//div[contains(text(),'autocloseable success')]", "//div[contains(@class,'alert alert-success alert-normal-success')]",
				"//div[contains(text(),'autocloseable warning')]", "//div[contains(@class,'alert alert-warning alert-normal-warning')]",
				"//div[contains(text(),'autocloseable danger message')]", "//div[contains(@class,'alert alert-danger alert-normal-danger')]", "//div[contains(text(),'info message')]",
				"//div[contains(@class,'alert alert-info alert-normal-info')]"};
		
		int count = 0;
		
		for (String button : buttons) {
			bootstrapAlerts.timeWait(driver, 1);
			
			WebElement a = driver.findElement(By.id(button));
			a.click();
			
			System.out.println(driver.findElement(By.xpath(messageBox[count])).getText());
			count++;
		}
		driver.findElement(By.linkText("Alerts & Modals")).click();
		
		bootstrapAlerts.timeWait(driver, 3);
		driver.findElement(By.xpath("//a[@href='bootstrap-modal-demo.php']")).click();
		Thread.sleep(1000);
		
		bootstrapAlerts.timeWait(driver, 3);
		driver.findElement(By.xpath("//a[@href='#myModal0']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Save changes")).click();
		bootstrapAlerts.timeWait(driver, 2);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@data-toggle='modal' and @href='#myModal']")).click();
		bootstrapAlerts.timeWait(driver, 1);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@data-toggle='modal' and @href='#myModal2']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[6]/a[2]")).click();
		bootstrapAlerts.timeWait(driver, 2);
		Thread.sleep(1000);
		
		driver.quit();
		
		
	}
	
	
	void timeWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
