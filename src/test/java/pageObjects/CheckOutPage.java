package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BaseObject{

	public CheckOutPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//ul[@id='address_delivery']//li")
	List<WebElement> delivery_address;
	
	@FindBy(id="address_invoice")
	List<WebElement> billing_address;
	
	@FindBy(xpath="(//p[@class='cart_total_price'])[3]")
	WebElement cart_Total_Amount;
	
	@FindBy(xpath="//textarea[@name='message']")
	WebElement msg_area;
	
	@FindBy(xpath="//a[@href='/payment']")
	WebElement payment_btn;
	
	
	//==========================================================
	
	public String[] getAddressDelivery()
	{
		String addressDelivery = "";
		
		for(int i=0;i<delivery_address.size();i++)
		{
			addressDelivery = delivery_address.get(i).getText();
		}
		
		return addressDelivery; 
	}
}
