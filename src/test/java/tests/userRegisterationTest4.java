package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.homePage;
import pages.userLoginPage;
import pages.userRegisterationPage;

public class userRegisterationTest4 extends testBase{
	
	homePage hpage;
	userRegisterationPage upage;
	userLoginPage lpage;
	CSVReader reader;
	
	@Test
	public void userCanRegister() throws CsvValidationException, IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.csv";
		reader = new CSVReader(new FileReader(path));
		
		String [] csvCell;
		
		while((csvCell=reader.readNext())!=null)
		{
			String fname=csvCell[0];
			String lname=csvCell[1];
			String day=csvCell[2];
			String month=csvCell[3];
			String year=csvCell[4];
			String mail=csvCell[5];
			String company=csvCell[6];
			String pass=csvCell[7];
			String pass2=csvCell[8];
			
			
			hpage=new homePage(driver);
			upage=new userRegisterationPage(driver);
			
			hpage.pressOnRegister();
			upage.UserRegister(fname,lname,day,month,year,mail,company,pass,pass2);
			assertEquals(upage.mess.getText(),"Your registration completed");
			hpage.pressOnLogout();
			
			lpage=new userLoginPage(driver);
			hpage.pressOnLogin();
			lpage.userLogin(mail,pass);
			assertTrue(hpage.logout.isDisplayed());
			hpage.pressOnLogout();
			
			
		}
		
		
		
	}
	
	
	
	
	
	

}

