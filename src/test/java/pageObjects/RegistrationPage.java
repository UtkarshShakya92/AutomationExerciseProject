package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BaseObject{

	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		}
	
	//locators  =======================================================
	
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	WebElement userSignUp_txt; 
	
	
	@FindBy(xpath ="//input[@data-qa='signup-name']")
	WebElement userSignUpName_txt_Fld;
	
	@FindBy(xpath ="//input[@data-qa='signup-email']")
	WebElement userSignUpEmail_txt_Fld;
	
	@FindBy(xpath ="//button[@data-qa='signup-button']")
	WebElement signUp_btn;
	
	@FindBy(xpath ="//h2/b[text()='Enter Account Information']")
	WebElement registration_txt;
	
	@FindBy(id ="id_gender1")
	WebElement title_radio_btn;
	
	@FindBy(id ="password")
	WebElement password;
	//Actions 
	
	@FindBy(id="days")
	WebElement days_drp_dwn;
	
	@FindBy(id="months")
	WebElement months_drp_dwn; 
	
	@FindBy(id="years")
	WebElement years_drp_dwn;
	
	@FindBy(id="newsletter")
	WebElement newsletter_rdo_btn;
	
	@FindBy(id="optin")
	WebElement recv_special_offr;
	
	@FindBy(id="first_name")
	WebElement  first_name;
	
	@FindBy(id="last_name")
	WebElement last_name;
	
	@FindBy(id="company")
	WebElement company_name;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="zipcode")
	WebElement zipcode;
	
	@FindBy(id="mobile_number")
	WebElement mobile_number;
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	WebElement create_ac_btn;
	
	@FindBy(xpath = "//h2/b[text()='Account Created!']")
	WebElement account_created_txt;
	
	@FindBy(xpath ="//a[text()='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//ul//li//a//following-sibling::b")
	WebElement login_user_name;
	
	@FindBy(xpath="//ul//li//a[@href='/delete_account']")
	WebElement delete_acc_btn;
	
	
	@FindBy(xpath="//h2/b[text()='Account Deleted!']")
	WebElement acc_dtd_text;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement acc_continue_btn;
	
	
	//Actions===================================================================
	
	public boolean getSignUpmsg()
	{
		return userSignUp_txt.isDisplayed();
	}
	
	public void enterName(String name)
	{
		userSignUpName_txt_Fld.sendKeys(name);
	}
	
	public void enterEmail(String email)
	{
		userSignUpEmail_txt_Fld.sendKeys(email);
	}
	
	public void signupbtnClick()
	{
		signUp_btn.click();
	}
	
	
	public boolean enterSignupPage_msg()
	{
		return registration_txt.isDisplayed();
		//h2/b[text()='Enter Account Information']
	}
	
	public void title()
	{
		title_radio_btn.click();
	}
	
	public void enter_Password(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void day_select(String dayvalue)
	{
		Select selday = new Select(days_drp_dwn);
		selday.selectByValue(dayvalue);
	}
	
	public void month_select(String mnthvalue)
	{
		Select selmonth = new Select(months_drp_dwn);
		selmonth.selectByValue(mnthvalue);
	}
	
	public void years_select(String yrvalue)
	{
		Select selyear = new Select(years_drp_dwn);
		selyear.selectByValue(yrvalue);		
	}
	
	public void newsLetter_box()
	{
		newsletter_rdo_btn.click();
	}
	
	public void special_offer_chk_box()
	{
		recv_special_offr.click();
	}
	
	public void enter_first_name(String fname)
	{
		first_name.sendKeys(fname);	
		}
	
	public void enter_last_name(String lastname)
	{
		last_name.sendKeys(lastname);
	}
	
	public void enter_company_name(String cname)
	{
		company_name.sendKeys(cname);
	}
	
	public void enter_address1(String address)
	{
		address1.sendKeys(address);
	}
	
	
	public void enter_address2(String secaddress)
	{
		address2.sendKeys(secaddress);
	}
	
	public void country_drp_down(String countryName)
	{
		Select selcon = new Select(country);
		selcon.selectByValue(countryName);
	}
	
	public void enter_state(String statename)
	{
		state.sendKeys(statename);
	}
	
	public void enter_city(String cityname)
	{
		city.sendKeys(cityname);
	}
	
	public void enter_zip_code(String zip)
	{
		zipcode.sendKeys(zip);
	}
	
	public void enter_mobile_no(String number)
	{
		mobile_number.sendKeys(number);
	}
	
	public void click_account_btn()
	{
		create_ac_btn.click();
	}
	
	/*public String account_created_msg()
	{
		return account_created_txt.getText();
	}*/
	
	public boolean account_created_msg()
	{
		return account_created_txt.isDisplayed();
	}
	
	public void continue_btn_click()
	{
		btn_continue.click();
	}
	
	public String login_user_name()
	{
		return login_user_name.getText();
	}
	
	public void delete_Account_btn()
	{
		delete_acc_btn.click();
	}
	
	public String delete_account_msg()
	{
		return acc_dtd_text.getText();
	}
	
	public void del_page_conti_btn()
	{
		acc_continue_btn.click();
	}
}
