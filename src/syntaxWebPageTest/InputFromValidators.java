package syntaxWebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class InputFromValidators {
	public static void main(String[] args) {
		//@Before Test
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://syntaxprojects.com/input-form-demo.php");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		
		//@Test Case
		
		//user registration form
		
		//Fill up firstName field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("first_name")));
		
		WebElement firstNameField = driver.findElement(By.name("first_name"));
		firstNameField.sendKeys("Josh");
		
		//fill up lastName field
		WebElement lastName = driver.findElement(By.name("last_name"));
		lastName.sendKeys("Smith");
		
		//Fill up email address
		WebElement eMail = driver.findElement(By.name("email"));
		eMail.sendKeys("joshsmith@gmail.com");
		
		//fill up phone number field
		WebElement phoneNum = driver.findElement(By.name("phone"));
		phoneNum.sendKeys("765 432 132");
		
		//fill up address field
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("StreetWood Av. 123");
		
		//fill up cite field
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Montreal");
		
		//field state from dropDown selection (choose 'Washington')
		WebElement state = driver.findElement(By.name("state"));
		Select stateSelect = new Select(state);
		stateSelect.selectByVisibleText("Washington");
		
		//fill up zipCode field
		WebElement zipCode = driver.findElement(By.name("zip"));
		zipCode.sendKeys("K345P34");
		
		//fill up website domain field
		WebElement websiteField = driver.findElement(By.name("website"));
		websiteField.sendKeys("www.MyWeb.com");
		
		//radio button 'do u have hosting (yes, no)
		WebElement radioHaveHost = driver.findElement(By.xpath("//input[@value='no']"));
		radioHaveHost.click();
		System.out.println("Does radio 'NO' selected? " + radioHaveHost.isSelected());
		
		//How many radioButtons are present on the page
		ArrayList<WebElement> radioButtons = new ArrayList<>(driver.findElements(By.xpath("//input[@type='radio']")));
		System.out.println("On the page " + radioButtons.size() + " radio buttons");
		
		//fill up description of own web
		WebElement description = driver.findElement(By.name("comment"));
		description.sendKeys("I don't know what to write here");
		
		//click on send button
		
		WebElement sendButton = driver.findElement(By.xpath("//button[@type='submit']"));
		sendButton.submit();
		
		
		//@After test
		driver.quit();
		
		
	}
}
