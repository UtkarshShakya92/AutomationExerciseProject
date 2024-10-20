package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
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
	}

}
