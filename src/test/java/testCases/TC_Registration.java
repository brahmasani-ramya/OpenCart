package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseTestClass;

public class TC_Registration extends BaseTestClass {
	
	
	@Test(groups= {"sanity","master"})
	public void accountRegistration() {
		logger.info("Started  Registration");
		
		try {
		HomePage homepage=new HomePage(cd);
		
		homepage.clickMyAccount();
		logger.info("clicked account ");
		homepage.clickRegister();
		logger.info("clicked Register");
		
		RegistrationPage registrationpage=new RegistrationPage(cd);
		logger.info("providing registration details");
		String password=randomString()+randomNumbers();
		registrationpage.txtFistname(randomString());
		registrationpage.txtLastName(randomString());
		registrationpage.txtEmail(randomString()+"@gmail.com");
		registrationpage.txtTelephone(randomNumbers());
		registrationpage.txtPassword(password);
		registrationpage.txtConfirmPassword(password);
		registrationpage.checkBox();
		registrationpage.continueButton();
		
		//validation
		logger.info("validating");
		if(registrationpage.successMessage().equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed");
			logger.debug("Debug Logs"); 
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(registrationpage.successMessage(),"Your Account Has Been Created!");
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("Finished Registration");
	}
	

}
