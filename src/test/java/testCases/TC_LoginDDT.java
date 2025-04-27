package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseTestClass;
import utilities.DataProviders;

public class TC_LoginDDT extends BaseTestClass{
	@Test(dataProvider="loginData",dataProviderClass=DataProviders.class,groups= {"DataDriven"})//getting data provider from different class
	public void verify_login(String email,String password, String expectedResult) {
		
		logger.info("Started login data");
		HomePage homepage=new HomePage(cd);
		homepage.clickMyAccount();
		homepage.clickLogin();
		
		LoginPage loginpage=new LoginPage(cd);
		loginpage.setEmail(email);
		loginpage.setpassword(password);
		loginpage.clicklogin();
		
		MyAccount myaccount=new MyAccount(cd);
		boolean targetPage=myaccount.myAccountMessage();
		
		/*Data is valid - login success-test pass- logout
		 * 				-login fail-test fail
		 Data is invalid - login success-test fail-logout
		 				 - login fail-test pass
		 
		 */
		
		if(expectedResult.equalsIgnoreCase("Valid")) {// data valid
			if(targetPage==true) // login successfull
			{ 
				myaccount.logout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.fail();
			}
			
		}
		if (expectedResult.equalsIgnoreCase("Invalid")){
			if(targetPage=true) 
			{
				myaccount.logout();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
		logger.info("Finished login data");
		
		
		
		
		
	}

}
