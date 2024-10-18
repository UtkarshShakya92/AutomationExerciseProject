package testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePageObject;
import pageObjects.PaymentPage;
import pageObjects.RegistrationPage;
import testBase.TestBase;

public class TC_008_PlaceOrder_RegisterBeforeCheckout extends TestBase {

	@Test
	public void placeOrderAfterRegistraition() {
		HomePageObject hp = new HomePageObject(driver);

		String actualTitle = hp.getHomePageTitle();

		Assert.assertEquals(actualTitle, "Automation Exercise");

		System.out.println("===Home PAge display is verified==");

		hp.linkLoginAndSignClick();

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

		Assert.assertTrue(rp.account_created_msg());

		rp.continue_btn_click();

		String loginAs = rp.login_user_name();

		Assert.assertEquals(loginAs, "test33");

		hp.home_page_BlueTop_Product();

		hp.homepageContinuebtn();

		hp.home_page_menTshirt_Product();

		hp.clickHomepageViewCartbtn();

		CartPage cp = new CartPage(driver);
		String shoppingCart = cp.verify_Cart_Page();

		Assert.assertEquals(shoppingCart, "Shopping Cart", "Cart Page is not displayed");

		cp.click_CheckOut_btn();

		// verify the billing address in CheckOutPage

		CheckOutPage cop = new CheckOutPage(driver);

		List<String> billingAddress = new ArrayList<String>();
		billingAddress.add("Mr. Test33 testing");
		billingAddress.add("TestComp");
		billingAddress.add("test103");
		billingAddress.add("test203");
		billingAddress.add("Canbera Whales 345678");
		billingAddress.add("Australia");
		billingAddress.add("9999999999");

		// Verifying the Delivery Address
		for (int i = 0; i < billingAddress.size(); i++) {
			Assert.assertTrue(cop.getAddressDelivery().get(i).contains(billingAddress.get(i)));
		}

		System.out.println("billing address  is verified");

		// Verifying the Delivery Address

		List<String> invoiceAddress = new ArrayList<String>();
		invoiceAddress.add("Mr. Test33 testing");
		invoiceAddress.add("TestComp");
		invoiceAddress.add("test103");
		invoiceAddress.add("test203");
		invoiceAddress.add("Canbera Whales 345678");
		invoiceAddress.add("Australia");
		invoiceAddress.add("9999999999");

		System.out.println(invoiceAddress.get(0));

		for (int i = 0; i < invoiceAddress.size(); i++) {
			Assert.assertTrue(cop.getAddressBilling().get(i).contains(invoiceAddress.get(i)));
		}
		System.out.println("Invoice address  is verified");

		// verifying the products in checkout page

		List<String> products = new ArrayList<String>();
		products.add("Blue Top");
		products.add("Men Tshirt");

		for (int i = 0; i < products.size(); i++) {
			Assert.assertTrue(cop.getCheckoutProducts().get(i).contains(products.get(i)));
		}

		System.out.println("Products in checkout page are verified");

		// verify products total amount

		Assert.assertEquals(cop.productsTotalAmount(), "Rs. 900");

		System.out.println("Total amount is verified");

		cop.message_text_area("This is for Testing . thank you");

		cop.clickPlaceOrderBtn();

		PaymentPage pp = new PaymentPage(driver);

		pp.enternameOnCard("Test33 test");

		pp.enterCardNumber("3454346464");

		pp.enterCvcNumber("343");

		pp.enterExpiryMonth("11");

		pp.enterExpiryYear("2024");

		pp.clickPayandSubmit();

		String alertmsg = pp.orderSuccessMsg();

		Assert.assertEquals(alertmsg, "Congratulations! Your order has been confirmed!", "Alert msg success");

		pp.clickDeletebtn();

		Assert.assertTrue(pp.deleteAcDisplay());

		pp.clickContinuebtn();
	}
}
