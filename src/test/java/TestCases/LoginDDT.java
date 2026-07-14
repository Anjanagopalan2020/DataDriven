package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Home;
import PageObjects.Loginpage;
import PageObjects.MyAccounts;
import Utilities.DataDriven;

public class LoginDDT extends BaseClass {
	
	@Test(dataProvider="getData" ,dataProviderClass=DataDriven.class ,groups="datadriven")
	public void verify_account_login(String username,String password,String res) throws InterruptedException {
	try {	
		logger.info("***starting the test***");
		Home h=new Home(driver);
		
		logger.info("***clicking accounts***");
		h.clickAccounts();
		Thread.sleep(5000);
		logger.info("***clicking login***");
		h.clickLogin();
		
		Loginpage lo=new Loginpage(driver);
		
		lo.setEmail(username);
		Thread.sleep(5000);
		lo.setpassword(password);
		Thread.sleep(5000);
		logger.info("***clicking submit***");
		lo.clickSubmit();
		Thread.sleep(5000);
		
		MyAccounts ma=new MyAccounts(driver);
		boolean value=ma.isMyAccountPageExist();
		
		if(res.equalsIgnoreCase("valid"))
		{
			if(value==true)
			{
				h.clickAccounts();
				ma.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(res.equalsIgnoreCase("invalid"))
		{
			if(value==true)
			{
				h.clickAccounts();
				ma.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
		
	}	

}
