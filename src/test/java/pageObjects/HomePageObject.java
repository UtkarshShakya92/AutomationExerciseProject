package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends BaseObject {

	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	// locator

	@FindBy(xpath = "//a[@href='/login']")
	WebElement linkLoginAndSignup;

	@FindBy(xpath = "//div[@class='col-sm-8']//li//a[text()=' Logged in as ']")
	WebElement login_msg;

	@FindBy(xpath = "//ul//li//a[@href='/logout']")
	WebElement logoutbtn;

	@FindBy(xpath = "//ul//li//a[@href='/contact_us']")
	WebElement contactusbtn;

	@FindBy(xpath = "//ul//li//a[@href='/products']")
	WebElement products_btn;

	@FindBy(css = ".single-widget h2")
	WebElement subscription;

	@FindBy(id = "susbscribe_email")
	WebElement subscription_txt_fld;

	@FindBy(id = "subscribe")
	WebElement subscribe_btn;

	@FindBy(id = "success-subscribe")
	WebElement alert_subscribe_msg;

	@FindBy(xpath = "//ul//li//a[@href='/view_cart']")
	WebElement cart_btn;

	@FindBy(xpath = "//a[@href='/product_details/4']")
	WebElement fourthProductView_btn;

	/// test case 14 : for adding products from home page to cart

	@FindBy(xpath = "(//a[@data-product-id='1'])[1]")
	WebElement homepage_bluetop;

	@FindBy(xpath = "(//a[@data-product-id='2'])[1]")
	WebElement homepage_menTshirt;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	WebElement homepage_continue_btn;

	@FindBy(xpath = "//a[@href='/view_cart']//u")
	WebElement homepageViewCartbtn;

	// home page left side category visible
	@FindBy(id = "accordian")
	WebElement categories;

	// home women category + click
	@FindBy(xpath = "//a[@href='#Women']//i")
	WebElement clickWomencategory;

	// Women category ---Dress
	@FindBy(xpath = "//a[@href='/category_products/1']")
	WebElement dresscategory;

	// verify for women -dress category

	@FindBy(xpath = "(//div[@class='features_items']//h2)[1]")
	WebElement womendressproduct;

	// product category page men +sign

	@FindBy(xpath = "//a[@href='#Men']//span//i")
	WebElement clickMenCategory;

	// clciking jeans

	@FindBy(xpath = "//a[@href='/category_products/6']")
	WebElement clickJeans;

	// verifying the men category
	@FindBy(xpath = "(//div[@class='features_items']//h2)[1]")
	WebElement jeans_display;

	//  recommended items txt
	@FindBy(xpath = "//div[@class='recommended_items']//h2[contains(.,'recommended')]")
	WebElement recommendItemsTxt;

	// Products in recommended section

	@FindBy(xpath = "//div[@id='recommended-item-carousel']//div[@class='col-sm-4']")
	List<WebElement> recomProducts;

	//Recommended right arrow click
	@FindBy(xpath="(//i[@class='fa fa-angle-right'])[2]")
	WebElement recommeditemrightcoroArrow;
	
	//login as user name
	
	@FindBy(xpath="//ul//li//a//following-sibling::b")
	WebElement login_user_name;
	
	//delete account name 
	@FindBy(xpath="//ul//li//a[@href='/delete_account']")
	WebElement delete_acc_btn;
	
	//Account deleted text
	@FindBy(xpath="//h2/b[text()='Account Deleted!']")
	WebElement acc_dtd_text;
	//deletepage continue btn 
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement acc_continue_btn;
	
	//HomePage ScrollUp to Top button
	
	@FindBy(xpath="//a[@id='scrollUp']")
    WebElement scrollToTopBtn;	
	
	//
	
	@FindBy(xpath="(//div[@id='slider-carousel']//div[@class='carousel-inner']//h2)[1]")
	WebElement fullfledgedtext;
	
	//Test cases btn
	
	@FindBy(xpath="//div[@class='col-sm-8']//a[@href='/test_cases']")
	WebElement testCasebtn; 
	
	//testCases page verify
	@FindBy(xpath="//section[@id='form']//h2//b[text()='Test Cases']")
	WebElement testcasestxt;

	// action

	// Automation Exercise-- title

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void linkLoginAndSignClick() {
		linkLoginAndSignup.click();
	}

	// login msg
	public String confirm_Login_Msg() {
		try {
			return (login_msg.getText());
		}

		catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void logoutbtn() {
		logoutbtn.click();
	}

	public void contact_us_btn() {
		contactusbtn.click();
	}

	public void product_btn() {
		products_btn.click();
	}

	public String subscription_Msg() {
		return subscription.getText();
	}

	public void subscription_fld(String subsemail) {
		subscription_txt_fld.sendKeys(subsemail);
	}

	public void subscription_button() {
		subscribe_btn.click();
	}

	public String success_subscribe_alert() {
		return alert_subscribe_msg.getText();
	}

	public void click_Cart_btn() {
		cart_btn.click();
	}

	public void click_fourth_view_product_btn() {
		fourthProductView_btn.click();
	}

	/// test case 14 : for adding products from home page to cart

	public void home_page_BlueTop_Product() {
		homepage_bluetop.click();
	}

	public void home_page_menTshirt_Product() {

		wait.until(ExpectedConditions.visibilityOf(homepage_menTshirt));
		homepage_menTshirt.click();
	}

	public void homepageContinuebtn() {
		homepage_continue_btn.click();
	}

	public void clickHomepageViewCartbtn() {
		homepageViewCartbtn.click();
	}

	// homepage left side category

	public boolean categoryDisplay() {
		return categories.isDisplayed();
	}

	// home page Women+ click
	public void womenCategory() {
		clickWomencategory.click();
	}

	// women category--Dress

	public void clickDress() {
		dresscategory.click();
	}

	// verify for "Women Dress -Products"
	public String verifyWomenDressProduct() {
		wait.until(ExpectedConditions.visibilityOf(womendressproduct));

		return womendressproduct.getText();
	}

	// products category page men link
	public void clickMenCategory() {
		clickMenCategory.click();
	}

	public void clickJeansProducts() {
		clickJeans.click();
	}

	public String displayMenReqProd() {
		wait.until(ExpectedConditions.visibilityOf(jeans_display));
		return jeans_display.getText();
	}

	public void homePageScrollToLast() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", recommendItemsTxt);
	}
	
	public void homePageScrollTofirstProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public String recommendedtxt() {
		return recommendItemsTxt.getText();
	}

	public void recommendedProductsclick() {
		// boolean carousel;
		for (int i = 1; i <=recomProducts.size(); i++) {
			WebElement addToCartBtn = driver.findElement(By.xpath(
					"//div[@id='recommended-item-carousel']//div[@class='col-sm-4']//a[@data-product-id=" + i + "]"));

			if (i == 4)
			{
				recommeditemrightcoroArrow.click();
			}
			wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
			addToCartBtn.click();

			homepage_continue_btn.click();
		}

	}
	
	//====login as text
	public String login_user_name()
	{
		return login_user_name.getText();
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
	
	public void scrollTotopBtn()
	{
		scrollToTopBtn.click();
	}
	
	public String verifyFullfledgedTex()
	{
		wait.until(ExpectedConditions.visibilityOf(fullfledgedtext));
		return fullfledgedtext.getText();
	}
	
	public void clickTestCasebtn()
	{
		testCasebtn.click();
	}
	
	public boolean  verifyTestCasestxtintestcasesPage()
	{
		return testcasestxt.isDisplayed();
	}
}
