package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addCutomer() throws IOException, InterruptedException
	{
		
	driver.get(baseURL);
	LoginPage lp = new LoginPage(driver);
	
	logger.info("********Providing Login info*********");
	lp.SetUserName(username);
	lp.SetPassword(password);
	lp.clickLogin();
	
	logger.info("******** TC_AddCustomerTest_003 Started *********");
	AddCustomerPage addcust = new AddCustomerPage(driver);
	
	addcust.clickOnCustomersMenu();
	addcust.clickOnCustomersMenuItem();
	addcust.clickOnAddnew();
	
	logger.info("********Providing customer's details*********");
	
	String email=randomstring()+"@gmail.com";
	addcust.setEmail(email);
	addcust.setPassword("test123");
	addcust.setCustomerRoles("Guest");
	addcust.setManagerOfVendor("Vendor 2");
	addcust.setGender("Male");
	addcust.setFirstName("Shaggy");
	addcust.setLastName("Louis");
	addcust.setDob("7/05/1985");//Format: DD/MM/YYYY
	addcust.setCompanyName("BusyQA");
	addcust.setAdminContent("This is for Testing.....");
	addcust.clickOnSave();
	
//Validation....
	
	String msg=driver.findElement(By.tagName("body")).getText();
	
	if(msg.contains("The new customer has been added successfully"))
	{
		logger.info("********Customer added Successfully*********");
		Assert.assertTrue(true);
	}
	else
	{
		logger.info("********Customer not added Successfully*********");
		captureScreen(driver,"addNewCustomer");//Capturing screen
		Assert.assertTrue(false);
	}
	logger.info("********completed  TC_AddCustomerTest_003*********");
	}
	
}
