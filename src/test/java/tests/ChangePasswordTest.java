package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.ChangePasswordPage;
import pages.homePage;
import pages.userLoginPage;
import pages.userRegisterationPage;

public class ChangePasswordTest extends testBase {
	
	 homePage hpage;
	 userRegisterationPage upage;
	 ChangePasswordPage cpage;
	 userLoginPage lpage;
	@Test
	public void userCanRegister()
	{
		hpage=new homePage(driver);
		upage=new userRegisterationPage(driver);
		
		hpage.pressOnRegister();
		upage.UserRegister("Nagwa", "Ibrahim", "10", "April", "1994", "noga30@mail.com", "Weelo","nagwa123", "nagwa123");
		assertEquals(upage.mess.getText(),"Your registration completed");
	}
	
	@Test(dependsOnMethods = {"userCanRegister"})
	public void UserCanChangePassword()
	{
		hpage=new homePage(driver);
		cpage=new ChangePasswordPage(driver);
		hpage.pressOnMyaccount();
		cpage.pressOnChangePassword();
		cpage.UserChangePassword("nagwa123", "nagwa1", "nagwa1");
		assertEquals(cpage.mess.getText(), "Password was changed");
		cpage.pressOnClose();
		
	}
	
	@Test(dependsOnMethods = {"UserCanChangePassword"})
	public void UserCanLogout()
	{
		hpage=new homePage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", hpage.logout);
	}
	
	@Test(dependsOnMethods = {"UserCanLogout"})
	public void UserCanLogin()
	{
		lpage=new userLoginPage(driver);
		hpage=new homePage(driver);
		hpage.pressOnLogin();
		lpage.userLogin("noga30@mail.com", "nagwa1");
		assertTrue(hpage.logout.isDisplayed());
	}
	
	@Test(dependsOnMethods = {"UserCanLogin"})
	public void UserCanLogoutAgain()
	{
		hpage=new homePage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", hpage.logout);
	}

}
