package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import testBase.TestBase;

public class TC_0015_AddToCart_Recommended_Items extends TestBase{

	@Test
	public void AddTocartRecommendedItems()
	{
		HomePageObject hp = new HomePageObject(driver);
		
		hp.homePageScrollToLast();
		
		String recomendtxt = hp.recommendedtxt();
		
		Assert.assertEquals(recomendtxt, "RECOMMENDED ITEMS");
		
		System.out.println("Recommended Itemd displayed");
	}
}
