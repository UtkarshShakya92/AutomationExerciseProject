package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath="//a[@href='/product_details/4']")
	WebElement fourthProductView_btn;
	
	///test case 14 : for adding products from home page to cart 
	
	@FindBy(xpath="(//a[@data-product-id='1'])[1]")
	WebElement homepage_bluetop;
	
	@FindBy(xpath="(//a[@data-product-id='2'])[1]")
	WebElement homepage_menTshirt;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	WebElement homepage_continue_btn;
	
	@FindBy(xpath="//a[@href='/view_cart']//u")
	WebElement homepageViewCartbtn;
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
	
	//login msg
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
	
	public void click_fourth_view_product_btn()
	{
		fourthProductView_btn.click();
	}
	
	
	
	
	///test case 14 : for adding products from home page to cart 
	
	public void home_page_BlueTop_Product()
	{
		homepage_bluetop.click();
	}
	
	public void home_page_menTshirt_Product()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(homepage_menTshirt));
		homepage_menTshirt.click();
	}
	
	public void homepageContinuebtn()
	{
		homepage_continue_btn.click();
	}
	
	public void clickHomepageViewCartbtn()
	{
		homepageViewCartbtn.click();
	}
	
	
}
