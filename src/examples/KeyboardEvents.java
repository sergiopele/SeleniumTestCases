package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvents {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://extendsclass.com/text-compare.html#:~:text=This%20tool%20allows%20to%20compare,they%20will%20be%20automatically%20compared!");
		
		WebElement textSource = driver.findElement(By.xpath("//span[text()='and differences will be highlighted, ']"));
		
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.keyDown(textSource, Keys.COMMAND).sendKeys("a").sendKeys("c").build().perform();
		Thread.sleep(2000);
		WebElement destinationArea = driver.findElement(By.xpath("(//span[text()='they stay on your computer, '])[2]"));
		action.keyDown(destinationArea, Keys.COMMAND).sendKeys("a").sendKeys("v").build().perform();
	}
}
