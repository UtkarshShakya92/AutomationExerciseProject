package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BaseObject{

	public PaymentPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@data-qa='name-on-card']")
	WebElement nameOnCard;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement cardNumber;
	
	@FindBy(xpath="//input[@name='cvc']")
	WebElement cvcNumber;
	
	@FindBy(xpath="//input[@name='expiry_month']")
	WebElement expiryMonth;
	
	@FindBy(xpath="//input[@name='expiry_year']")
	WebElement expiryYear;
	
	@FindBy(id="submit")
	WebElement payandsubmitbtn;
	
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']//h2/following-sibling::p")
	WebElement orderplacedmsg;
	
	@FindBy(xpath="//a[@href='/delete_account']")
	WebElement deleteAccountbtn;
	
	@FindBy(xpath="//h2[@data-qa='account-deleted']/following-sibling:: p[text()='Your account has been permanently deleted!']")
	WebElement deleteAcmsg;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement clickContinuebtn;
	
	//====================================================
	
	public void enternameOnCard(String cardname)
	{
		nameOnCard.sendKeys(cardname);
	}
	
	public void enterCardNumber(String cardnumber)
	{
		cardNumber.sendKeys(cardnumber);
	}
	
	public void enterCvcNumber(String cvc)
	{
		cvcNumber.sendKeys(cvc);
	}
	
	public void enterExpiryMonth(String expirymonth)
	{
		expiryMonth.sendKeys(expirymonth);
	}
	
	public void enterExpiryYear(String expiryyear)
	{
		expiryYear.sendKeys(expiryyear);
	}
	
	public void clickPayandSubmit()
	{
		payandsubmitbtn.click();
	}
	
	public String orderSuccessMsg()
	{
		
		return orderplacedmsg.getText();
	}
	
	public void clickDeletebtn()
	{
		deleteAccountbtn.click();
	}
	
	public boolean deleteAcDisplay()
	{
		return deleteAcmsg.isDisplayed();
	}
	
	public void clickContinuebtn()
	{
		clickContinuebtn.click();
	}
	
}
