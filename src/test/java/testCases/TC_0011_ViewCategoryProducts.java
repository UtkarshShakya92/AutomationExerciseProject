package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import testBase.TestBase;

public class TC_0011_ViewCategoryProducts extends TestBase{
	
	@Test
	public void viewProducsCategory()
	{
	  
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//verifiying category is diplaying 
		
		HomePageObject hp = new HomePageObject(driver);
		
		Assert.assertTrue(hp.categoryDisplay());
		
		System.out.println("Categories are dispayed");
		
		hp.womenCategory();
		
		hp.clickDress();
		
		Assert.assertTrue(hp.verifyWomenDressProduct());
		
		System.out.println("Women Dress Products displayed");
		
		hp.clickMenCategory();
		
		hp.clickJeansProducts();
		
		Assert.assertTrue(hp.categoryDisplay());
		
		System.out.println("Mens Jeans Products are dispayed");
	}

}
