package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.contactUsPage;
import pages.homePage;

public class contactUsTest extends testBase{
	
	
	
	homePage hpage;
	contactUsPage conPage;
	
	@Test
	public void UserCanContactUs()
	{
		hpage=new homePage(driver);
		conPage=new contactUsPage(driver);
		
		hpage.ScrollToButtom();
		conPage.pressOnContact();
		conPage.UserContactUs("Nagwa Ibrahim","noga@mail.com","this product is very bad");
		assertEquals(conPage.mess.getText(), "Your enquiry has been successfully sent to the store owner.");
		
		
	}

}
