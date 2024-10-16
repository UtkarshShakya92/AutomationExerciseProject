package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePageObject;
import pageObjects.RegistrationPage;
import testBase.TestBase;

public class TC_007_PlaceOrderWithRegister extends TestBase{

	
	@Test
	public void PlaceOrderWithRegister()
	{
		HomePageObject hp = new HomePageObject(driver);
		
		String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		System.out.println("===Home PAge display is verified==");
		
		//adding home page products to cart
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		hp.home_page_BlueTop_Product();
		
		hp.homepageContinuebtn();
		hp.home_page_menTshirt_Product();
		
		hp.clickHomepageViewCartbtn();
		
		CartPage cp = new CartPage(driver);
		String cartpagetext = cp.verify_Cart_Page();
		
		if(cartpagetext.equalsIgnoreCase("Shopping Cart"))
		{
			System.out.println("Cart Page is dispayed");
			
			assertTrue(true);
		}
		
		else
		{
           System.out.println("Cart Page is not dispayed");
			
			assertTrue(false);
		}
		
		cp.click_CheckOut_btn();
		
		cp.click_RegisterLogin_btn();
		
		// Entering details on signup / login page
		RegistrationPage rp = new RegistrationPage(driver);
		
		rp.enterName("test33");
		
		rp.enterEmail("test33@33gmail.com");
		
		rp.signupbtnClick();
		
		// Entering details on register page
		
		rp.title();
		
		rp.enter_Password("test33");
		
		rp.day_select("16");
		
		rp.month_select("10");
		
		rp.years_select("2004");
		
		rp.enter_first_name("Test33");
		
		rp.enter_last_name("testing");
		
		rp.enter_company_name("Test");
		
		rp.enter_address1("test103");
		
		rp.country_drp_down("Australia");
		
		rp.enter_state("Whales");
		
		rp.enter_city("Canbera");
		
		rp.enter_zip_code("345678");
		
		rp.enter_mobile_no("9999999999");
		
		rp.click_account_btn();
		
		//Asserting Accout created msg 
		
		Assert.assertTrue(rp.account_created_msg());
		
		rp.continue_btn_click();
		
		String loginAs = rp.login_user_name();
		
		Assert.assertEquals(loginAs, "test33");
		
		//rp.delete_Account_btn();
		
		//Clicking cart button
		
		hp.click_Cart_btn();
		
		cp.click_CheckOut_btn();
	}
}
