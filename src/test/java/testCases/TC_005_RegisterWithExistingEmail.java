package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegistrationPage;
import testBase.TestBase;

public class TC_005_RegisterWithExistingEmail extends TestBase {

	@Test
	public void registerWithExistingeEmail() {
		HomePageObject hp = new HomePageObject(driver);

		String actualTitle = hp.getHomePageTitle();

		Assert.assertEquals(actualTitle, "Automation Exercise");

		logger.info("=======The Home Page is visible successfully====");

		hp.linkLoginAndSignClick();

		RegistrationPage rp = new RegistrationPage(driver);

		// rp.getSignUpmsg();

		Assert.assertTrue(rp.getSignUpmsg());

		System.out.println("New User Signup! == is displayed");

		rp.enterName("Test24");
		rp.enterEmail("test1992@gmail.com");
		rp.signupbtnClick();
		
		Assert.assertTrue(rp.emailAlreadyExistText());
		
		System.out.println("Email already error msg  == is displayed");
	}

}
