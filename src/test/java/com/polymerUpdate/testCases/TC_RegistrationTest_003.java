package com.polymerUpdate.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.polymerUpdate.pageObjects.RegistrationPage;

public class TC_RegistrationTest_003 extends BaseClass{
	
	@Test
	public void RegistrationTest() throws InterruptedException, IOException {
		
		 
		
		RegistrationPage addcust = new RegistrationPage(driver);
		
		addcust.ClickRegisterbtn();
		logger.info("Click on the register button successfuly....");
		
		logger.info("provideing the valid details...");

		addcust.selectSalutation();
		logger.info("salutuation..");
		
		addcust.setFirstName("ABC");
		logger.info("firshname..");
		
		addcust.setLastName("xyz");
		logger.info("lname");
		
		String email = randomstring()+"@gmail.com";
		addcust.setEmail(email);
		logger.info("email..");
		
		addcust.checkAvaliable();
		logger.info("available");
		
		addcust.setCompanyName("absc");
		logger.info("Company name..");
		
		addcust.setCompanyAddress("mumbai");
		logger.info("Company address...");
		
		addcust.setCity("kalyan");
		logger.info("city");
		
		addcust.setCountry();
		logger.info("country");
		
		
		addcust.setState("maharashtra");
		logger.info("state");
		
		String num = randomNum();
		addcust.setMobileNumber(num);
		logger.info("mobile number...");
		
		addcust.setPhoneNumber(num);
		logger.info("phone number");
		
		addcust.tersmandcondition();
		logger.info("terms and condition..");
		
		addcust.clickSubmit();
		
		Thread.sleep(2000);
		
		logger.info("Validation started....");
		boolean res=driver.getPageSource().contains(" test");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed...");
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver, "RegisterNewCustomer");
			Assert.assertTrue(false);
			
		}
		
		
	}

}
