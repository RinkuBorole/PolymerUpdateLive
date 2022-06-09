package com.polymerUpdate.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.polymerUpdate.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
	logger.info("URL is opened");
	
	LoginPage lp = new LoginPage(driver);
	lp.SqueezPage();
	lp.ClickLogin();
	lp.setUserName(UserName);
	logger.info("Entered Username");
	
	lp.setPassword(Password);
	logger.info("Entered password");
	
	
	lp.ClickSubmit();
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{ 
		Assert.assertTrue(true);
		logger.info("Test case is passed");
		
	}
	else
	{
		captureScreen(driver, "loginTest");
		Assert.assertTrue(false);
		logger.info("Test case is failled");
		
	}
		
	}

}
