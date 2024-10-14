package testCases;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePageObject;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TC_006_CartTest extends TestBase{

	//@Test
	public void verify_Supscription_msg()
	{
		HomePageObject hp = new HomePageObject(driver);
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		System.out.println("===Home PAge display is verified==");
		
		hp.click_Cart_btn();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		CartPage cp = new CartPage(driver);
		
		Assert.assertTrue(cp.subscription_msg());
		
		System.out.println("=====Susbscription msg is displayed ====");
		
		cp.insert_Subscription_email_id(p.getProperty("email"));
		
		cp.subscription_click_btn();
		
		String success_subs = cp.subscription_alert();
		
		Assert.assertEquals(success_subs, "You have been successfully subscribed!");
		
		System.out.println("=====Success Susbscription alert msg is displayed ====");
		
	}
	
	@Test
	public void addToCartProducts()
	{
       HomePageObject hp = new HomePageObject(driver);
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		System.out.println("===Home PAge display is verified==");
		
		hp.product_btn();
		
		ProductPage pp= new ProductPage(driver);
		
		pp.javaScriptScroll();
		
		pp.hoverOverFirstProduct();
		
		/*WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		mywait.until(ExpectedConditions.;*/
		
		pp.mouseHoverFirstProductandClick();
		System.out.println("===hoverd over 1st product==");
		
		pp.continue_button();
		
		pp.hover_over_Second_Product();
		
		pp.secondProductAddClick();
		
		pp.click_view_Cart_btn();
		
		
		//12 --Verify both products are added to Cart
		// ---Verify their prices, quantity and total price
		
		CartPage cp = new CartPage(driver);
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "Blue Top");
		map.put(1, "Women > Tops");
		map.put(1,"Rs. 500");
		map.put(1, "1");
		map.put(1,"Rs. 500");
		map.put(2, "Men Tshirt");
		map.put(2, "Men > Tshirts");
		map.put(2, "Rs. 400");
		map.put(2, "1");
		map.put(2, "Rs. 400");
		
		Assert.assertTrue(cp.firstProduct().contains(map.get(1)));
		
		Assert.assertTrue(cp.secondProduct().contains(map.get(2)));
		
		System.out.println("Products and prices are verified");
		
	}
}
