package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.ProductPage;
import testBase.TestBase;

public class TC_021_WriteReviewOnAnyProduct extends TestBase {
	
	@Test
	public void WriteReviewOnProduct()
	{
	HomePageObject hp = new HomePageObject(driver);
	hp.product_btn();
	
	ProductPage pp = new ProductPage(driver);
	
	Assert.assertTrue(pp.all_Product());
	
	System.out.println("=====All Product Page is displayed======");
	
	pp.javaScriptScroll("window.scrollBy(0,1200)");
	
	pp.madameTopseventhProduct();
	
	Assert.assertTrue(pp.writeReviewheading());
	System.out.println("=====write Review Heading  is displayed======");
	
	pp.reviewerName("Test33");
	
	pp.reviewerEmail("test33@33gmail.com");
	
	pp.enterReviewtxtfld("The Product is good. Value for Money ");
	
	
	pp.reviewSubmitbtn();
	
	String reviewAlertMsg = pp.reviewSuccess_AlertMsg();
	
	Assert.assertEquals(reviewAlertMsg, "Thank you for your review.");
	
	System.out.println("=====Review Thankyou alert  is displayed======");
	}

}
