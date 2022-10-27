package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class testBase extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;
	public static String dowPath=System.getProperty("user.dir")+"\\downloads\\";
	
	public static ChromeOptions chromOp()
	{
		ChromeOptions option=new ChromeOptions();
		HashMap<String, Object> chromePrefs=new HashMap<String, Object>();
		//chromePrefs.put("profile.defult.content_setting.popups", 0);
		chromePrefs.put("download.default_directory", dowPath);
		option.setExperimentalOption("prefs", chromePrefs);
		return option;
		
	}
	
	@BeforeSuite
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver(chromOp());
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@AfterMethod
	public void TakeScreenOnFailure(ITestResult res) throws IOException
	{
		
		if(res.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Failed..");
			System.out.println("Taking screenshot...!");
			Helper.CaptureScreenshot(driver, res.getName());
			
		}
	}
	
	@AfterTest
	public void timeToSleep()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterClass
	public void timeOutt()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}

}
