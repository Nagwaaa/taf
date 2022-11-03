package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class testBase2 {
	
	public static String BaseUrl="https://demo.nopcommerce.com/";
	
	public ThreadLocal<RemoteWebDriver> driver=null;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String bname) throws MalformedURLException
	{
		driver=new ThreadLocal<>();
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("browserName", bname);
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
		System.out.println("Title is "+getDriver().getTitle());
		getDriver().get(BaseUrl);
		
		
	}
	
	public WebDriver getDriver()
	{
		 return driver.get();
	}
	
	@AfterClass
	public void closeDreiver()
	{
		getDriver().quit();
		driver.remove();
		
		
	}
	
	@AfterMethod
	public void TakeScreenOnFailure(ITestResult res) throws IOException
	{
		
		if(res.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Failed..");
			System.out.println("Taking screenshot...!");
			Helper.CaptureScreenshot(getDriver(), res.getName());
			
		}
	}

}
