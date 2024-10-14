package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;

import pageObjects.HomePageObject;
import pageObjects.LoginPage;
import testBase.TestBase;

public class TC_002_LoginTest extends TestBase{

	//@Test
	public void verify_Login()
	{
	 
	HomePageObject hp = new HomePageObject(driver);
	
	logger.info("=======login page============");
	
	String actualTitle = hp.getHomePageTitle();
	
	Assert.assertEquals(actualTitle, "Automation Exercise");
	
	logger.info("=======The Home Page is visible successfully====");
	hp.linkLoginAndSignClick();
	LoginPage lp = new LoginPage(driver);

	lp.loginEmail(p.getProperty("email"));
	lp.loginPassword(p.getProperty("password"));
	
	lp.clickLoginBtn();
	
	////div[@class='col-sm-8']//li//a[text()=' Logged in as ']
	
	String message= hp.confirm_Login_Msg();
     
	if(message.contains("Logged in as"))
	{
		Assert.assertTrue(true);
		
	}
	
	else
	{
		Assert.assertFalse(false);
	}

	logger.info("=============login passed ==================");
	//Assert.assertEquals(message,"")
	}
	
	
	//@Test
	
	public void loginUser_Invalid_Credentials()
	{
		
		
		HomePageObject hp = new HomePageObject(driver);
		
		logger.info("=======login page============"); 
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		logger.info("=======The Home Page is visible successfully====");
		
		hp.linkLoginAndSignClick();
		
		LoginPage lp = new LoginPage(driver);
		
		Assert.assertTrue(lp.loginAccountmsg());
		
		System.out.println("Account Login Msg Displayed=======");
		

		lp.loginEmail("test44@gmail.com");
		lp.loginPassword("test44");
		
		lp.clickLoginBtn();
		
		Assert.assertTrue(lp.invalid_email_pwd_text());
		
		System.out.println("Invalid Email and Password ms displayed =======");
	}
	
	@Test
	
	public void logOut_User()
	{
		HomePageObject hp = new HomePageObject(driver);
		
		logger.info("=======login page============");
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		logger.info("=======The Home Page is visible successfully====");
		hp.linkLoginAndSignClick();
		LoginPage lp = new LoginPage(driver);

		lp.loginEmail(p.getProperty("email"));
		lp.loginPassword(p.getProperty("password"));
		
		lp.clickLoginBtn();
		
		////div[@class='col-sm-8']//li//a[text()=' Logged in as ']
		
		String message= hp.confirm_Login_Msg();
	     
		if(message.contains("Logged in as"))
		{
			Assert.assertTrue(true);
			
		}
		
		else
		{
			Assert.assertFalse(false);
		}

		logger.info("=============login passed ==================");
		
		
		hp.logoutbtn();
		
        Assert.assertTrue(lp.loginAccountmsg());
		
		System.out.println("Account Login Msg Displayed=======");
	}
}
