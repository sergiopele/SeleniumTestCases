package main.java.examples;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Screenshot {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		Date currentDate = new Date();
		String formatDate = currentDate.toString().replace(" ","-").replace(":","-");
		
		TakesScreenshot scrShot =((TakesScreenshot) driver);
		
		driver.get("https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html");
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile,new File(".//screenshot//"+formatDate+" .png"));
		
		
		
	}
}
