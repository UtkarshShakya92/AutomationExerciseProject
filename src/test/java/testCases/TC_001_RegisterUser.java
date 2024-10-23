package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegistrationPage;
import testBase.TestBase;

public class TC_001_RegisterUser extends TestBase{
	
	@Test
	public void registerNewUser()
	{
		HomePageObject hp = new HomePageObject(driver);
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		logger.info("=======The Home Page is visible successfully====");
		
		hp.linkLoginAndSignClick();
		
		RegistrationPage rp = new RegistrationPage(driver);
		
		//rp.getSignUpmsg();
		
		Assert.assertTrue(rp.getSignUpmsg());
		
		System.out.println("New User Signup! == is displayed");
		
		//Assert.assertEquals(actualsignmsg, "New User Signup!");
		
		////h2[text()='New User Signup!']
		
		
		rp.enterName("Test22");
		rp.enterEmail("test22@22gmail.com");
		rp.signupbtnClick();
		
		
        Assert.assertTrue(rp.enterSignupPage_msg());
		
		System.out.println("Enter Account Information == is displayed");
		
		rp.title();
		
		rp.enter_Password("Test22");
		rp.day_select("15");
	
		WebDriverWait mywait  = new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("months")));
		rp.month_select("3");
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years")));
		rp.years_select("1988");
		rp.newsLetter_box();
		rp.special_offer_chk_box();
		rp.enter_first_name("Test22");
		rp.enter_last_name("Testing");
		rp.enter_company_name("XYZ");
		rp.enter_address1("BTM Layout stage 2");
		rp.country_drp_down("India");
		rp.enter_state("Karnatka");
		rp.enter_city("Bengaluru");
		rp.enter_zip_code("560068");
		rp.enter_mobile_no("9999999999");
		rp.click_account_btn();
		
		////Checking Account Created is displayed
		
		Assert.assertTrue(rp.account_created_msg());
		System.out.println("Account created msg is==== displayed");
		
		/*String accmsg = rp.account_created_msg();
		if(accmsg.contains("Account Created!"))
		{
			Assert.assertTrue(true);
			System.out.println("Account created msg is displayed");
		}
		
		else
		{
			Assert.assertTrue(false);
			System.out.println("Account created msg is not displayed");
		}*/
		
		//continue button is clicked
		rp.continue_btn_click();
		
		
		//Checking UserName is displayed or not 
		
		String userLoginName = hp.login_user_name();
		
		if(userLoginName.contains("Test22"))
		{
			Assert.assertTrue(true);
			System.out.println("Login User name is displayed");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Login User name is not displayed");
		}
		
		
		//delete account btn click
		
		hp.delete_Account_btn();
		
		String acc_delete_msg = hp.delete_account_msg();
		
		if(acc_delete_msg.equalsIgnoreCase("ACCOUNT DELETED!"))
		{
			Assert.assertTrue(true);
			System.out.println("Account deleted is displayed");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Account deleted is not displayed");
		}
		
		hp.del_page_conti_btn();
	}

}
