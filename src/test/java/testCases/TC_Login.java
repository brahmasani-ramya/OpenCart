package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseTestClass;

public class TC_Login extends BaseTestClass{
	
	@Test(groups= {"regression","master"})
	public void accountLogin() {
		logger.info("Login Started");
		try {
		HomePage homePage=new HomePage(cd);
		homePage.clickMyAccount();
		homePage.clickLogin();
		
		LoginPage loginPage=new LoginPage(cd);
		loginPage.setEmail(properties.getProperty("email"));
		loginPage.setpassword(properties.getProperty("password"));
		loginPage.clicklogin();
		
		MyAccount myaccount=new MyAccount(cd);
		Assert.assertTrue(myaccount.myAccountMessage());
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("Login Finished");
		
		
		
	}

}
