package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userLoginPage extends pageBase{

	public userLoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "Email")
	WebElement mail;
	
	@FindBy (id = "Password")
	WebElement pass;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement btnlogin;

	public void userLogin(String mal,String passw)
	{
		textElements(mail, mal);
		textElements(pass, passw);
		clickButton(btnlogin);
	}
}
