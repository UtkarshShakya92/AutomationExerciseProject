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
	
	//home page left side category visible
	@FindBy(id="accordian")
	WebElement categories;
	
	//home women category + click
	@FindBy(xpath="//a[@href='#Women']//i")
	WebElement clickWomencategory;
	
	//Women category ---Dress
	@FindBy(xpath ="//a[@href='/category_products/1']")
	WebElement dresscategory;
	
	//verify for women -dress category
	
	@FindBy(xpath="//h2[text()='Women - Dress Products']")
	WebElement womendressproduct;
	
	//product category page men +sign
	
	@FindBy(xpath="//a[@href='#Men']//span//i")
	WebElement clickMenCategory;
	
	//clciking jeans 
	
	@FindBy(xpath="//a[@href='/category_products/6']")
	WebElement clickJeans;
	
	//verifying  the men category 
	@FindBy(xpath="//div[@class='features_items']//h2[text()='Men - Jeans Products']")
	WebElement jeans_display;
	
	//action 
	
	//Automation Exercise-- title 
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	
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
	
	//homepage left side category
	
	public boolean categoryDisplay()
	{
		return categories.isDisplayed();
	}
	
	
	//home page Women+ click
	public void womenCategory()
	{
		clickWomencategory.click();
	}
	
	//women category--Dress
	
	public void clickDress()
	{
		dresscategory.click();
	}
	
	//verify for "Women Dress -Products"
	public boolean verifyWomenDressProduct()
	{
		wait.until(ExpectedConditions.visibilityOf(womendressproduct));
		
		return womendressproduct.isDisplayed();
	}
	
	//products category page men link
	public void clickMenCategory()
	{
		clickMenCategory.click();
	}
	
	public void clickJeansProducts()
	{
		clickJeans.click();
	}
	
	public boolean displayMenReqProd()
	{
		wait.until(ExpectedConditions.visibilityOf(jeans_display));
		return jeans_display.isDisplayed();
	}
}
