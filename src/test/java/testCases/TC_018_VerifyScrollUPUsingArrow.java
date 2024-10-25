package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import testBase.TestBase;

public class TC_018_VerifyScrollUPUsingArrow extends TestBase {

	@Test
	public void verify_ScrollUpFunctionality() {

		HomePageObject hp = new HomePageObject(driver);

		String actualTitle = hp.getHomePageTitle();

		Assert.assertEquals(actualTitle, "Automation Exercise");

		System.out.println("Home Page is displayed=====");

		// Scroll down to footer

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,9200)");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		String substext = hp.subscription_Msg();

		Assert.assertEquals(substext, "SUBSCRIPTION");

		System.out.println("Subscription msg is displayed =====");
		
		hp.scrollTotopBtn();
		
		String fullfledgedtext = hp.verifyFullfledgedTex();
		
		Assert.assertEquals(fullfledgedtext, "Full-Fledged practice website for Automation Engineers");
		
		System.out.println(" Full-Fledged practice website for Automation Engineers is displayed=====");

	}
}
