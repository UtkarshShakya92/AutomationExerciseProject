package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage extends BaseObject{
	
	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	@FindBy(xpath="//div[@class='breadcrumbs']//ol//li//following-sibling::li")
	WebElement shoppingCartTxt;
	
	@FindBy(xpath="//a[text()='Proceed To Checkout']")
	WebElement checkOutbtn;
	
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
	
	//Checkoutpage Register loginbtn
	
	@FindBy(xpath="//a/u[text()='Register / Login']")
	WebElement registerLoginbtn;
	
	//firstproductremove
	
	@FindBy(xpath="//a[@data-product-id='1']")
	WebElement firstproductremove;
	
	//second Product Remove
	
	@FindBy(xpath="//a[@data-product-id='2']")
	WebElement secondProductremove;
	
	//empty Cart 
	
	@FindBy(xpath="//span//p/b[text()='Cart is empty!']")
	WebElement emptyCart;
	
	//CartProducts verify by name 
	
	@FindBy(xpath="//table//tbody//td[2]//h4//a")
	List<WebElement> searchRelatedProcutsinCart;
	
	//click login btn
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement loginBtn; 
	
	//===============================================
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
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
	
	
	//verify that you are in Cart Page
	
	public String  verify_Cart_Page()
	{
		return shoppingCartTxt.getText();
	}
	
	public void click_CheckOut_btn()
	{
		checkOutbtn.click();
	}
	
	public void click_RegisterLogin_btn()
	{
		registerLoginbtn.click();
	}
	
	public void remove_first_Product()
	{
		firstproductremove.click();
	}
	
	public void remove_second_Product()
	{
		secondProductremove.click();
	}
	
	public boolean emptyCartmsg()
	{
		wait.until(ExpectedConditions.visibilityOf(emptyCart));
		return emptyCart.isDisplayed();
	}
	
	
	//verifying products in cart while searching the products
	public boolean productsInCart(String expectedproducts)
	{
		for(int i=0;i<searchRelatedProcutsinCart.size();i++)
		{
			if(!searchRelatedProcutsinCart.get(i).getText().toLowerCase().contains(expectedproducts))
			{
				return false;
			}
			
			
		}
		return true;
				
	}
	
	//clicking signup/Login button
	public void clickLogin_signUp_Btn()
	{
		loginBtn.click();
	}
	
	//Products in cart to verify with their name
	
	public List<String> getCartProducts()
	{
		List<String> cartProducts = new ArrayList<String>();
		
		for(int i=0;i<searchRelatedProcutsinCart.size();i++)
		{
			cartProducts.add(searchRelatedProcutsinCart.get(i).getText());
		}
		
		return cartProducts;
	}
}
