package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TC_0012_CartBrandProducts extends TestBase{
	
	@Test
	public void verifyCartBrnadProducts()
	{
		HomePageObject hp =new HomePageObject(driver);
		
		hp.product_btn();
		
		ProductPage pp = new ProductPage(driver);
		
		pp.javaScriptScroll("window.scrollBy(0,500)");
		
        Assert.assertFalse(pp.brand_List());
		
		System.out.println("======Product Brand List is Displayed =======");
		
		
		pp.madame_brandproductselect();
		
		pp.madametitleverify();
		System.out.println("======Madame Brand Products are Displayed =======");
		
		
		
		pp.biba_brandproductselect();
		
		pp.bibatitleverify();
		
		System.out.println("======BIBA Brand Products are Displayed =======");
		
	}

}
