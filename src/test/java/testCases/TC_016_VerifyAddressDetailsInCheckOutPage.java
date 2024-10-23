package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePageObject;
import pageObjects.RegistrationPage;
import testBase.TestBase;

public class TC_016_VerifyAddressDetailsInCheckOutPage extends TestBase {

	@Test
	public void verifyAddressinCheckout() {
		HomePageObject hp = new HomePageObject(driver);

		String actualTitle = hp.getHomePageTitle();

		Assert.assertEquals(actualTitle, "Automation Exercise");

		System.out.println("===Home PAge display is verified==");
		
		hp.linkLoginAndSignClick();
		
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
				
				rp.enter_company_name("TestComp");
				
				rp.enter_address1("test103");
				
				rp.enter_address2("test203");
				
				rp.country_drp_down("Australia");
				
				rp.enter_state("Whales");
				
				rp.enter_city("Canbera");
				
				rp.enter_zip_code("345678");
				
				rp.enter_mobile_no("9999999999");
				
				rp.click_account_btn();
				
				//Asserting Accout created msg 
				
				Assert.assertTrue(rp.account_created_msg());
				
				rp.continue_btn_click();
				
				String loginAs = hp.login_user_name();
				
				Assert.assertEquals(loginAs, "test33");
				
				hp.homePageScrollTofirstProduct();
				
				hp.home_page_BlueTop_Product();
				
				hp.homepageContinuebtn();
				
				hp.home_page_menTshirt_Product();
				
				hp.clickHomepageViewCartbtn();
				
				CartPage cp = new CartPage(driver);
	}

}
