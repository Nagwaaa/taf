package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.homePage;
import pages.userLoginPage;
import pages.userRegisterationPage;

public class UserRegisterationTest2 extends testBase{
	
	homePage hpage;
	userRegisterationPage upage;
	userLoginPage lpage;
	
	
	@DataProvider(name="userdata")
	public static Object[][] UserData()
	{
	    return new Object[][] {
	    	{"Nagwa","Ibrahim","10","April","2020","nog101@mail.com","wello","noga123"},{"Nada","Sayed","20","April","2022","nog20@mail.com","lacasacode","noga123"},
	    	{"Sara","Ibrahim","10","April","2020","soso@mail.com","wello","noga123"}
	    };
	}
	
	@Test(dataProvider = "userdata")
	public void userCanRegister(String fname,String lname,String day,String mon,String year,String mail,String com,String pass)
	{
		hpage=new homePage(driver);
		upage=new userRegisterationPage(driver);
		
		hpage.pressOnRegister();
		upage.UserRegister(fname,lname,day, mon, year,mail, com,pass, pass);
		assertEquals(upage.mess.getText(),"Your registration completed");
		hpage.pressOnLogout();
		
		lpage=new userLoginPage(driver);
		hpage.pressOnLogin();
		lpage.userLogin(mail,pass);
		assertTrue(hpage.logout.isDisplayed());
		
		hpage.pressOnLogout();
	}
	

}
