package main.practice.Utils;

import main.practice.Utils.Exceptions.NoSuchBrowserException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class UniversalMethods {
	public static WebDriver driver;
	
	public void setBrowser(String browser) throws NoSuchBrowserException {
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/msedgedriver");
			driver = new EdgeDriver();
		} else {
			throw new NoSuchBrowserException("no such browser in directory");
		}
	}
	
	public void goToUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public String config(String target) {
		try {
			String path = "Config/config";
			Properties properties = new Properties();
			FileInputStream inputStream = new FileInputStream(path);
			properties.load(inputStream);
			
			return (properties.get(target).toString());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void explicitWait(int time, WebElement target){
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(target))));
		
	}
}

