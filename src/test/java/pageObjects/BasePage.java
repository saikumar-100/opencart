package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{
WebDriver driver;
JavascriptExecutor js;
public BasePage(WebDriver driver,JavascriptExecutor js)
    {
	  this.driver=driver;
	  this.js=js;
	  PageFactory.initElements(driver, this);
	}
}
