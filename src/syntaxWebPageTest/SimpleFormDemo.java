package syntaxWebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SimpleFormDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://syntaxprojects.com/basic-first-form-demo.php");
		
		WebElement textField = driver.findElement(By.tagName("input"));
		String myInput = "I was here";
		textField.sendKeys(myInput);
		
		WebElement buttonShowMassage = driver.findElement(By.tagName("button"));
		buttonShowMassage.click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement display = driver.findElement(By.id("display"));
		String result = display.getText();
		
		String s = (result.equals(myInput)) ? "Test --> PASSED" : "Test --> FAILED";
		System.out.println(s);
		
		
		//--------------------------------------------------------------------------------------------------------------
		//Two input fields on this page (numbers)
		
		WebElement textField2 = driver.findElement(By.xpath("//input[@placeholder='Enter value' and @id='sum1']"));
		String myInput2 = "2";
		textField2.sendKeys(myInput2);
		
		WebElement textField3 = driver.findElement(By.xpath("//input[@placeholder='Enter value' and @id='sum2']"));
		String myInput3 = "3";
		textField3.sendKeys(myInput3);
		
		WebElement getResultButton = driver.findElement(By.xpath("//button[@onclick='return total()']"));
		getResultButton.click();
		
		//convert String (inputs) to integer to check is displayed result correct
		
		int sum = Integer.parseInt(myInput2) + Integer.parseInt(myInput3);
		String sumCasted = String.valueOf(sum);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement display2 = driver.findElement(By.xpath("//span[@id='displayvalue']"));
		String result2 = display2.getText();
		
		String s1 = (result2.equals(sumCasted)) ? "Test2 --> PASSED" : "Test2 --> FAILED";
		System.out.println(s1);
		
		
	}
}
