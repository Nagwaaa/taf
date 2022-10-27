package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.homePage;
import pages.userLoginPage;
import pages.userRegisterationPage;

public class userRegisterationTest extends testBase{
	
	homePage hpage;
	userRegisterationPage upage;
	userLoginPage lpage;
	
	
	@Test
	public void userCanRegister()
	{
		hpage=new homePage(driver);
		upage=new userRegisterationPage(driver);
		
		hpage.pressOnRegister();
		upage.UserRegister("Nagwa", "Ibrahim", "10", "April", "1994", "noga18@mail.com", "Weelo","nagwa123", "nagwa123");
		assertEquals(upage.mess.getText(),"Your registration completed");
	}
	
	@Test(dependsOnMethods = {"userCanRegister"})
	public void UserCanLogout()
	{
		hpage=new homePage(driver);
		hpage.pressOnLogout();
	}
	
	@Test(dependsOnMethods = {"UserCanLogout"})
	public void UserCanLogin()
	{
		lpage=new userLoginPage(driver);
		hpage=new homePage(driver);
		hpage.pressOnLogin();
		lpage.userLogin("noga18@mail.com", "nagwa123");
		assertTrue(hpage.logout.isDisplayed());
	}
	
	
	@Test(dependsOnMethods = {"UserCanLogin"})
	public void UserCanLogoutAgain()
	{
		hpage=new homePage(driver);
		hpage.pressOnLogout();
	}
	

}
