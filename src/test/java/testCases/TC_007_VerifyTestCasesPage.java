package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import testBase.TestBase;

public class TC_007_VerifyTestCasesPage extends TestBase{

	@Test
	public void verifyTestCasesPage()
	{
		HomePageObject hp = new HomePageObject(driver);

		String actualTitle = hp.getHomePageTitle();

		Assert.assertEquals(actualTitle, "Automation Exercise");

		logger.info("=======The Home Page is visible successfully====");
		
		hp.clickTestCasebtn();
		
		Assert.assertTrue(hp.verifyTestCasestxtintestcasesPage());
		
		System.out.println("=======The TestCases Page is visible successfully====");
	}
}
