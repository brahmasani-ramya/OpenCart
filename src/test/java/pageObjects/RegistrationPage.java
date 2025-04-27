package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver cd) {
		super(cd);
		}
	//locators
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement successMessage;
	//Action Methods
	public void txtFistname(String firstname) {
		firstName.sendKeys(firstname);
	}
	public void txtLastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	public void txtEmail(String inputEmail) {
	email.sendKeys(inputEmail);
	}
	public void txtTelephone(String PhoneNumber) {
	telephone.sendKeys(PhoneNumber);
	}
	public void txtPassword(String inputPassword) {
		password.sendKeys(inputPassword);
	}
	public void txtConfirmPassword(String inputConfirmPassword) {
		confirmPassword.sendKeys(inputConfirmPassword);
	}
	public void checkBox() {
		checkbox.click();
	}
	public void continueButton() {
		continuebtn.click();
		
		}
	public String successMessage() {
		try {
		return successMessage.getText();
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	

}
