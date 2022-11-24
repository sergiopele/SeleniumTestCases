package Test;

import Pages.loginPageWithPageFactory;
import Util.CommonMethods;

public class LoginPageTestWithFactoryElement extends loginPageWithPageFactory {
	public static void main(String[] args) {
		CommonMethods commonMethods = new CommonMethods();
		commonMethods.setBrowser("edge");
		commonMethods.openWithSpecUrl("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		loginPageWithPageFactory loginPageWithPageFactory = new LoginPageTestWithFactoryElement();
		loginPageWithPageFactory.userNameField.sendKeys("Admin");
		loginPageWithPageFactory.passwordField.sendKeys("Hum@nhrm123");
		loginPageWithPageFactory.loginButton.click();
		commonMethods.closeBrowser();
	}
	
}
