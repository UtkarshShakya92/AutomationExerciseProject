package testCases;

import java.awt.Window;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePageObject;
import testBase.TestBase;

public class TC_006_ContactUs_Test extends TestBase{
	
	@Test
	
	public void CotactUs() throws InterruptedException
	{
		HomePageObject hp = new HomePageObject(driver);
		
        String actualTitle = hp.getHomePageTitle();
		
		Assert.assertEquals(actualTitle, "Automation Exercise");
		
		System.out.println("The Home Page is visible successfully====");
		
		hp.contact_us_btn();
		
		ContactUsPage cp = new ContactUsPage(driver);
		
		Assert.assertTrue(cp.getInTouch());
		
		System.out.println("Get In Touch msg is verified");
		
		cp.contact_Name(p.getProperty("contact_name"));
		
		cp.cotact_email(p.getProperty("contact_email"));
		
		cp.contact_subject(p.getProperty("contact_subject"));
		
		cp.cont_msg(p.getProperty("contact_message"));
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", " ");
		
		cp.upload("C:\\Users\\utk\\Desktop\\Test.txt");
		
		Thread.sleep(3000);
		cp.submit_button();
		
		Alert al = driver.switchTo().alert();
		
		al.accept();
		
		Assert.assertTrue(cp.contact_form_success());
		System.out.println("Contact us form success");
		
		cp.home_btn();
		
        Assert.assertEquals(actualTitle, "Automation Exercise");
		
		System.out.println("The Home Page is visible successfully====");
	}

}
