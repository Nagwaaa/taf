package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.CheckoutDetailsPage;
import pages.RegisterUserCheckoutPage;
import pages.SearchPage;
import pages.homePage;
import pages.productDetailsPage;
import pages.userLoginPage;
import pages.userRegisterationPage;

public class RegisterUserCheckoutTest extends testBase{
	
	
	homePage hpage;
	userRegisterationPage upage;
	userLoginPage lpage;
	SearchPage spage;
	productDetailsPage pdpage;
	RegisterUserCheckoutPage regpage;
	CheckoutDetailsPage detpage;
	
	
	
	@Test
	public void userCanRegister()
	{
		hpage=new homePage(driver);
		upage=new userRegisterationPage(driver);
		
		hpage.pressOnRegister();
		upage.UserRegister("Nagwa", "Ibrahim", "10", "April", "1994", "noga20@mail.com", "Weelo","nagwa123", "nagwa123");
		assertEquals(upage.mess.getText(),"Your registration completed");
	}
	
	@Test(dependsOnMethods = {"userCanRegister"})
	public void UserCanSearchWithAutoSuggest() throws InterruptedException
	{
		spage=new SearchPage(driver);
		pdpage=new productDetailsPage(driver);
		spage.AutoSuggestSearch("apple");
		assertEquals(pdpage.assertSearch.getText(), "Apple MacBook Pro 13-inch");
		driver.switchTo().defaultContent();
		
		
	}
	
	@Test(dependsOnMethods = {"UserCanSearchWithAutoSuggest"})
	public void UserCanAddToCart() throws InterruptedException
	{
		pdpage=new productDetailsPage(driver);
		pdpage.pressOnShopingCart();
		pdpage.pressOnCartPage();
		Thread.sleep(3000);
	}
	
	
	@Test(dependsOnMethods = {"UserCanAddToCart"})
	public void UserCanCheckout()
	{
		regpage=new RegisterUserCheckoutPage(driver);
		regpage.pressOnAgreeButton();
		regpage.pressOnCheckoutButton();
	}
	
	@Test(dependsOnMethods = {"UserCanCheckout"})
	public void UserCanViewDetalis() throws InterruptedException
	{
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
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = {"UserCanViewDetalis"})
	public void UserCanLogout()
	{
		hpage=new homePage(driver);
		hpage.pressOnLogout();
	}
	
	
	
	
	
	

}
