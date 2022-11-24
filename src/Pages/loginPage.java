package Pages;

import Util.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPage extends CommonMethods {
	public WebElement userNameField = driver.findElement(By.name("txtUsername"));
	public WebElement passwordField = driver.findElement(By.id("txtPassword"));
	public WebElement loginButton = driver.findElement(By.id("btnLogin"));
}
