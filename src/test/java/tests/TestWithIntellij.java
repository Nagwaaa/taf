package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestWithIntellij {

    private WebDriver driver;

    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void TestGoogle()
    {
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle() ,"Nagwa");
    }

    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }
}
