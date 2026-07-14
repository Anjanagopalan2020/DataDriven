package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public WebDriver driver;
	public Logger logger;
	public Properties pro;
	public FileInputStream in;
	@BeforeClass(groups= {"sanity","master","regression"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException
	{
		
		pro=new Properties();
		in=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		pro.load(in);
		logger=LogManager.getLogger(this.getClass());
		
	  if(pro.getProperty("execution_env").equalsIgnoreCase("remote")){
		  
		  DesiredCapabilities cap=new DesiredCapabilities();
		  
		  if(os.equals("Windows"))
		  {
			  cap.setPlatform(Platform.WIN11);
		  }
		  else if(os.equals("Mac"))
		  {
			  cap.setPlatform(Platform.MAC);
		  }
		  else
		  {
			  System.out.print("no matching");return;
		  }
		  
		  switch(br.toLowerCase()) {
			case "chrome":cap.setBrowserName("Chrome");break;
			
			case "firefox":cap.setBrowserName("Firefox");break;
			
			default:System.out.println("wrong");
			}
		  
		  driver=new RemoteWebDriver(new URL("http://192.168.29.149:4444/"),cap);
		  
	  }
		
		
		
		
	  if(pro.getProperty("execution_env").equalsIgnoreCase("local")){
		
		switch(br.toLowerCase()) {
		case "chrome":WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();break;
		
		case "firefox":WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();break;
		
		default:System.out.println("wrong");
		}
		driver.get(pro.getProperty("url"));
		String a=pro.getProperty("url");
		System.out.print(a);
		driver.manage().window().maximize();
	}
	}
	
	@AfterClass(groups= {"sanity","master","regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	public String randomNumber()
	{
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String randomAlphaNumeric()
	{
		String alpha=RandomStringUtils.randomAlphabetic(5);
		String number= RandomStringUtils.randomNumeric(10);
		return(alpha+"@"+number);
		
	}

}
