package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePageObject;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TC_0013_SearchProductandVerifyCartAfterLogin extends TestBase {

	@Test
	public void searchAndVerifyCartAfterLogin() {
		HomePageObject hp = new HomePageObject(driver);

		hp.product_btn();

		ProductPage pp = new ProductPage(driver);

		Assert.assertTrue(pp.all_Product());

		System.out.println("All product page is displayed");

		// sending characters on search

		pp.searchBox("jeans");

		pp.submitbtn();

		Assert.assertTrue(pp.searchProducttext());

		System.out.println("Searched Product text is displayed");

		pp.javaScriptScroll("window.scrollBy(0,600)");

		boolean result = pp.searchElements("jeans");

		Assert.assertTrue(result, "Not All product for jeans");

		System.out.println("======All Product of Jeans are  Displayed =======");

		// Searched products --adding to cart

		pp.clickAddtoCartSearchedProductList();

		pp.click_Cart_Btn();

		CartPage cp = new CartPage(driver);

		Assert.assertTrue(cp.productsInCart("jeans"));

		System.out.println("======In Cart Products related to search are displayed =======");

		cp.clickLogin_signUp_Btn();

		LoginPage lp = new LoginPage(driver);

		lp.loginEmail(p.getProperty("email"));
		lp.loginPassword(p.getProperty("password"));

		lp.clickLoginBtn();

		hp.click_Cart_btn();

		Assert.assertTrue(cp.productsInCart("jeans"));

		System.out.println("======In Cart Products related to search are displayed =======");
	}

}
