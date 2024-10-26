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

public class TC_011_VerifySubscriptionCartPage extends TestBase{

	@Test
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
	
}
