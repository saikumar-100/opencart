package pageObjects;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRegistrationPage extends BasePage
{
	
  public AccountRegistrationPage(WebDriver driver,JavascriptExecutor js)
  {
	  super(driver,js);
  }
  
 
  
  //Elements
  @FindBy(name="firstname")
  WebElement txtFirstname;
  
  @FindBy(name="lastname")
  WebElement txtLastname;
  
  @FindBy(name="email")
  WebElement txtEmail ;
  
  
  @FindBy(name="telephone")
  WebElement txtTelephone ;
  
  @FindBy(name="password")
  WebElement txtPassword;
  
  
  @FindBy(name="confirm")
  WebElement txtconfirm; 
 
 @FindBy(name="newsletter")
 WebElement radSubscribe;
 
  
  @FindBy(name="agree")
  WebElement chkdPolicy;
  
  @FindBy(xpath="//input[@value='Continue']")
  WebElement btwContinue;
  
  @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
  WebElement msgConfirmation;

  
  
  
  public void setFirstName(String fname)
  {
	  txtFirstname.sendKeys(fname);
  }
  
  public void setLastName(String lname)
  {
	  txtLastname.sendKeys(lname);
  }
  
  public void setEmail(String email)
  {
	  txtEmail.sendKeys(email);
  }
  
  public void setTelephone(String telephone)
  {
	  txtTelephone.sendKeys(telephone);
  }
  
  public void setPassword(String pwd)
  {
	  txtPassword.sendKeys(pwd);
  }
  
  public void setConfirmPassword(String pwd)
  {
	  txtconfirm.sendKeys(pwd);
  }
  
  public void setSubscribe()
  {
	
	  radSubscribe.click();

  }
  
  public void setPrivacyPolicy()
  {
	  chkdPolicy.click(); 
  }
  
  public void clickContinue() 
  {
	  btwContinue.click();
	  
  }
  
  public String getConfirmationMsg()
  {
	  try 
	  {
		return ( msgConfirmation.getText());
	  }
	  catch(Exception e)
	  {
		  return (e.getMessage());
	  }
  }
}
