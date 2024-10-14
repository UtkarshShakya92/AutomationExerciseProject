package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BaseObject{

	public ContactUsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='Get In Touch']")
	WebElement getintouch_txt;
	
	@FindBy(xpath="//input[@data-qa='name']")
	WebElement contact_name_fild;
	
	@FindBy(xpath="//input[@data-qa='email']")
	WebElement contact_email_txt;
	
	@FindBy(xpath="//input[@data-qa='subject']")
	WebElement contact_subject_txt;
	
	@FindBy(id="message")
	WebElement contact_msg;
	
	@FindBy(name="upload_file")
	WebElement browse_btn;
	
	@FindBy(xpath ="//input[@data-qa='submit-button']")
	WebElement submit_btn;
	
	@FindBy(xpath="(//div[text()='Success! Your details have been submitted successfully.'])[1]")
	WebElement cnt_form_success_msg;
	
	@FindBy(xpath="//ul//li//a[@href='/']")
	WebElement home_btn; 
	//Actions =======================================
	
	public boolean getInTouch()
	{
		return getintouch_txt.isDisplayed();
	}
	
	public void contact_Name(String contactname)
	{
		contact_name_fild.sendKeys(contactname);
	}
	
	public void cotact_email(String contactemail)
	{
		contact_email_txt.sendKeys(contactemail);
	}
	
	public void contact_subject(String contactsubject)
	{
		contact_subject_txt.sendKeys(contactsubject);
	}
	
	public void cont_msg(String cntmsg)
	{
		contact_msg.sendKeys(cntmsg);
	}
	
	public void upload(String txtpath)
	{
		browse_btn.sendKeys(txtpath);
	}
	
	public void submit_button()
	{
		submit_btn.click();
	}
	
	public boolean contact_form_success()
	{
		return cnt_form_success_msg.isDisplayed();
	}
	
	
	public void home_btn()
	{
		home_btn.click();
	}
}
