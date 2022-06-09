package com.polymerUpdate.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.polymerUpdate.pageObjects.LoginPage;
import com.polymerUpdate.utilities.XLUtils;


public class TC_LoginDDT_001 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	
	public void loginDDt(String user, String pwd) throws InterruptedException {
		
		System.out.println("Username : " + user + " Password : " + pwd);
		
		LoginPage lp =new LoginPage(driver);
		//lp.SqueezPage();
		lp.ClickLogin();
		lp.setUserName(user);
		logger.info("Username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.ClickSubmit();
		
		Thread.sleep(2000);
		
		boolean isLoginFailed = isAlertPresent();
		boolean isValidationFailed = isValidationFailure();
		
		if(isLoginFailed || isValidationFailed) {
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			System.out.println("Login Success ... Going to home page");

			
			//lp.SqueezPage();
			lp.ClickLogout();
			//lp.SqueezPage();
			lp.ClickLogin(); 
		}
		
		
	}
	
	
	private boolean isValidationFailure()
	{
		boolean isFailed = false;

		try
		{
			WebElement alertUserName = driver.findElement(By.xpath("//span[contains(@id,'rgvUserName')]"));
			WebElement alertPassword = driver.findElement(By.xpath("//span[contains(@id,'rfvPassword')]"));
			
			System.out.println("Alret Username : " + alertUserName);
			System.out.println("Alret Password : " + alertPassword);

			if (alertUserName != null || alertPassword != null)
			{
				isFailed = true; 
			}
		}
		catch (Exception ex)
		{
			//Do Nothing	
		}
		
		return isFailed;
	}
	
	public boolean isAlertPresent() {
		boolean isLogin = false;

		try
		{
			WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-default']"));

			if (alert != null)
			{
				isLogin = true; 
			}
		}
		catch (Exception ex)
		{
			//Do Nothing	
		}
		
		return isLogin;
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/polymerUpdate/testData/LoginData.xlsx";
		int rownum= XLUtils.getRowCount(path, "Sheet1");
		
		int cocount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][cocount];
		
		for(int i=1;i<=rownum; i++)
		{
			for(int j=0; j<cocount; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return logindata;
	}

}
