package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Home;

public class T003_AddLaptopToCart extends BaseClass {

	@Test(groups= {"sanity","regression","master"})
	public void add_one_laptop_to_cart()
	{
		logger.info("***starting add laptop to cart test***");
		Home h=new Home(driver);

		logger.info("***opening laptops and notebooks category***");
		h.clickLaptopsAndNotebooks();
		h.clickShowAllLaptopsAndNotebooks();

		logger.info("***adding MacBook to cart***");
		h.clickAddMacBookToCart();

		Assert.assertTrue(h.isSuccessAlertDisplayed());

		logger.info("***opening shopping cart***");
		h.clickShoppingCart();

		Assert.assertTrue(h.isMacBookPresentInCart());
	}
}
