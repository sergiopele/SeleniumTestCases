package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class calendar1 {
	public static void main(String[] args) {
		//        set the path to the driver to link it with our class    on mac u dont need .exe on windows u need .exe
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        maximize
		driver.manage().window().maximize();
		//  go to the website
		driver.get("https://www.delta.com/%22");
		WebElement frameLanguage=driver.findElement(By.xpath("//iframe[starts-with(@sandbox,'allow-scripts')]"));
		driver.switchTo().frame(frameLanguage);
		WebElement eng = driver.findElement(By.xpath("(//button[starts-with(@class,'btn-keep btn btn-')])[1]"));
		eng.click();
		driver.switchTo().defaultContent();

//       click on the calander
				WebElement calendar =driver.findElement(By.xpath("//span[text()='Depart']"));
		calendar.click();


//         get the month and check if it is the desried month
		
		WebElement month = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']"));
		
		boolean isFound=false;
		while(!isFound){
			String monthName = month.getText();
			
			if(monthName.equalsIgnoreCase("March")){
//               get all the dates from the table
				List<WebElement> dates = driver.findElements(By.xpath("(//table[@class='dl-datepicker-calendar'])[1]/tbody/tr/td"));
//               traverse through the list to find your desried date
				for(WebElement date:dates){
					String currentDate = date.getText();
					if(currentDate.equalsIgnoreCase("15")){
						date.click();
						break;
					}
				}
				System.out.println("i have found the desried month :" +monthName);
				isFound=true;
			}
			else{
				WebElement nxtBtn = driver.findElement(By.xpath("//span[text()='Next']"));
				nxtBtn.click();
			}
			
			
		}
		
		
		
	}
}