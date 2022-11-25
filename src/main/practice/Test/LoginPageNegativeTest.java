package main.practice.Test;

import main.practice.Pages.LoginPage;
import main.practice.Utils.Exceptions.NoSuchBrowserException;
import main.practice.Utils.UniversalMethods;

public class LoginPageNegativeTest {
	public static void main(String[] args) {
		UniversalMethods universalMethods = new UniversalMethods();
		
		try {
			universalMethods.setBrowser(universalMethods.config("browser"));
		} catch (NoSuchBrowserException e) {
			throw new RuntimeException(e);
		}
		
		universalMethods.goToUrl(universalMethods.config("url"));
		LoginPage loginPage = new LoginPage();
		loginPage.userNameField.sendKeys(universalMethods.config("negativeUserName"));
		loginPage.userPassword.sendKeys(universalMethods.config("negativePassword"));
		loginPage.submitButton.click();
		
		if(loginPage.spanMessage.isDisplayed()) System.out.println("Test passed");
		
		universalMethods.closeBrowser();
	}
}
