package main.practice.Pages;

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
	
}
