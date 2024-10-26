package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import testBase.TestBase;

public class TC_010_HomePageSubscription extends TestBase{

	
	@Test
	
	public void home_subscription()
	{
		HomePageObject hp = new HomePageObject(driver);
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		System.out.println("Home Page is displayed=====");
		
		// Scroll down to footer
		
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,9200)");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		String substext = hp.subscription_Msg();
		
		Assert.assertEquals(substext, "SUBSCRIPTION");
		
		System.out.println("Subscription msg is displayed =====");
		
		//Enter email address in input and click arrow button
		
		hp.subscription_fld("test1992@gmail.com");
		
		hp.subscription_button();
		
		String success_sub_alert = hp.success_subscribe_alert();
		
		Assert.assertEquals(success_sub_alert, "You have been successfully subscribed!");
		
		System.out.println("Subscription Success Alert msg is displayed =====");
	}
}
