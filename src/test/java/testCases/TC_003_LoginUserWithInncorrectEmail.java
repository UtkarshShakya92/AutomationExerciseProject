package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPage;
import testBase.TestBase;

public class TC_003_LoginUserWithInncorrectEmail extends TestBase {

	@Test
	public void loginUser_Invalid_Credentials() {

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
}
