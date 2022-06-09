package com.polymerUpdate.testCases;

import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.polymerUpdate.pageObjects.RegistrationPage;

public class TC_RegistrationDDT_004 extends BaseClass {
	
	@Test
	public void RegistrationDDT() throws CsvValidationException, IOException, InterruptedException {
		
		RegistrationPage addcst = new RegistrationPage(driver);
		addcst.ClickRegisterbtn();
		logger.info("Click on the register button successfuly....");
		
		logger.info("provideing the valid details...");
		
		@SuppressWarnings("resource")
		CSVReader csv = new CSVReader(new FileReader("C:\\Users\\admin\\Desktop\\RegistrationData.csv"));
		String cell[];
		
		while ((cell = csv.readNext())!= null) {
			
			addcst.selectSalutation();
			logger.info("salutuation..");
			
			addcst.setFirstName(cell[0]);
			logger.info("firstname..");
			Thread.sleep(2000);

		
			addcst.setLastName(cell[1]);
			logger.info("lastname..");
			
			addcst.setEmail(cell[2]);
			logger.info("email..");

			addcst.setCompanyName(cell[3]);
			logger.info("compnyname..");

			addcst.setCompanyAddress(cell[4]);
			logger.info("address..");

			addcst.setCity(cell[5]);
			logger.info("city..");

			addcst.setCountry();
			logger.info("country..");
			Thread.sleep(2000);

			addcst.setState(cell[6]);
			logger.info("state..");

			addcst.setMobileNumber(cell[7]);
			logger.info("mobilenumber..");
			Thread.sleep(2000);

			addcst.setPhoneNumber(cell[8]);
			logger.info("phonenumber..");
			
			addcst.tersmandcondition();
			logger.info("terms and condition..");

			addcst.clickSubmit();
			
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

}

