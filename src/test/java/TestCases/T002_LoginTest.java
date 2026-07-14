package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Home;
import PageObjects.Loginpage;
import PageObjects.MyAccounts;

public class T002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity","regression","master"})
	public void login_test() throws InterruptedException
	{
		logger.info("***starting the test***");
		Home h=new Home(driver);
		
		logger.info("***clicking accounts***");
		h.clickAccounts();
		Thread.sleep(5000);
		logger.info("***clicking login***");
		h.clickLogin();
		
		Loginpage lo=new Loginpage(driver);
		
		lo.setEmail(pro.getProperty("username"));
		Thread.sleep(5000);
		lo.setpassword(pro.getProperty("password"));
		Thread.sleep(5000);
		logger.info("***clicking submit***");
		lo.clickSubmit();
		Thread.sleep(5000);
		
		MyAccounts ma=new MyAccounts(driver);
		boolean value=ma.isMyAccountPageExist();
		
		Assert.assertTrue(value);
	}

}
