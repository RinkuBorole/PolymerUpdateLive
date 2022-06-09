package com.polymerUpdate.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver Local_Driver;
	
	public LoginPage(WebDriver Real_Driver) {
		Local_Driver = Real_Driver;
		PageFactory.initElements(Real_Driver, this);
	}
	
	@FindBy(id="login-section")
	
	WebElement login;

	@FindBy(id="txtUserName")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(id="txtPassword")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id = "btnSubmit")
	
	WebElement btnSubmit;
	
	@FindBy(xpath="//a[@class='fa fa-times-circle fa-5']")
	
	WebElement popup;
	
	@FindBy(id = "logout-section")
	
	WebElement Logout;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickSubmit() {
		btnSubmit.click();
	}
	
	public void SqueezPage() {
		System.out.println("Clicking on Squeeze Page");
		popup.click();
	}
	
	public void ClickLogout() {
		System.out.println("Inside Logout");	
		Logout.click();
	}
	
	public void ClickLogin() {
		login.click();
	}
}
