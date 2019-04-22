package com.nopcommerce.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtilities;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void LoginTest(String user, String pwd) throws IOException
	{
	logger.info("********Started TC_LoginTest_001*********");
	driver.get(baseURL);
	LoginPage lp = new LoginPage(driver);
	
	logger.info("********Providing Loging info*********");	
	lp.SetUserName(user);
	lp.SetPassword(pwd);
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
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
	String path=System.getProperty("user.dir")+"/testData/LoginData.xlsx";
	
	int rownum=XLUtilities.getRowCount(path, "Sheet1");
	int colcount=XLUtilities.getCellCount(path,"Sheet1",1);
	
	String logindata[][]=new String[rownum][colcount];
	
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			logindata[i-1][j]=XLUtilities.getCellData(path,"Sheet1", i,j);
		}
	}
	
	return logindata;
	}
}
