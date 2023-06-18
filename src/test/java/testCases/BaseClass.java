package testCases;

import java.time.Duration;
import java.util.ResourceBundle;
import java.io.File;
import java.text.*;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.TakesScreenshot;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public JavascriptExecutor js;
	public Logger logger;//for logging
	public ResourceBundle rb;
	
   @BeforeClass
   @Parameters("browser")
  public void setup(String br) 
   {
	   //https://tutorialsninja.com/demo/index.php?route=account/register
	   rb=ResourceBundle.getBundle("config");//load config.properties file
	  // WebDriverManager.chromedriver().setup(); //from selenium 4.6.0 webdriver manager is not needed 
	   
	   //ChromeOptions options = new ChromeOptions();
	   //options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	   if(br.equals("chrome"))
	   {
	   driver = new ChromeDriver();  //options
	   }
	   else
	   {
		   driver= new EdgeDriver();
	   }
	  
	   js=(JavascriptExecutor)driver;
	   
	   logger=LogManager.getLogger(this.getClass());//logging
	   
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   
	   driver.get(rb.getString("appURL"));
	   driver.manage().window().maximize();
   }
  @AfterClass
  public void tearDown() 
   {
	   driver.quit();
   }
   
   public String randomeString() 
   {
	   String generatedString = RandomStringUtils.randomAlphabetic(5);
	   return (generatedString);
   }
   
   public String randomeNumber() 
   {
	   String generatedString2 = RandomStringUtils.randomNumeric(10);
	   return (generatedString2);
   }
   public String randomAlphaNumeric() 
   {
	   String st= RandomStringUtils.randomAlphabetic(3);
	   String num = RandomStringUtils.randomNumeric(4);
	   return (st+"@"+num);
   }

   public String captureScreen(String tname)
   {
	   //How to generate time stamp?
	   //SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhss");
	   //Date dt=new Date();
	   //String timestamp=df.format(dt);
	   
	   String timestamp=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
	   
	   TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
	   File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	   String destination = System.getProperty("user.dir")+"\\screenshots\\"+tname+"-"+ timestamp +".png";
	   
	   try
	   {
		   FileUtils.copyFile(source,new File(destination));
	   }
	   catch(Exception e)
	   {
		   e.getMessage();
	   }
	   return destination;
   }
   
   
   
	
}
