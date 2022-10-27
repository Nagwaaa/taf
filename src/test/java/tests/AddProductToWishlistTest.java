package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddProductToWishlistPage;
import pages.SearchPage;
import pages.productDetailsPage;

public class AddProductToWishlistTest extends testBase {
	
	
	SearchPage spage;
	productDetailsPage pdpage;
	AddProductToWishlistPage wishpage;
	
	@Test
	public void UserCanSearchWithAutoSuggest() throws InterruptedException
	{
		spage=new SearchPage(testBase.driver);
		pdpage=new productDetailsPage(testBase.driver);
		spage.AutoSuggestSearch("APPLE");
		assertEquals(pdpage.assertSearch.getText(), "Apple MacBook Pro 13-inch");
		driver.switchTo().defaultContent();
		
		
	}

	@Test(dependsOnMethods = {"UserCanSearchWithAutoSuggest"})
	public void UserAddProductInWishlist() throws InterruptedException
	{
		pdpage=new productDetailsPage(testBase.driver);
		pdpage.pressOnAddWishList();
		assertEquals(pdpage.messAssert.getText(), "The product has been added to your wishlist");
		//pdpage.PressOnClose();
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = {"UserAddProductInWishlist"})
	public void UserCanDeleteProduct() throws InterruptedException
	{
		wishpage=new AddProductToWishlistPage(testBase.driver);
		wishpage.pressOnWishlistLink();
		wishpage.PressOnDeleteProduct();
		Thread.sleep(3000);
		assertTrue(wishpage.assertDele.getText().contains("The wishlist is empty"));
	}
}
