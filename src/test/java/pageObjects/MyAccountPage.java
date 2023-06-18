package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver,JavascriptExecutor js)
    {
  	  super(driver,js);
    }
	
	 //Elements
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement msgHeading;
    
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement lnkLogout;
 
    
    //Action Methods
    public boolean isMyAccountExists() 
    { 
    	try 
    	{
    	return (msgHeading.isDisplayed());
    	}
    	catch(Exception e)
    	{
    		return (false);
    	}
    }
    
    public void clickLogout()
    {
    	lnkLogout.click();
    }
}
