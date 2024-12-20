package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BaseObject{

	
	public ProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath="//h2[text()='All Products']")
	WebElement all_product_txt;
	
	@FindBy(xpath="//div[@class='brands-name']//ul//li//a")
	
	List<WebElement>  brandList;
	
	@FindBy(xpath="//div[@class='choose']//ul//li//a[@href='/product_details/1']")
	WebElement first_view_product_btn;
	
	@FindBy(xpath="//div[@class='product-information']//h2[text()='Blue Top']")
	WebElement product_name;
	
	@FindBy(xpath="//div[@class='product-information']//h2/following-sibling::p[1]")
	WebElement category;
	
	@FindBy(xpath="//span/span")
	WebElement price;
	
	@FindBy(xpath="(//div[@class='product-information']//p)[2]")
	WebElement availability;
	
	@FindBy(xpath="(//div[@class='product-information']//p)[3]")
	WebElement condition;
	
	@FindBy(xpath="(//div[@class='product-information']//p)[4]")
	WebElement brand;
	
	@FindBy(id="search_product")
	WebElement searchbox;
	
	@FindBy(id="submit_search")
	WebElement submit;
	
	@FindBy(xpath="//div[@class='features_items']//div[@class='productinfo text-center']//p")
	List<WebElement> search_elements;
	
	////div[@class='features_items']//div[@class='col-sm-4']//div[@class='productinfo text-center']//p
	//Searched products add to cart
	
	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4']//div[@class='productinfo text-center']//a")
	List<WebElement> search_element_addToCartbtn;
	
	@FindBy(xpath="//div[@class='features_items']//h2[text()='Searched Products']")
	WebElement searchedProduct;
	
	//test 12 : Hover over first product and click 'Add to cart'
	
	@FindBy(xpath="//div[@class='productinfo text-center']//p[text()='Blue Top']")
	WebElement hoverTobluetop;
	
	@FindBy(xpath="(//a[@data-product-id='1'])[2]")
	WebElement first_product_add_cart_btn;
	
	//6. Click 'Continue Shopping' button
	@FindBy(css=".modal-content .btn")
	WebElement continue_btn;
	
	//7. Hover over second product and click 'Add to cart'
	
	@FindBy(xpath="//div[@class='productinfo text-center']//p[text()='Men Tshirt']")
	WebElement hoverToSecondProduct;
	
	@FindBy(xpath="(//a[@data-product-id='2'])[2]")
	WebElement second_Product_Add_cart_btn;
	
	//click View Cart btn
	
	@FindBy(xpath="//div[@class='modal-body']//p//a[@href='/view_cart']")
	WebElement viewCartbtn;
	
	//Click Cart Button
	
	@FindBy(xpath="//a[@href='/view_cart']")
	WebElement cartBtn;
	
	//4th product perticular page 
	
	@FindBy(xpath="//div[@class='product-information']//h2")
	WebElement fourthProductPage; 
	
	
	//input or increase quantity to 4
	
	@FindBy(id="quantity")
	WebElement fourthproductquantity; 
	
	@FindBy(css =".cart")
	WebElement forthproductPage_AddCart_btn;
	
	//verify madame page is displayed
	
	@FindBy(xpath="//h2[text()='Brand - Madame Products']")
	WebElement madametitle;   
	
	@FindBy(xpath="//h2[text()='Brand - Biba Products']")
	WebElement bibatitle;
	
	//view product bt of 7th product inn product page
	
	@FindBy(xpath="//a[@href='/product_details/7']")
	WebElement seventhProductViewbtn;
	
	//verify write review text is present
	
	@FindBy(xpath="//a[text()='Write Your Review']")
	WebElement writeReview;
	
	//review name fld
	
	@FindBy(id="name")
	WebElement insertReviewerName;
	
	//reviewer email
	
	@FindBy(id="email")
	WebElement insertReviewerEmail;
	
	@FindBy(id="review")
	WebElement enterReviewtxt; 
	
	@FindBy(id="button-review")
	WebElement reviewSubmitbtn;
	
	@FindBy(xpath="//div[@class='alert-success alert']//span")
	WebElement review_success_alert;
	
	//==============================================
	
	Actions act =new Actions(driver);
	
	public boolean all_Product()
	{
		return all_product_txt.isDisplayed();
	}
	
	public boolean brand_List()
	{
		return brandList.isEmpty();
	}
	
	public void  madame_brandproductselect()
	{
		for(int i=0;i<brandList.size();i++)
		{
			System.out.println(brandList.get(i).getText());
			if(brandList.get(i).getText().contains("MADAME"))
			{
				brandList.get(i).click();
				break;
			}
			
		}
	}
	
	//verify madame title
	public boolean madametitleverify()
	{
		mywait.until(ExpectedConditions.visibilityOf(madametitle));
		
		return madametitle.isDisplayed();//bibatitle
	}
	
	public void  biba_brandproductselect()
	{
		for(int i=0;i<brandList.size();i++)
		{
			System.out.println(brandList.get(i).getText());
			if(brandList.get(i).getText().contains("BIBA"))
			{
				brandList.get(i).click();
				break;
			}
			
		}
	}
	
	public boolean bibatitleverify()
	{
		
		driver.navigate().refresh();
		mywait.until(ExpectedConditions.visibilityOf(bibatitle));
		
		return bibatitle.isDisplayed();
	}
	
	public void first_product_view_btn()
	{
		first_view_product_btn.click();
	}
	
	public String first_Product_Page_Title()
	{
		return driver.getTitle();
	}
	
	public boolean product_name()
	{
		return product_name.isDisplayed();
	}
	
	public boolean category()
	{
		return category.isDisplayed();
	}
	
	public String  pricing()
	{
		return price.getText();
	}
	
	public String availavilityOfProduct()
	{
		return availability.getText();
	}
	
	public String product_condition()
	{
		return condition.getText();
	}
	
	public String product_brand()
	{
		return brand.getText();
	}
	
	public void searchBox(String input)
	{
		searchbox.sendKeys(input);
	}
	
	public void submitbtn()
	{
		submit.click();
	}
	
	//Verify 'SEARCHED PRODUCTS' is visible
	
	public boolean searchProducttext()
	{
		return searchedProduct.isDisplayed();
	}
	
	
	//Verify all the products related to search are visible
	public boolean  searchElements(String expectedtext)
	{
		
		for(WebElement ele:search_elements)
		{
			
		    if(!ele.getText().toLowerCase().contains(expectedtext))
		    {
		    	return false;
		    }
		}	
		
		return true;
		
	}
	
	//Verify all the products related to search are visible and add them to cart respectively
	
	public void clickAddtoCartSearchedProductList()
	{
		for(int i=0; i<search_element_addToCartbtn.size();i++)
		{
			search_element_addToCartbtn.get(i).click();
			continue_btn.click();
		}
	}
	
	
	
	
	//Actions to mouse hover add to cart and click 
	
	
	public void hoverOverFirstProduct()
	{
		act.moveToElement(hoverTobluetop).build().perform();
	}
	
	WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public void mouseHoverFirstProductandClick()
	{
		mywait.until(ExpectedConditions.visibilityOf(first_product_add_cart_btn));
		//act.moveToElement(first_product_add_cart_btn).click().build().perform();
		js.executeScript("arguments[0].click()",first_product_add_cart_btn);
	}
	
	
	public void continue_button()
	{
		continue_btn.click();
	}
	
	
	public void javaScriptScroll(String scrollto)
	{
		js.executeScript(scrollto);
	}
	
	public void hover_over_Second_Product()
	{
		act.moveToElement(hoverToSecondProduct).build().perform();
	}
	
	public void secondProductAddClick()
	{
		mywait.until(ExpectedConditions.visibilityOf(second_Product_Add_cart_btn));
		//act.moveToElement(first_product_add_cart_btn).click().build().perform();
		js.executeScript("arguments[0].click()",second_Product_Add_cart_btn);
	}
	
	
	public void click_view_Cart_btn()
	{
		viewCartbtn.click();
	}
	
	public void click_Cart_Btn()
	{
		cartBtn.click();
	}
	
	// to verify fourth Product page is visible or not
	
	public String productfourthPage()
	{
		mywait.until(ExpectedConditions.visibilityOf(fourthProductPage));
		return fourthProductPage.getText();
	}
	
	//to increase quatity to 4
	
	public void increase_product_quantity(String quantity)
	{
		fourthproductquantity.clear();
		fourthproductquantity.sendKeys(quantity);
	}
	
	//fourth page add cart btn
	
	public void fourth_page_add_Cart_btn()
	{
		forthproductPage_AddCart_btn.click();
	}
	
	//aal product page 7th product view btn
	
	public void madameTopseventhProduct()
	{
		seventhProductViewbtn.click();
	}
	
	
	public boolean writeReviewheading()
	{
		return writeReview.isDisplayed();
	}
	
	//Review name fld
	
	public void reviewerName(String name)
	{
		insertReviewerName.sendKeys(name);
	}
	
	public void reviewerEmail(String reviewEmai)
	{
		insertReviewerEmail.sendKeys(reviewEmai);
	}
	
	public void enterReviewtxtfld(String reviewtxt)
	{
		enterReviewtxt.sendKeys(reviewtxt);
		
	}
	
	public void reviewSubmitbtn()
	{
		reviewSubmitbtn.click();
	}
	
	public String reviewSuccess_AlertMsg()
	{
		return review_success_alert.getText();
	}
}
