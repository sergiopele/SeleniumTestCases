package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestionDropDown {
	public static void main(String[] args) {
		
		/*
		Buy ticket from YYZ Toronto-Pearson Int.  - to
		LON All airports, London, , United Kingdom
		(Econ0omy class)
		for 2 passengers (1 adult, 1 child), Date March 12, back after 2 week
		
		
		 */
		
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.get("https://www.aircanada.com/en-ca/flights-from-toronto-to-las-vegas?acid=EXT%3ASEM%3APOS-CAN-UB-Toronto-Las-Vegas-EN%3ALAS%20Flights%7CExact%3A%3A%3A&gclid=CjwKCAjwzY2bBhB6EiwAPpUpZjOCCIMn0lskK-7nKYpQuEfaZZ99m3Dd1Ugjvcjlb6SAJAvrW3FRxBoClscQAvD_BwE&gclsrc=aw.ds&redirecturl=true");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='From']")));
		
		//@Test case
		//Enter Toronto in "From" search box
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='Input origin']"));
		from.click();
		from.clear();
		from.sendKeys("Toronto");
		
		//go down in prompt box for 4 position
		for (int i = 0; i < 4; i++) {
			from.sendKeys(Keys.ARROW_DOWN);
		}
		from.sendKeys(Keys.ENTER);
		
		//Enter London in "To" search box
		WebElement to = driver.findElement(By.xpath("//input[contains(@placeholder,'destination')]"));
		to.clear();
		to.sendKeys("London");
		//choose LON All airports, London, , United Kingdom
		to.sendKeys(Keys.ENTER);
		
		//SELECT departure date
		WebElement depart = driver.findElement(By.xpath("//input[@id='flights-booking-id-3']"));
		depart.sendKeys(Keys.ENTER);
		WebElement nextMonthButton = driver.findElement(By.xpath("//button[contains(@aria-label,'Next month')]"));
		
		//scroll until March will be visible
		for (int i = 0; i < 3; i++) {
			nextMonthButton.click();
		}
		//chose date 12
		WebElement dateDepart = driver.findElement(By.xpath("//div[@data-att='day-2023-03-12']"));
		dateDepart.click();
		
		//chose 26 (2 week since 12)
		WebElement returnDate = driver.findElement(By.xpath("//div[@data-att='day-2023-03-26']"));
		returnDate.click();
		
		//select quantity of passengers
		//click on "Passenger" button
		WebElement passengersButton = driver.findElement(By.xpath("//button[contains(@aria-label,'Press Enter or Spacebar')]"));
		passengersButton.click();
		
		//By default there 1 adult already selected, add 1 child
		WebElement childOption = driver.findElement(By.xpath("(//button[@aria-label='Increase'])[3]"));
		childOption.click();
		
		//click on "Find" button
		WebElement findButton = driver.findElement(By.xpath("//button[@data-att='search']"));
		findButton.click();
		
		
		
		
		
		
	}
}
