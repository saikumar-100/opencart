package testCases;
import pageObjects.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass
{
    @Test
	public void test_account_Registration() 
	
	{   
    	logger.debug("application logs....");
    	logger.info("*** Starting TC_001_AccountRegistrationTest");
		try {
			
		HomePage hp=new HomePage(driver,js);
		hp.clickMyAccount();
		logger.info("clicke on my account link");
		hp.clickRegister();
		logger.info("clicke on my registration link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver,js);
		logger.info("providing customer data");
		String first_name=randomeString().toUpperCase();
		regpage.setFirstName(first_name);
		
		String last_name=randomeString().toUpperCase();
		regpage.setLastName(last_name);
		
		String email=randomeString()+"@gmail.com";
		System.out.println(email);
		regpage.setEmail(email);
		
		String telephone=randomeNumber();
		System.out.println(telephone);
		regpage.setTelephone(telephone);
		
		
		
		String pwd=randomAlphaNumeric();
		regpage.setPassword(pwd);
		regpage.setConfirmPassword(pwd);
		
		regpage.setSubscribe();
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("clicked on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("validating expected message");
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("*** finished TC_001_AccountRegestrationTest");
	}
	
}
