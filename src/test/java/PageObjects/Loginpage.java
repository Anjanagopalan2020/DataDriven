package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage{
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(css="input[name='email']") private WebElement txtemail;
	
	@FindBy(id="input-password")private WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")private WebElement btnSubmit;
	
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
}
