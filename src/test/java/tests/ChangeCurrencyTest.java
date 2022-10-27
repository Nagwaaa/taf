package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ChangeCurrencyPage;

public class ChangeCurrencyTest extends testBase{
	
	
	ChangeCurrencyPage cpage;
	
	@Test
	public void UserCanChangeCurrency() throws InterruptedException
	{
		cpage=new ChangeCurrencyPage(driver);
		cpage.SelectEuroCurrency("Euro");
		Thread.sleep(3000);
		assertTrue(cpage.assertCurr.getText().contains("€"));
	}

}
