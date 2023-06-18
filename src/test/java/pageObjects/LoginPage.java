package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver,JavascriptExecutor js)
    {
  	  super(driver,js);
    }
	
	 //Elements
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmailAddress;
    
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;
    
    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin ;   
    
    
    //Action Methods
    public void setEmail(String email) 
    {
    	txtEmailAddress.sendKeys(email);
    	System.out.println(email);
    }
    
    public void setPassword(String pwd) 
    {
    	txtPassword.sendKeys(pwd);
    	System.out.println(pwd);
    }
    
    public void ClickLogin()
    {
    	btnLogin.click();
    }

	
}
