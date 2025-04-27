package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver cd;
	public BasePage(WebDriver cd)
	{
		this.cd=cd;
		PageFactory.initElements(cd, this);
		
	}
	

}
