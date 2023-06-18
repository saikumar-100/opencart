package testCases;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_002_LoginTest extends BaseClass
{
    @Test
	public void test_login()
	{
    	try
    	{
		logger.info("*****starting TC_002_LoginTest ******");
	
    
    HomePage hp=new HomePage(driver,js);
    hp.clickMyAccount();
    logger.info("clicked on My Account");
    
    hp.clickLogin();
    logger.info("clicked on Login Link");
    
    LoginPage lp=new LoginPage(driver,js);
    logger.info("providing login details");
    
    lp.setEmail(rb.getString("email")); //valid email, get if from config.properties file
    lp.setPassword(rb.getString("password"));//valid password , get it from config.properties file
    lp.ClickLogin();
    logger.info("Providing login details");
    
    MyAccountPage macc=new MyAccountPage(driver,js);
    boolean targetpage=macc.isMyAccountExists();
    Assert.assertEquals(targetpage, true,"Invalid login data");
    	}
    	catch(Exception e)
    	{
    		Assert.fail();
    	}
    	logger.info("**** finished TC_002_loginTest");
	}
    
}
