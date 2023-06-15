package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reg 
{
	WebDriver driver;
	
	@BeforeClass
public void setup() 
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	driver.manage().window().maximize();
}
    @Test
	public void testReg() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Ananddd");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Royyy");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("AnandRoyyy@gmail.com");
		
		driver.findElement(By.xpath(" //input[@id='input-telephone']")).sendKeys("8499969961");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("AnandRoy");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("AnandRoy");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	String	msg=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
	Assert.assertEquals(msg, "Your Account Has Been Created!");
		
		 
		
		
	}
	 
}
