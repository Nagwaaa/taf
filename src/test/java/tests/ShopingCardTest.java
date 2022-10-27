package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.SearchPage;
import pages.ShopingCardPage;
import pages.productDetailsPage;

public class ShopingCardTest extends testBase {
	
	
	SearchPage spage;
	productDetailsPage pdpage;
	ShopingCardPage cpage;
	
	@Test
	public void UserCanSearchWithAutoSuggest() throws InterruptedException
	{
		spage=new SearchPage(driver);
		pdpage=new productDetailsPage(driver);
		spage.AutoSuggestSearch("apple");
		assertEquals(pdpage.assertSearch.getText(), "Apple MacBook Pro 13-inch");
		driver.switchTo().defaultContent();
		
		
	}
	
	@Test(dependsOnMethods = {"UserCanSearchWithAutoSuggest"})
	public void UserCanAddToCart() throws InterruptedException
	{
		pdpage=new productDetailsPage(driver);
		pdpage.pressOnShopingCart();
		pdpage.pressOnCartPage();
		Thread.sleep(3000);
	}
	
	
	

}
