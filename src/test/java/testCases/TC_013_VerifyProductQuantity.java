package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePageObject;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TC_013_VerifyProductQuantity extends TestBase {

	@Test
	public void Verify_fourth_Product_Quantity() {
		HomePageObject hp = new HomePageObject(driver);

		String actualTitle = hp.getHomePageTitle();

		Assert.assertEquals(actualTitle, "Automation Exercise");

		System.out.println("===Home PAge display is verified==");

		hp.click_fourth_view_product_btn();

		ProductPage pp = new ProductPage(driver);

		String fourthProductdetails = pp.productfourthPage();

		if (fourthProductdetails.contains("Stylish")) {
			Assert.assertTrue(true);

			System.out.println("===4th product page is displayed==");
		}

		pp.increase_product_quantity("4");

		pp.fourth_page_add_Cart_btn();

		pp.click_view_Cart_btn();

		CartPage cp = new CartPage(driver);

		String fouthProductQuant = cp.getfouthProductQuantity();

		Assert.assertEquals(fouthProductQuant, "4");

		System.out.println("===Quantity is verified as 4 prducts in a cart==");
	}
}
