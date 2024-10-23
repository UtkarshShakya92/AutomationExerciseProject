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
	
	@FindBy(xpath="//div[@id='cart_info']//tbody//tr//h4//a")
	List<WebElement> checkoutPageProducts;
	
	@FindBy(xpath="(//p[@class='cart_total_price'])[3]")
	WebElement cart_Total_Amount;
	
	@FindBy(xpath="//textarea[@name='message']")
	WebElement msg_area;
	
	@FindBy(xpath="//a[@href='/payment']")
	WebElement payment_btn;
	
	
	@FindBy(xpath="//ul//li//a[@href='/delete_account']")
	WebElement delete_acc_btn;
	
	//Account deleted text
	@FindBy(xpath="//h2/b[text()='Account Deleted!']")
	WebElement acc_dtd_text;
	//deletepage continue btn 
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement acc_continue_btn;
	
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
	
	public List<String> getCheckoutProducts()
	{
		List<String> checkoutProducts = new ArrayList<String>();
		
		for(int i=0;i<checkoutPageProducts.size();i++)
		{
			checkoutProducts.add(checkoutPageProducts.get(i).getText());
		}
		
		return checkoutProducts;
	}
	
	public String productsTotalAmount()
	{
		return cart_Total_Amount.getText();
	}
	
	public void message_text_area(String msgtext)
	{
		msg_area.sendKeys(msgtext);
	}
	
	public void clickPlaceOrderBtn()
	{
		payment_btn.click();
	}
	
	//delete account btn
		public void delete_Account_btn()
		{
			delete_acc_btn.click();
		}
		
		//delete page delete text
		public String delete_account_msg()
		{
			return acc_dtd_text.getText();
		}
		
		//delete page continue btn
		public void del_page_conti_btn()
		{
			acc_continue_btn.click();
		}
	
}
