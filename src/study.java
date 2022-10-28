import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class study {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.adidas.ca/en/forum-low-shoes/FY7756.html?pr=still_interested&slot=3&rec=mt");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/ol/li[2]/a/span")).click();
	}
}
