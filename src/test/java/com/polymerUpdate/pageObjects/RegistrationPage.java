package com.polymerUpdate.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	WebDriver ldriver;
	
	public RegistrationPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.XPATH , using = "//a[contains(.,'Register')]")
	WebElement RegisterButton;
	
	@FindBy(id = "ddlSalutation")
	
	WebElement Salutation;
	
	@FindBy(how = How.ID , using = "txtFirstName" )
	@CacheLookup
	WebElement FirstName;
	
	@FindBy(how = How.ID , using = "txtLastName")
	@CacheLookup
	WebElement LastName;
	
	@FindBy(how = How.ID , using = "txtBusinessEmailAddress")
	@CacheLookup
	WebElement Email;
	
	@FindBy(how = How.ID , using = "availability")
	WebElement Availability;
	
	@FindBy(how = How.ID , using = "txtCompanyName")
	@CacheLookup
	WebElement CompanyName;
	
	@FindBy(how = How.ID , using = "txtCompanyAddress")
	@CacheLookup
	WebElement CompanyAddress;
	
	@FindBy(how = How.ID , using = "txtCity")
	@CacheLookup
	WebElement City;
	
	@FindBy(how = How.ID , using = "ContentPlaceHolder1_ddlCountry")
	@CacheLookup
	WebElement Country;
	
	@FindBy(how = How.ID , using = "txtState")
	@CacheLookup
	WebElement State;
	
	@FindBy(how = How.ID , using = "txtMobileNumber")
	@CacheLookup
	WebElement MobileNumbaer;
	
	@FindBy(how = How.ID, using = "txtBusinessPhoneNumber")
	@CacheLookup
	WebElement PhoneNumbar;
	
	@FindBy(id = "chkTermsConditions")
	@CacheLookup
	WebElement TermsCondiotion;
	
	@FindBy(how = How.ID , using = "btnSubmit")
	@CacheLookup
	WebElement Submit;

	
	public void ClickRegisterbtn() {
		RegisterButton.click();

	}
		
	public void selectSalutation() {
		Select salutations = new Select(Salutation);
		salutations.selectByIndex(2);
		
	}
	
	public void setFirstName(String cname) {
		FirstName.sendKeys(cname);
	}
	
	public void setLastName(String lname) {
		LastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void checkAvaliable() {
		Availability.isSelected();
	}
	
	public void setCompanyAddress(String companyadrs) {
		CompanyAddress.sendKeys(companyadrs);
	}
	
	public void setCompanyName(String companyname) {
		CompanyName.sendKeys(companyname);
	}
	
	public void setCity(String city) {
		City.sendKeys(city);
	}
	
	public void setCountry() {
		Select countrys = new Select(Country);
		countrys.selectByVisibleText("Barbados");
	}
	
	public void setState(String states) {
		State.sendKeys(states);
	}
	
	public void setMobileNumber(String number) {
		MobileNumbaer.sendKeys(String.valueOf(number));
	}
	
	public void setPhoneNumber(String pnumber) {
		PhoneNumbar.sendKeys(String.valueOf(pnumber));
	}
	
	public void tersmandcondition() {
		TermsCondiotion.click();
	}
	
	public void clickSubmit() {
		Submit.click();
	}
}
