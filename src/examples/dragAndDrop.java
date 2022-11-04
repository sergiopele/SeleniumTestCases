package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://jqueryui.com/droppable/");
		
		/*WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		WebElement draggableElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropZone = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(draggableElement,dropZone).perform();
		driver.switchTo().parentFrame();
		*/
		
		
		driver.get("https://jqueryui.com/resizable/");
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(frame1);
		WebElement resizable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		
		
		Actions actions1 = new Actions(driver);
		actions1.dragAndDropBy(resizable,200,150).perform();
		
	}
}
