package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test
	public void LoginTest() throws IOException
	{
		logger.info("********Started TC_LoginTest_001*********");
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		
		logger.info("********Providing Loging info*********");	
		lp.SetUserName(username);
		lp.SetPassword(password);
		lp.clickLogin();
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			logger.info("********Login is successfull*********");
		Assert.assertTrue(true);
		}
	
		else
		{
			logger.error("********Login is Failed*********");
			captureScreen(driver,"loginTest");//Capturing screen
		Assert.assertTrue(false);
		}
		logger.info("********completed  TC_LoginTest_001*********");
		
	}
}
