package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver cd) {
		super(cd);
		
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myaccountmessage;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	
	public boolean myAccountMessage() {
		return myaccountmessage.isDisplayed();
	}
	public void logout() {
		logout.click();
	}

	
}
