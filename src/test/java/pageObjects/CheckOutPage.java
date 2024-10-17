package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BaseObject{

	public CheckOutPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//ul[@id='address_delivery']//li/following-sibling::li")
	List<WebElement> delivery_address;
	
	@FindBy(xpath="//ul[@id='address_invoice']//li/following-sibling::li")
	List<WebElement> billing_address;
	
	@FindBy(xpath="(//p[@class='cart_total_price'])[3]")
	WebElement cart_Total_Amount;
	
	@FindBy(xpath="//textarea[@name='message']")
	WebElement msg_area;
	
	@FindBy(xpath="//a[@href='/payment']")
	WebElement payment_btn;
	
	
	//==========================================================
	
	public void sizeofaddress()
	{
		System.out.println(delivery_address.size());
	}
	
	
	public List<String> getAddressDelivery()
	{
		List<String> addressDelivery = new ArrayList<String>(); 
		
		for(int i=0;i<delivery_address.size();i++)
		{
			 addressDelivery.add(delivery_address.get(i).getText());
			
		}
		
		return addressDelivery; 
	}
	
	public List<String> getAddressBilling()
	{
		
		List<String> addressBilling = new ArrayList<String>();
		
		for(int i=0;i<billing_address.size();i++)
		{
		     addressBilling.add(billing_address.get(i).getText());
		}
		
		return addressBilling;
	}
	
	
	
}
