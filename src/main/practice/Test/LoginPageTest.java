package main.practice.Test;

import main.practice.Pages.LoginPage;
import main.practice.Utils.Exceptions.NoSuchBrowserException;
import main.practice.Utils.UniversalMethods;


public class LoginPageTest extends LoginPage {
	public static void main(String[] args) {
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
		
		universalMethods.closeBrowser();
	}
}
