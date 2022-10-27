package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import pages.SearchPage;
import pages.productDetailsPage;

public class ProductTest extends testBase{
	
	
	SearchPage srpage;
	productDetailsPage pdpage;
	
	@Test
	public void UserCanSearch()
	{
		srpage=new SearchPage(driver);
		pdpage=new productDetailsPage(driver);
		srpage.UserSearchOnProduct("Apple MacBook Pro 13-inch");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		srpage.pressOnProduct();
		assertTrue(pdpage.assertSearch.getText().contains("Apple MacBook Pro 13-inch"));
	}

}
