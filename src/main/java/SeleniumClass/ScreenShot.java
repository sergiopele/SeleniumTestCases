package main.java.SeleniumClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShot {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.syntaxtechs.com/");
		takescreenshot(driver);
		driver.quit();

	}
	public static void takescreenshot(WebDriver driver){
		Date currentDate = new Date();
		String formatDate = currentDate.toString().replace(" ","-").replace(":","-");
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile,new File(".//screenshot//"+formatDate+" .png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
