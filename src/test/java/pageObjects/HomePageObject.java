package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends BaseObject {
	
	
	public HomePageObject(WebDriver driver)
	{
		super(driver);
		}

	
	
	// locator 
	
	@FindBy (xpath = "//a[@href='/login']") 
	WebElement linkLoginAndSignup;
	
	@FindBy(xpath="//div[@class='col-sm-8']//li//a[text()=' Logged in as ']")
	   WebElement login_msg;
	
	@FindBy(xpath ="//ul//li//a[@href='/logout']")
	WebElement logoutbtn;
	
	
	@FindBy(xpath="//ul//li//a[@href='/contact_us']")
	WebElement contactusbtn;
	
	@FindBy(xpath="//ul//li//a[@href='/products']")
	WebElement products_btn; 
	
	@FindBy(css = ".single-widget h2")
	WebElement subscription;
	
	@FindBy(id="susbscribe_email")
	WebElement subscription_txt_fld;
	
	@FindBy(id="subscribe")
	WebElement subscribe_btn;
	
	@FindBy(id="success-subscribe")
	WebElement alert_subscribe_msg;
	
	@FindBy(xpath="//ul//li//a[@href='/view_cart']")
	WebElement cart_btn;
	
	//action 
	
	//Automation Exercise-- title 
	
		public String getHomePageTitle()
		{
			return driver.getTitle();
					}
	
	
	public void linkLoginAndSignClick()
	{
		linkLoginAndSignup.click();
	}
	
	public String confirm_Login_Msg()
	   {
		   try {
		   return (login_msg.getText());
		   }
		   
		   catch(Exception e)
		   {
			   return(e.getMessage());
		   }
	   }
	
	public void logoutbtn()
	{
		logoutbtn.click();
	}
	
	public void contact_us_btn()
	{
		contactusbtn.click();
	}
	
	public void product_btn()
	{
		products_btn.click();
		}
	
	public String  subscription_Msg()
	{
		return subscription.getText();
	}
	
	public void subscription_fld(String subsemail)
	{
		subscription_txt_fld.sendKeys(subsemail);
	}
	
	public void subscription_button()
	{
		subscribe_btn.click();
	}
	
	public String  success_subscribe_alert()
	{
		return alert_subscribe_msg.getText();
	}
	
	public void click_Cart_btn()
	{
		cart_btn.click();
	}
	
	
}
