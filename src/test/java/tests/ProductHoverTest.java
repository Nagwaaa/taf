package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.ProductHoverPage;

public class ProductHoverTest extends testBase{
	
	
	
	ProductHoverPage hovpage;
	
	@Test
	public void UserCanMakeHover() throws InterruptedException
	{
		hovpage=new ProductHoverPage(driver);
		hovpage.userMakeProductHover();
		assertTrue(driver.getCurrentUrl().contains("notebooks"));
		Thread.sleep(3000);
	}

}
