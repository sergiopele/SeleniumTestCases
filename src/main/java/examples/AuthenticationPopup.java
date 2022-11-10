package main.java.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopup {
	public static String adminLog = "admin";        //-reading from XLS or CSV
	public static String passLog = "admin";            //reading from some external XLS or CSV
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//credential in this particular example - admin, pass - admin
		//original url:https://the-internet.herokuapp.com/basic_auth
		// we simply add https://admin:admin@the-internet.herokuapp.com/basic_auth
		driver.get("https://"+adminLog+":"+passLog+"@the-internet.herokuapp.com/basic_auth");
		
		
	}
}
