package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.LandingPage;
import Resources.BaseClass;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GMainPageTest extends BaseClass
{
	@BeforeTest
	public void initialize() throws IOException
	{
	 driver =InitializeBrower();
	}
	
	 LandingPage landPage = new LandingPage(driver);
     BaseClass bs = new BaseClass();
 	  LandingPage ls = new LandingPage();
	
	@Test
	public void testScenairo1()throws IOException
	{
      
     
  	  
  	  String userMessage = "lamdaTest";
  	  
      driver.get(prop.getProperty("url"));
      ls.clickSimpleFormDemo();
      Assert.assertTrue(ls.verifyURLcontent("simple-form-demo"));
      
      ls.sendMessage(userMessage);
      ls.clickGetCheckedValueBtn();
      //assert.assertTrue(condition, message);ls.getYourMessage()
      assertEquals(userMessage, ls.getYourMessage());
     
     
     
 
       
	}
	
	@Test
	public void TestScenairo3()throws IOException
	{
		
		String username = "TEST";
		String emailId  =  "Test@gmail.com";
		String password = "TEST@123";
		String company  = "TEST COMPANY";
		String website  = "TEST WEBSITE";
		String country  = "FR";
		String State    = "TN";
		String address1 = "Address1";
		String address2 = "Address2";
		String city     = "City";
		String zipcode   = "12345";
		
		driver.get(prop.getProperty("url"));
		ls.clickinputForSubmit();
		ls.verifyInvalidSubmit();
		Assert.assertTrue(ls.verifyValidSubmit(username,emailId,password,company,website,country,State,address1,address2,city,zipcode));
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
	
}
