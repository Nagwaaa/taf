package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.SearchPage;
import pages.UserProductReviewPage;
import pages.homePage;
import pages.productDetailsPage;
import pages.userRegisterationPage;

public class userProductReviewTest extends testBase{
	
	
	
	homePage hpage;
	userRegisterationPage upage;
	SearchPage spage;
	productDetailsPage pdpage;
	UserProductReviewPage prpage;
	
	@Test
	public void userCanRegister()
	{
		hpage=new homePage(driver);
		upage=new userRegisterationPage(driver);
		
		hpage.pressOnRegister();
		upage.UserRegister("Nagwa", "Ibrahim", "10", "April", "1994", "nog19@mail.com", "Weelo","nagwa123", "nagwa123");
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
	public void UserCanReivewProduct()
	{
		pdpage=new productDetailsPage(driver);
		pdpage.pressOnReviewProduct();
		prpage=new UserProductReviewPage(driver);
		prpage.userReviewProduct("review 10", "this product is very nice");
		assertEquals(prpage.mess.getText(),"Product review is successfully added.");
		
	}
	
	
	@Test(dependsOnMethods = {"UserCanReivewProduct"})
	public void UserCanLogout()
	{
		hpage=new homePage(driver);
		hpage.pressOnLogout();
	}

}
