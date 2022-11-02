package syntaxWebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPopUpModal {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sergiopele/Documents/extra_library_for_intellij/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://syntaxprojects.com/index.php");
		driver.findElement(By.xpath("//a[text()=' Start Practising ']")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//a[text()='Window Popup Modal'])[2]")).click();
		
		WebElement instagram = driver.findElement(By.xpath("//a[text()=' Follow On Instagram ']"));
		instagram.click();
		
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		///Very important!!!!
		Set<String> windowControl = driver.getWindowHandles();   //'Set' (it's like array but better) we use for avoiding duplication of windows (otherwise we can't identify window to handle in further
		System.out.println("Here is 'attribute' of two windows " + windowControl);
		Iterator<String> iterator = windowControl.iterator();    //'Iterator' we use to switch between windows (>[w1]< [w2]) switching occur by using command "next"
		
		String parentWindow = iterator.next();            //create instance var to store route to certain chamber in "set list" (easier way to switch window)
		String childWindow = iterator.next();
		
		driver.switchTo().window(childWindow);            // here I switched to new opened window
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//button[@class='_acan _acap _acat'])[2]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Now I'm here " + driver.getCurrentUrl());
		Thread.sleep(2000);
		
		driver.close();                                //don't forget to close child window!!
		
		driver.switchTo().window(parentWindow);		   //switch back to parent window
		WebElement FacebookButton = driver.findElement(By.xpath("//a[text()=' Like us On Facebook ']"));
		FacebookButton.click();
		
		//Here I create new set of windows,coz don't know how to add new String to existent library
		
		Set<String> newWindowsFacebook = driver.getWindowHandles();
		Iterator<String> iterator1 = newWindowsFacebook.iterator();
		String newParentWindow = iterator1.next();
		String facebookWindow = iterator1.next();
		
		driver.switchTo().window(facebookWindow);        //switch to Facebook window
		System.out.println("Here is new windows (Facebook & parentWindow) " + windowControl);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("Now am here " + driver.getCurrentUrl());
		Thread.sleep(2000);
		
		WebElement logInFace = driver.findElement(By.xpath("(//a[contains(@aria-label,'Accessible')])[1]"));
		logInFace.click();
		Thread.sleep(1000);
		
		driver.close();
		
		driver.switchTo().window(newParentWindow);
		
		WebElement instFaceButton = driver.findElement(By.xpath("//a[@title='Follow @syntaxtech']"));
		instFaceButton.click();
		
		//Multiple windows opened
		
		Set<String> windowsMulti = driver.getWindowHandles();
		Iterator<String> iterator3 = windowsMulti.iterator();
		String newNewParentWindow = iterator3.next();
		String newFacebookWindow = iterator3.next();
		String newInstWindow = iterator3.next();
		
		System.out.println("Multi window button opened 2 windows " + windowsMulti);
		
		driver.switchTo().window(newFacebookWindow);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Now am on 1 of 2 opened windows " + driver.getCurrentUrl());
		Thread.sleep(2000);
		
		logInFace = driver.findElement(By.xpath("(//a[contains(@aria-label,'Accessible')])[1]"));
		logInFace.click();
		Thread.sleep(1000);
		
		driver.close();
		driver.switchTo().window(newInstWindow);
		
		driver.manage().window().maximize();
		System.out.println("Now am on 2 of 2 windows");
		driver.findElement(By.xpath("(//button[@class='_acan _acap _acat'])[2]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Now I'm here " + driver.getCurrentUrl());
		Thread.sleep(2000);
		
		driver.close();
		
		driver.switchTo().window(newNewParentWindow);
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}
}

