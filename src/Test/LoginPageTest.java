package Test;

import Pages.loginPage;
import Util.CommonMethods;

public class LoginPageTest extends loginPage {
	
	public static void main(String[] args) {
		CommonMethods commonMethods=new CommonMethods();
		commonMethods.setBrowser("chrome");
		commonMethods.openWithSpecUrl("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		loginPage loginPage = new LoginPageTest();
		loginPage.userNameField.sendKeys("Admin");
		loginPage.passwordField.sendKeys("Hum@nhrm123");
		loginPage.loginButton.click();
		commonMethods.closeBrowser();
	}
}
