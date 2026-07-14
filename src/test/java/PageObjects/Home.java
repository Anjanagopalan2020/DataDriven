package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends BasePage{

	
	public Home(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(linkText="Register") private WebElement Register;
	
	@FindBy(xpath="//span[text()='My Account']") private WebElement linkAccount;
	
	@FindBy(css="ul.dropdown-menu>li:nth-of-type(2)>a") private WebElement Login;

	@FindBy(linkText="Laptops & Notebooks") private WebElement linkLaptopsAndNotebooks;

	@FindBy(linkText="Show All Laptops & Notebooks") private WebElement linkShowAllLaptopsAndNotebooks;

	@FindBy(xpath="//a[text()='MacBook']/ancestor::div[contains(@class,'product-thumb')]//button[contains(@onclick,'cart.add')]")
	private WebElement btnAddMacBookToCart;

	@FindBy(css="div.alert-success")
	private WebElement successAlert;

	@FindBy(linkText="shopping cart")
	private WebElement linkShoppingCart;

	@FindBy(linkText="MacBook")
	private WebElement linkMacBook;
	
	
	public void clickAccounts()
	{
		linkAccount.click();
	}
	
	public void clickRegister()
	{
		Register.click();
	}
	
	public void clickLogin()
	{
		Login.click();
	}

	public void clickLaptopsAndNotebooks()
	{
		linkLaptopsAndNotebooks.click();
	}

	public void clickShowAllLaptopsAndNotebooks()
	{
		linkShowAllLaptopsAndNotebooks.click();
	}

	public void clickAddMacBookToCart()
	{
		btnAddMacBookToCart.click();
	}

	public boolean isSuccessAlertDisplayed()
	{
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(successAlert)).isDisplayed();
	}

	public void clickShoppingCart()
	{
		linkShoppingCart.click();
	}

	public boolean isMacBookPresentInCart()
	{
		return linkMacBook.isDisplayed();
	}
}
