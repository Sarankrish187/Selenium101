package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public Properties prop;
	
public WebDriver InitializeBrower() throws IOException
{
	
	prop= new Properties();
   FileInputStream fis = new 	FileInputStream("C:\\Users\\Mahendran C\\eclipse-workspace\\LamdaTest\\src\\Resources\\TestData.properties");
   prop.load(fis);
   String browserName = prop.getProperty("browser");
   if (browserName.equals("Chrome"))
   	{
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahendran C\\eclipse-workspace\\LambdaTest\\Chromedriver\\chromedriver.exe");
	 driver= new ChromeDriver();
   	}
   else if (browserName.equals("firefox"))
   {
	 driver= new FirefoxDriver();
	//firefox code
   }
   else if (browserName.equals("IE"))
   {
	   //	IE code
   }

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;

}
public String RandomString(int length)
{
	 String alphapets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
     StringBuilder randomString = new StringBuilder();
     Random rnd = new Random();
     while (randomString.length() < length) 
     { 
         int index = (int) (rnd.nextFloat() * alphapets.length());
         randomString.append(alphapets.charAt(index));
     }
     String saltStr = randomString.toString();
     return saltStr;
}

public void TakeScreenShort(String fileName) throws IOException
 
{ 
  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  FileUtils.copyFile(src, new File("C:\\Users\\Public\\screenshot.pngs"));
	
}
public void LinkTextClick(String linkTextName)
{
	 driver.findElement(By.linkText(linkTextName)).click();
	 
}
public void mousehoverClick(String linkTextName)
{
	Actions action = new Actions(driver);

	WebElement tab = driver.findElement(By.linkText(linkTextName));
	action.moveToElement(tab).perform();
	tab.click();
	
	//driver.findElement(By.linkText(linkTextName)).click();
	 
}

public boolean verifyContent(String contentmessage)
{
	try {
		driver.getTitle().contains(contentmessage);
		//log.info("Content is  matched"); 
		return true;
	}
	catch (Exception e) {
		//log.info("Content is not matched"); 
		return false;
	}
	}
public void addValueByID(String message, String id)
{
	 driver.findElement(By.id(id)).sendKeys(message);
}

public void clickBtnByXpath(String xpath)
{
	 driver.findElement(By.xpath(xpath)).click();
}

public String getTextByXpath(String xpath)
{
	String s= driver.findElement(By.xpath(xpath)).getText();
	return s;
}

public void selectValueinDropDown(String value, String name)
{
	Select element = new Select(driver.findElement(By.name(name)));
	element.selectByVisibleText(value);
}


public String getContainsValue(String value)
{
	WebElement  ele = driver.findElement(By.xpath("//*[contains (text (),'"+ value +"')]"));
	String s = ele.getText();
	return s;
}


	
	 


}
