package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BaseObject{
	
	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	@FindBy(xpath="//div//h2[text()='Subscription']")
	WebElement subscription_txt;

	@FindBy(id="susbscribe_email")
	WebElement subscribe_email_txt_fld;
	
	@FindBy(id="subscribe")
	WebElement subs_click_btn;
	
	@FindBy(id="success-subscribe")
	WebElement subs_alert_msg;
	
	//12: verfiy products in cart 
	
	@FindBy(id="product-1")
	List<WebElement> firstProductsDetails;
	
	@FindBy(id="product-2")
	List<WebElement> secondProductsDetails;
	
	//fourth product view at cart with quantity 4
	
	@FindBy(xpath="//td [@class='cart_quantity']//button")
	WebElement productfourthquantity;
	
	//===============================================
	
	public boolean subscription_msg()
	{
		return subscription_txt.isDisplayed();
	}
	
	
	public void  insert_Subscription_email_id(String email)
	{
		subscribe_email_txt_fld.sendKeys(email);
	}
	
	
	public void subscription_click_btn()
	{
		subs_click_btn.click();
	}
	
	public String subscription_alert()
	{
		return subs_alert_msg.getText();
	}
	
	public String firstProduct()
	{
		String fp =" ";
		for(int i=0;i<firstProductsDetails.size();i++)
		{
			fp = firstProductsDetails.get(i).getText();
			
		}
		
		return fp;
		
	}
	
	public String secondProduct()
	{
		String sp =" ";
		for(int i=0;i<secondProductsDetails.size();i++)
		{
			sp = secondProductsDetails.get(i).getText();
			//Assert.assertTrue(secondProductsDetails.get(i).getText().contains(map.get(2)));
		}
		
		return sp;
		
	}

	//verify fourth product quntity in cart
	
	public String getfouthProductQuantity()
	{
		return productfourthquantity.getText();
	}
	
}
