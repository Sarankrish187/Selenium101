package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Resources.BaseClass;

public class LandingPage 
{
	public WebDriver driver;
BaseClass bs = new BaseClass();

public LandingPage(WebDriver driver)
{
	this.driver = driver;
}
	public LandingPage() {
	// TODO Auto-generated constructor stub
}
	public void clickSimpleFormDemo()
	{
		bs.mousehoverClick("Simple Form Demo");
	}
	public void clickinputForSubmit()
	{
		bs.mousehoverClick("Input Form Submit");
	}
	
	public boolean verifyURLcontent(String message)
	{
		boolean status = bs.verifyContent(message);
		return status;
	}
	public void sendMessage(String message)
	{
		bs.addValueByID(message, "user-message");
	}
	
	public void clickGetCheckedValueBtn()
	{
		bs.clickBtnByXpath("//*[@id='showInput']");
	}
	public String getYourMessage()
	{
		String yourmessage = bs.getTextByXpath("//*[@id='user-message']//p[@id='message']");
		return yourmessage;
	}
	
	public void sendName(String username)
	{
		bs.addValueByID(username, "name");
	}
	
	public void clickFormSubmitBtn()
	{
		bs.clickBtnByXpath("//*[@id=\"seleniumform\"]//button");
	}
	public void sendEmail(String emailname)
	{
		bs.addValueByID(emailname, "inputEmail4");
	}
	
	public void sendpassword(String password)
	{
		bs.addValueByID(password, "inputPassword4");
	}
	
	public void sendCompanyName(String company)
	{
		bs.addValueByID(company, "company");
	}
	
	public void sendWebsiteName(String website)
	{
		bs.addValueByID(website, "websitename");
	}

	public void sendCity(String city)
	{
		bs.addValueByID(city, "inputCity");
	}
	public void sendState(String state)
	{
		bs.addValueByID(state, "inputState");
	}
	
	public void sendAddress1(String add1)
	{
		bs.addValueByID(add1, "inputAddress1");
	}
	
	public void sendAddress2(String add2 )
	{
		bs.addValueByID(add2, "inputAddress2");
	}
	
	public void sendZipCode(String zip)
	{
		bs.addValueByID(zip, "inputZip");
	}
	
	public void selectCountry(String country )
	{
		bs.selectValueinDropDown(country, "country");
	}
	
	public boolean getValueAfterFormSubmit()
	{
		String s= "Thanks for contacting us, we will get back to you shortly.";
		bs.getContainsValue(s);
		return true;
	}
	
	public void verifyInvalidSubmit()
	{
		String s= "Please fill out this field.";
		clickFormSubmitBtn();
		Assert.assertEquals (s,bs.getContainsValue(s));
		
	}
	
	public boolean verifyValidSubmit(String name, String email, String password, String company, String website, String country,String city, String add1,String add2, String state, String zip   )
	{
		sendName(name);
		sendEmail(email);
		sendpassword (password);
		sendCompanyName(company);
		sendWebsiteName(website);
		sendCity(city);
		sendState(state);
		sendAddress1(add1);
		sendAddress2(add2);
		selectCountry(country);
		clickFormSubmitBtn();
		 boolean s = getValueAfterFormSubmit();
		 return s;
		
			
	}
	
	














































}
