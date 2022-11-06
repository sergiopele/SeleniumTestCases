package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebTableHandle {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www2.asx.com.au/markets/trade-our-cash-market/equity-market-prices");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		
		//IF necessary change frame
		//Step 1 - get numbers of rows
		//Step 2 - get the number of columns
		//Step 3 - iterate columns and rows and get text and print it
		
		//*[@id="home_top_twenty"]/div/div[1]/div/div[1]/table/tr
		//*[@id="home_top_twenty"]/div/div[1]/div/div[1]/table/tr[1]/th
		
		List<WebElement> rowElements = driver.findElements(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr"));
		int rowSize = rowElements.size();
		System.out.println(rowSize);
		
		List<WebElement> columnElements = driver.findElements(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr[1]/th"));
		int columnSize = columnElements.size();
		System.out.println(columnSize);
		
		for (int i = 2; i <= rowSize; i++) {
			for (int j = 1; j <=columnSize; j++) {
				
				System.out.print(driver.findElement(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr[" + i + "]/td[" + j + "]"))
						.getText()+" ");
			}
			System.out.println();
		}
		driver.quit();
	}
}
