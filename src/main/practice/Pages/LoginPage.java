package main.practice.Pages;

import main.practice.Utils.Exceptions.NoSuchBrowserException;
import main.practice.Utils.UniversalMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends UniversalMethods {
	@FindBy(name = "txtUsername")
	public WebElement userNameField;
	@FindBy(name = "txtPassword")
	public WebElement userPassword;
	@FindBy(name = "Submit")
	public WebElement submitButton;
	@FindBy(id = "spanMessage")
	public WebElement spanMessage;
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	public String byPassLoginPage(){
		UniversalMethods universalMethods = new UniversalMethods();
		
		try {
			universalMethods.setBrowser(universalMethods.config("browser"));
		} catch (NoSuchBrowserException e) {
			throw new RuntimeException(e);
		}
		
		universalMethods.goToUrl(universalMethods.config("url"));
		LoginPage loginPage = new LoginPage();
		loginPage.userNameField.sendKeys(universalMethods.config("userName"));
		loginPage.userPassword.sendKeys(universalMethods.config("password"));
		loginPage.submitButton.click();
		
		if(!(universalMethods.getCurrentUrl().equalsIgnoreCase(universalMethods.config("url")))){
			System.out.println("Test passed");
		}else{
			System.out.println("Test failed");
		}
		return driver.getCurrentUrl();
	}
	
}
