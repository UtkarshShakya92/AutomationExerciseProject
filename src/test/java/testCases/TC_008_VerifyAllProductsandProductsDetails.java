package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TC_008_VerifyAllProductsandProductsDetails extends TestBase{
	
	@Test
	
	public void ProductsDisplay()
	{
		HomePageObject hp = new HomePageObject(driver);
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		System.out.println("======Home Page Displayed =======");
		
		hp.product_btn();
		
		ProductPage pp = new ProductPage(driver);
			
		Assert.assertTrue(pp.all_Product());
		
		System.out.println("======All Product page is  Displayed =======");
		
		Assert.assertFalse(pp.brand_List());
		
		System.out.println("======Product List is Displayed =======");
		
		// click on first product view btn 
		pp.first_product_view_btn();
		
		//get the title of first product page 
		
		String first_product_title = pp.first_Product_Page_Title();
		
		Assert.assertEquals(first_product_title, "Automation Exercise - Product Details");
		
		System.out.println("======First Product page Title is Displayed =======");
		
		Assert.assertTrue(pp.product_name());
		
		System.out.println("======Product Name  is Displayed =======");
		
		Assert.assertTrue(pp.category());
		
		System.out.println("======Category is Displayed =======");
		
		
		//verifying the price is displayed or not
		String priceofproduct = pp.pricing();
		
		if(priceofproduct.contains("500"))
		{
			System.out.println("======Price  is Displayed =======");
			Assert.assertTrue(true);
		}
		
		else
		{
			System.out.println("======Price  is not  Displayed =======");
			Assert.fail();
		}
		
		String productavail = pp.availavilityOfProduct();
		if(productavail.contains("In Stock"))
		{
			System.out.println("======ProductAvailiblity  is Displayed =======");
			Assert.assertTrue(true);
		}
		
		else
		{
			System.out.println("======ProductAvailiblity  is not  Displayed =======");
			Assert.fail();
		}
		
		String productcondition = pp.product_condition();
		if(productcondition.contains("New"))
		{
			System.out.println("======Product Condition is Displayed =======");
			Assert.assertTrue(true);
		}
		
		else
		{
			System.out.println("======Product Condition  is not  Displayed =======");
			Assert.fail();
		}
		
		String productBrand = pp.product_brand();
		if(productBrand.contains("Polo"))
		{
			System.out.println("======Product Brand is Displayed =======");
			Assert.assertTrue(true);
		}
		
		else
		{
			System.out.println("======Product Brand  is not  Displayed =======");
			Assert.fail();
		}
	}
	
	

	
	
	 
}
