package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.SearchPage;
import pages.homePage;
import pages.mailToFriendPage;
import pages.productDetailsPage;
import pages.userRegisterationPage;

public class mailToFriendTest extends testBase{
	
	mailToFriendPage mpage;
	productDetailsPage pdpage;
	homePage hpage;
	userRegisterationPage upage;
	SearchPage spage;
	
	@Test
	public void userCanRegister()
	{
		hpage=new homePage(driver);
		upage=new userRegisterationPage(driver);
		
		hpage.pressOnRegister();
		upage.UserRegister("Nagwa", "Ibrahim", "10", "April", "1994", "noga012@mail.com", "Weelo","nagwa123", "nagwa123");
		assertEquals(upage.mess.getText(),"Your registration completed");
	}
	
	
	@Test(dependsOnMethods = {"userCanRegister"})
	public void UserCanSearchWithAutoSuggest() throws InterruptedException
	{
		spage=new SearchPage(driver);
		pdpage=new productDetailsPage(driver);
		spage.AutoSuggestSearch("apple");
		assertEquals(pdpage.assertSearch.getText(), "Apple MacBook Pro 13-inch");
		driver.switchTo().defaultContent();
		
		
	}
	
	@Test(dependsOnMethods = {"UserCanSearchWithAutoSuggest"})
	public void UserCanSendMessage()
	{
		mpage=new mailToFriendPage(driver);
		pdpage=new productDetailsPage(driver);
		pdpage.pressOnSendMail();
		mpage.userSendEmail("nga@mail.com", "this is nice product");
		assertEquals(mpage.notif.getText(), "Your message has been sent.");
	}
	
	@Test(dependsOnMethods = {"UserCanSendMessage"})
	public void UserCanLogout()
	{
		hpage=new homePage(driver);
		hpage.pressOnLogout();
	}

}
