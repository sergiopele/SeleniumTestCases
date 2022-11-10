package main.java.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class readFileProperties {
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		
		//to get property use Input
		FileInputStream inputStream = new FileInputStream("/Users/sergiopele/IdeaProjects/testCase/src/main/java/fileToRead/Test.property");
		properties.load(inputStream);
		System.out.println(properties.get("browser"));
		System.out.println(properties.get("url"));
		//to set property use Output
		FileOutputStream outputStream = new FileOutputStream("/Users/sergiopele/IdeaProjects/testCase/src/main/java/fileToRead/Test.property");
		//this text appears in our text doc
		properties.setProperty("testData","Passed");
		//with this comment
		properties.store(outputStream,"my comments");
	}
}
