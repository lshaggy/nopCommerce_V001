package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement Subbtn;
	
    @FindBy(linkText="Logout")
    @CacheLookup
    WebElement lnkSignout;
	
//Action Methods...
    public void SetUserName(String uname)
    {
    	txtEmail.sendKeys(uname);
    }
    
    public void SetPassword(String pwd)
    {
    	txtPassword.sendKeys(pwd);
    }
    
    public void clickLogin()
    {
    	Subbtn.click();
    }
    
    public void clickSignout()
    {
    	lnkSignout.click();
    }
}

