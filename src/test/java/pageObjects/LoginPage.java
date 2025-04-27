package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//constructor
	public LoginPage(WebDriver cd) {
		super(cd);
		
	}
	//locators
	@FindBy(xpath="//input[@id='input-email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement inputPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	//Action methods
	
	public void setEmail(String email) {
		inputEmail.sendKeys(email);
	}
	public void setpassword(String password) {
		inputPassword.sendKeys(password);
	}
	public void clicklogin() {
		btnLogin.click();
	}
	
	
	
	
	
	

}
