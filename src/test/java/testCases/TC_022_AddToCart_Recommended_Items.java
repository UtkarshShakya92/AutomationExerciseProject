package testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePageObject;
import testBase.TestBase;

public class TC_022_AddToCart_Recommended_Items extends TestBase{

	@Test
	public void AddTocartRecommendedItems()
	{
		HomePageObject hp = new HomePageObject(driver);
		
		hp.homePageScrollToLast();
		
		String recomendtxt = hp.recommendedtxt();
		
		Assert.assertEquals(recomendtxt, "RECOMMENDED ITEMS");
		
		System.out.println("Recommended Itemd displayed");
		
		hp.recommendedProductsclick();
		
		hp.click_Cart_btn();
		
		CartPage cp = new CartPage(driver);
		
		// verifying the products in checkout page

				List<String> products = new ArrayList<String>();
				products.add("Blue Top");
				products.add("Men Tshirt");
				products.add("Sleeveless Dress");
				products.add("Stylish Dress");
				products.add("Winter Top");
				products.add("Summer White Top");

				for (int i = 0; i < products.size(); i++) {
					Assert.assertTrue(cp.getCartProducts().get(i).contains(products.get(i)));
				}

				System.out.println("Products in Cart page are verified");
	}
}
