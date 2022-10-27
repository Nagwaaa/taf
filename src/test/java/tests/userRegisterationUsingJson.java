package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonReader;
import pages.SearchPage;
import pages.UserProductReviewPage;
import pages.homePage;
import pages.productDetailsPage;
import pages.userLoginPage;
import pages.userRegisterationPage;

public class userRegisterationUsingJson extends testBase{
	
	
	
	homePage hpage;
	userRegisterationPage upage;
	SearchPage spage;
	productDetailsPage pdpage;
	UserProductReviewPage prpage;
	userLoginPage lpage;
	JsonReader reader;
	
	@Test
	public void userCanRegister() throws FileNotFoundException, IOException, ParseException
	{
		reader=new JsonReader();
		reader.readerFromJson();
		hpage=new homePage(driver);
		upage=new userRegisterationPage(driver);
		
		hpage.pressOnRegister();
		upage.UserRegister(reader.fname,reader.lname,reader.day, reader.mon, reader.year, reader.mail,reader.com,reader.pass, reader.cpass);
		assertEquals(upage.mess.getText(),"Your registration completed");
		
		hpage.pressOnLogout();
		
		lpage=new userLoginPage(driver);
		hpage=new homePage(driver);
		hpage.pressOnLogin();
		lpage.userLogin(reader.mail, reader.pass);
		assertTrue(hpage.logout.isDisplayed());
		
		hpage.pressOnLogout();
	}
	
	

}






