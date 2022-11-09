package main.java.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSL_Certificate {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		//Global profile
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		//profile for Chrome driver
		ChromeOptions cOptioon =new ChromeOptions();
		cOptioon.merge(dc);
		WebDriver driver = new ChromeDriver(cOptioon);
		driver.get("https://expired.badssl.com/");
		
		
	}
}
