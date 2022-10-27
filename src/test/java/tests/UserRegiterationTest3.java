package tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.homePage;
import pages.userLoginPage;
import pages.userRegisterationPage;

public class UserRegiterationTest3 extends testBase{
	
	homePage hpage;
	userRegisterationPage upage;
	userLoginPage lpage;
	Faker fake=new Faker();
	String fname=fake.name().firstName();
	String lname=fake.name().lastName();
	String mail=fake.internet().emailAddress();
	String pass=fake.number().digits(8);
	
	@Test
	public void userCanRegister()
	{
		hpage=new homePage(driver);
		upage=new userRegisterationPage(driver);
		
		hpage.pressOnRegister();
		upage.UserRegister(fname,lname,"10","April","2020",mail,"wello",pass,pass);
		assertEquals(upage.mess.getText(),"Your registration completed");
		System.out.println("UserData "+fname +" "+lname+" "+mail+" "+pass);
	}
	
	@Test(dependsOnMethods = {"userCanRegister"})
	public void UserCanLogout()
	{
		hpage=new homePage(driver);
		hpage.pressOnLogout();
	}
	
	@Test(dependsOnMethods = {"UserCanLogout"})
	public void UserCanLogin()
	{
		lpage=new userLoginPage(driver);
		hpage=new homePage(driver);
		hpage.pressOnLogin();
		lpage.userLogin(mail, pass);
		assertTrue(hpage.logout.isDisplayed());
	}
	
	
	@Test(dependsOnMethods = {"UserCanLogin"})
	public void UserCanLogoutAgain()
	{
		hpage=new homePage(driver);
		hpage.pressOnLogout();
	}
	

}
