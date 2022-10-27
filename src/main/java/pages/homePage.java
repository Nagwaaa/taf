package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends pageBase{

	public homePage(WebDriver driver) {
		super(driver);
		js=(JavascriptExecutor) driver;
	}
	
	@FindBy(linkText = "Register")
	WebElement register;
	
	
	@FindBy(linkText = "Log in")
	WebElement login;
	
	@FindBy(linkText = "Log out")
	public WebElement logout;
	
	@FindBy(linkText = "My account")
	WebElement myaccount;
	
   public void pressOnRegister()
   {
	   clickButton(register);
   }
   
   public void pressOnLogin()
   {
	   clickButton(login);
   }
   
   public void pressOnLogout()
   {
	   clickButton(logout);
   }
   
   public void pressOnMyaccount()
   {
	   clickButton(myaccount);
   }
   
  
}
