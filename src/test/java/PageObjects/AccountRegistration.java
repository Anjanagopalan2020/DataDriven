package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {
	
	public  AccountRegistration(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(name="firstname") private WebElement txtFirstname;
	@FindBy(name="lastname") private WebElement txtLastname;
	@FindBy(name="email") private WebElement txtemail;
	@FindBy(name="telephone") private WebElement txttelephone;
	@FindBy(name="password")private WebElement password;
	@FindBy(name="confirm")private WebElement confirm;
	@FindBy(name="agree")private WebElement agree;
	@FindBy(xpath="//input[@value='Continue']") private WebElement btnContinue;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']") private WebElement msgConfirmation;
	
	public void setFirstname(String name)
	{
		txtFirstname.sendKeys(name);
	}
	
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setPhone(String tel)
	{
		txttelephone.sendKeys(tel);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void setConfirm(String pass)
	{
		confirm.sendKeys(pass);
	}
	public void setPrivacy()
	{
		agree.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmation()
	{  try {
		return msgConfirmation.getText();
	}
	catch(Exception e)
	{
		e.getMessage();
	}
	return null;
	
	
}
}

