package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePageObject;
import testBase.TestBase;

public class TC_0010_RemoveProductsFromCart extends TestBase {

	@Test
	public void removeProductsFromcart() {

		HomePageObject hp = new HomePageObject(driver);

		String actualTitle = hp.getHomePageTitle();

		Assert.assertEquals(actualTitle, "Automation Exercise");

		System.out.println("===Home PAge display is verified==");

		// adding home page products to cart

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		hp.home_page_BlueTop_Product();

		hp.homepageContinuebtn();
		hp.home_page_menTshirt_Product();

		hp.clickHomepageViewCartbtn();

		CartPage cp = new CartPage(driver);
		
		String cartpagetext = cp.verify_Cart_Page();

		if (cartpagetext.equalsIgnoreCase("Shopping Cart")) {
			System.out.println("Cart Page is dispayed");

			assertTrue(true);
		}

		else {
			System.out.println("Cart Page is not dispayed");

			assertTrue(false);
		}
		
		cp.remove_first_Product();
		
		cp.remove_second_Product();
		
		Assert.assertTrue(cp.emptyCartmsg());
		
		System.out.println("The cart is empty");
	}
}
