package main.java.myPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestTaskAmazon {
	
	//@BeforeTest
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		
		//@Test
		
		//Click on the hamburger menu in the top left corner.
		WebElement hamburgerButton = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
		hamburgerButton.click();
		
		
		
		//Scroll own and then Click on the TV, Appliances and Electronics link under Shop by Department section.
		WebElement tvElectronics = driver.findElement(By.xpath("(//a[@class='hmenu-item'])[11]"));
		js.executeScript("arguments[0].scrollIntoView();", tvElectronics);
		
		tvElectronics.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='hmenu-item' and text()='Televisions']")));
		
		
		
		//Then click on Televisions under Tv, Audio & Cameras sub section.
		WebElement television = driver.findElement(By.xpath("//a[@class='hmenu-item' and text()='Televisions']"));
		television.click();
		
		
		
		//Scroll down and filter the results by Brand ‘Samsung’.
		WebElement byVisualElementScroller = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small'])[21]"));
		
		js.executeScript("arguments[0].scrollIntoView();", byVisualElementScroller);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'a-checkbox a-checkbox-fancy')])[77]")));
		
		WebElement selectBoxSamsung = driver.findElement(By.xpath("(//div[contains(@class,'a-checkbox a-checkbox-fancy')])[77]"));
		selectBoxSamsung.click();
		
		
		
		//Sort the Samsung results with price High to Low.
		WebElement priceSorting = driver.findElement(By.xpath("//select[@name='s']"));
		
		Select dropDown = new Select(priceSorting);
		dropDown.selectByIndex(2);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-index='2']")));
		
		
		
		//Click on the second highest priced item (whatever that maybe at the time of automating).
		WebElement secondItemTv = driver.findElement(By.xpath("//div[@data-index='2']"));
		secondItemTv.click();
		
		
		
		//Switch the Window
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		//Assert that “About this item” section is present and log this section text to console/report.
		try {
			boolean isPresentItemDescription = driver.findElement(By.xpath("//h1[text()=' About this item ']")).isDisplayed();
			if (isPresentItemDescription) {
				System.out.println("Section is present --- Passed");
				String itemDescription = driver.findElement(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']")).getText();
				System.out.println(itemDescription);
			}
		} catch (NoSuchElementException e1) {
			System.out.println("element does NOT exist");
		}
		
		
		
		//@AfterTest
		driver.close();
		driver.switchTo().window((tabs.get(0)));
		driver.quit();
		
		
	}
	
}

