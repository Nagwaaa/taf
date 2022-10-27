package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutDetailsPage;
import pages.RegisterUserCheckoutPage;
import pages.SearchPage;
import pages.homePage;
import pages.productDetailsPage;
import pages.userLoginPage;
import pages.userRegisterationPage;
import tests.testBase;

public class end2endCycle extends testBase{
	
	
	homePage hpage;
	userRegisterationPage upage;
	userLoginPage lpage;
	SearchPage spage;
	productDetailsPage pdpage;
	RegisterUserCheckoutPage regpage;
	CheckoutDetailsPage detpage;
	
	
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
	
	
	@When("i search")
	public void i_search() throws InterruptedException {
		
		spage=new SearchPage(driver);
		pdpage=new productDetailsPage(driver);
		spage.AutoSuggestSearch("apple");
		assertEquals(pdpage.assertSearch.getText(), "Apple MacBook Pro 13-inch");
		driver.switchTo().defaultContent();
	   
	}
	@When("i can add to cart")
	public void i_can_add_to_cart() {
		
		pdpage=new productDetailsPage(driver);
		pdpage.pressOnShopingCart();
		pdpage.pressOnCartPage();
	  
	}
	@When("i can checkout product")
	public void i_can_checkout_product() throws InterruptedException {
		
		regpage=new RegisterUserCheckoutPage(driver);
		regpage.pressOnAgreeButton();
		regpage.pressOnCheckoutButton();
		
		String currentWindow=driver.getWindowHandle();
		detpage=new CheckoutDetailsPage(driver);
		detpage.billingAddress("Egypt", "Giza", "Dokki", "0125","01024558745");
		Thread.sleep(2000);
		detpage.shippingMethod();
		driver.switchTo().window(currentWindow);
		Thread.sleep(3000);
		detpage.payment();
		Thread.sleep(3000);
		detpage.paymentCard("Nagwa", "4895048571632081", "04", "2027", "458");
		detpage.confirmOrder();
		detpage.OrderDetails();
		detpage.DownloadInvoice();
	 
	}
	@Then("user buy laptop")
	public void user_buy_laptop() {
	    hpage.pressOnLogout();
	}
	
	
	}
