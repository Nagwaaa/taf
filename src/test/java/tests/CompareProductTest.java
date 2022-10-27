package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.CompareProductPage;
import pages.SearchPage;
import pages.productDetailsPage;


public class CompareProductTest extends testBase{
	
	
	
	SearchPage spage;
	productDetailsPage pdpage;
	CompareProductPage cpage;
	
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
	public void UserCanCompareProduct()
	{
		pdpage=new productDetailsPage(driver);
		pdpage.pressOnCompareProduct();
		pdpage.PressOnClose();
		
	}
	
	@Test(dependsOnMethods = {"UserCanCompareProduct"})
	public void UserCanSearchWithAutoSuggest2() throws InterruptedException
	{
		spage=new SearchPage(driver);
		pdpage=new productDetailsPage(driver);
		spage.AutoSuggestSearch("Asus");
		assertEquals(pdpage.assertSearch.getText(), "Asus N551JK-XO076H Laptop");
		driver.switchTo().defaultContent();
		
		
	}
	
	@Test(dependsOnMethods = {"UserCanSearchWithAutoSuggest2"})
	public void UserCanCompareProduct2() throws InterruptedException
	{
		pdpage=new productDetailsPage(driver);
		cpage=new CompareProductPage(driver);
		pdpage.pressOnCompareProduct();
		pdpage.pressOnComparePage();
		Thread.sleep(3000);
		cpage.PrintRows();
		cpage.ClearProducts();
		Thread.sleep(3000);
		assertEquals(cpage.assertMess.getText(), "You have no items to compare.");
	}

}
