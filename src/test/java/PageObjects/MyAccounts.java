package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccounts extends BasePage {
	
	public MyAccounts(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//h2[text()=\"My Account\"]") private WebElement msgHeading;
	
	@FindBy(linkText="Logout") private WebElement textLogout;
	
	public boolean isMyAccountPageExist()
	{
		return msgHeading.isDisplayed();
	}
	
	public void clickLogout()
	{
		textLogout.click();
	}
}
