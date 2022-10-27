package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUserCheckoutPage extends pageBase{

	public RegisterUserCheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "termsofservice")
	WebElement checkAgree;
	
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	
	
	public void pressOnAgreeButton()
	{
		clickButton(checkAgree);
	}
	
	public void pressOnCheckoutButton()
	{
		clickButton(checkOutBtn);
	}

}
