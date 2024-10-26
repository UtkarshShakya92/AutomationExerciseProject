package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TC_009_SearchProduct extends TestBase{

@Test
	
	public void search_Functionality()
	{
		
       HomePageObject hp = new HomePageObject(driver);
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		System.out.println("======Home Page Displayed =======");
		
        hp.product_btn();
		
		ProductPage pp = new ProductPage(driver);
			
		Assert.assertTrue(pp.all_Product());
		
		System.out.println("======All Product page is  Displayed =======");
		
		
		pp.searchBox("Jeans");
		
		pp.submitbtn();
		
		//Verify 'SEARCHED PRODUCTS' is visible
		
				Assert.assertTrue(pp.searchProducttext());
				System.out.println("======Searched Product page is  Displayed =======");
		
				
		//search : Verify all the products related to search are visible	
		boolean result = pp.searchElements("jeans");
		
		Assert.assertTrue(result,"Not All product for jeans");
		
		System.out.println("======All Product of Jeans are  Displayed =======");
	}
}
