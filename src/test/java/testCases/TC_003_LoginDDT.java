package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
    public void test_loginDDT(String email,String password,String exp)
    {
    	logger.info("**** Starting Tc_003_LoginDDT ");
    	try {
    	    HomePage hp=new HomePage(driver,js);
    	    hp.clickMyAccount();
    	    hp.clickLogin();
    	    
    	    
    	    LoginPage lp=new LoginPage(driver,js);
    	    lp.setEmail(email); 
    	    lp.setPassword(password);
    	    lp.ClickLogin();
    	    
    	    MyAccountPage macc=new MyAccountPage(driver,js);
    	    boolean targetpage=macc.isMyAccountExists();
    	    System.out.println(targetpage);
    	    
    	    if(exp.equals("Valid")) 
    	    {
    	    	if(targetpage==true)
    	    	{
    	    		macc.clickLogout();
    	    		Assert.assertTrue(true);
    	    	}
    	    	
    	    	else
    	    	{
    	    		Assert.assertFalse(false);
    	    	}
    	    		
    	    }
    	    
    	    if(exp.equals("Invalid")) 
    	    {
    	    	if(targetpage==true)
    	    	{
    	    		macc.clickLogout();
    	    		Assert.assertTrue(false);	
    	    	}
    	    	else 
    	    	{
    	    		Assert.assertTrue(true);
    	    	}
    	    }	
    	    
    	}
    	    
    	    catch(Exception e)
    	        {
    	    	Assert.fail();
    	    	}
    	    
    	
    	    logger.info("**** Finished TC_003_LoginDDT");
    	    
    	    
    }
}
