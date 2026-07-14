package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistration;
import PageObjects.Home;
import io.github.bonigarcia.wdm.WebDriverManager;

public class T001_AccountRegistration extends BaseClass {
	
	
	
	@Test(groups= {"sanity","master"})
	public void verify_account_registration() {
		
		logger.info("***starting the test***");
		Home h=new Home(driver);
		
		logger.info("***clicking accounts***");
		h.clickAccounts();
		
		logger.info("***clicking register***");
		h.clickRegister();
		AccountRegistration a=new AccountRegistration(driver);
		logger.info("***filling the fields***");
		a.setFirstname(randomString());
		a.setLastname(randomString());
		a.setEmail(randomString()+"@yopmail.com");
		a.setPhone("1234567");
		a.setPassword("123456");
		a.setConfirm("123456");
		a.setPrivacy();
		a.clickContinue();
		logger.info("***validatiing ***");
		String expected=a.getConfirmation();
		String actual="Your Account Has Been Created!";
		AssertJUnit.assertEquals(expected, actual);
	}
	
	
	
	

}
