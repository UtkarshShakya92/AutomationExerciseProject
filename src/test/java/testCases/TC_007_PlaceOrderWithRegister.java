package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePageObject;
import testBase.TestBase;

public class TC_007_PlaceOrderWithRegister extends TestBase{

	
	@Test
	public void PlaceOrderWithRegister()
	{
		HomePageObject hp = new HomePageObject(driver);
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		System.out.println("===Home PAge display is verified==");
		
		//adding home page products to cart
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		hp.home_page_BlueTop_Product();
		
		hp.homepageContinuebtn();
		hp.home_page_menTshirt_Product();
		
		hp.clickHomepageViewCartbtn();
		
		CartPage cp = new CartPage(driver);
		String cartpagetext = cp.verify_Cart_Page();
		
		if(cartpagetext.equalsIgnoreCase("Shopping Cart"))
		{
			System.out.println("Cart Page is dispayed");
			
			assertTrue(true);
		}
		
		else
		{
           System.out.println("Cart Page is not dispayed");
			
			assertTrue(false);
		}
		
		cp.click_CheckOut_btn();
		
		cp.click_RegisterLogin_btn();
		
		
	}
}
