package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.SearchPage;
import pages.productDetailsPage;

public class SearchAutoSugestTest extends testBase{
	
	
	SearchPage spage;
	productDetailsPage pdpage;
	
	@Test
	public void UserCanSearchWithAutoSuggest() throws InterruptedException
	{
		spage=new SearchPage(driver);
		pdpage=new productDetailsPage(driver);
		spage.AutoSuggestSearch("apple");
		assertEquals(pdpage.assertSearch.getText(), "Apple MacBook Pro 13-inch");
		driver.switchTo().defaultContent();
		
		
	}

}
