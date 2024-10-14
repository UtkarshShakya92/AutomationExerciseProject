package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseObject{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='Login to your account']")
	WebElement login_to_account_txt;
	
   @FindBy(xpath="//form//input[@data-qa='login-email']")
   WebElement txt_loginEmail; 
   
   @FindBy(xpath="//form//input[@data-qa='login-password']")
   WebElement txt_password;
   
   @FindBy(xpath="//button[text()='Login']")
   WebElement btn_login;
   
   @FindBy(xpath="//form[@action='/login']//p[text()='Your email or password is incorrect!']")
   WebElement invalid_email_pwd_msg;
  /* 
   @FindBy(xpath="//div[@class='col-sm-8']//li//a[text()=' Logged in as ']")
   WebElement login_msg;
   */
   
   //Actions =============================================================
   
   public boolean loginAccountmsg()
   {
	   return  login_to_account_txt.isDisplayed();
   }
			   
   public void loginEmail(String email)
   {
	   txt_loginEmail.sendKeys(email);
   }
	
   public void loginPassword(String pwd)
   {
	   txt_password.sendKeys(pwd);
   }
   
   public void clickLoginBtn()
   {
	   btn_login.click();
   }
   
   public boolean invalid_email_pwd_text()
   {
	   return invalid_email_pwd_msg.isDisplayed();
   }

  /* public String confirm_Login_Msg()
   {
	   try {
	   return (login_msg.getText());
	   }
	   
	   catch(Exception e)
	   {
		   return(e.getMessage());
	   }
   }*/
   
}
