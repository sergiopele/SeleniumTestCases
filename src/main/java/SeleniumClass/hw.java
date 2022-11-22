package main.java.SeleniumClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;


public class hw {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		
		WebElement login = driver.findElement(By.id("txtUsername"));
		login.sendKeys();
		
		
		
		driver.quit();
		
		
		
	}
	public static String configSetup(String target){
		String path="src/main/java/fileToRead/Test.property";
		Properties properties=null;
		FileInputStream fileInputStream=null;
		String outPut=null;
		
		try{
			properties = new Properties();
			fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
			outPut = properties.get(target).toString();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException ie){
			ie.printStackTrace();
		}finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return outPut;
		
	}
}
