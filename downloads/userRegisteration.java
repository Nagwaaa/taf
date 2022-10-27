package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import pages.userRegisterationPage;
import tests.testBase;

public class userRegisteration extends testBase {
	
	homePage hpage;
	userRegisterationPage upage;
	@Given("the user in home page")
	public void the_user_in_home_page() {
		
		hpage=new homePage(driver);
		hpage.pressOnRegister();
	    
	}
	@When("i click on register link")
	public void i_click_on_register_link() {
	    assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("i entered {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void i_entered(String fname, String lname, String day, String month, String year, String mail, String com, String pass, String cpass) {
	    
		upage=new userRegisterationPage(driver);
		upage.UserRegister(fname, lname, day, month, year, mail, com, pass, cpass);
		
	}
	@Then("user registeration page is display")
	public void user_registeration_page_is_display() {
	    hpage=new homePage(driver);
	    hpage.pressOnLogout();
	}

}
