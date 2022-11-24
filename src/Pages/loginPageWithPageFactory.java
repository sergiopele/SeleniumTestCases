package Pages;

import Util.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageWithPageFactory extends CommonMethods {
	@FindBy(name = "txtUsername")
	public WebElement userNameField;
	
	@FindBy(id = "txtPassword")
	public WebElement passwordField;
	
	@FindBy(id = "btnLogin")
	public WebElement loginButton;
	
	public loginPageWithPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
}
