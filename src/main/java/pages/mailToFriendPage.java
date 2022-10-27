package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mailToFriendPage extends pageBase {

	public mailToFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement fmail;
	
	@FindBy(id = "PersonalMessage")
	WebElement message;
	
	@FindBy(name = "send-email")
	WebElement btnSend;
	
	@FindBy(css = "div.result")
	public WebElement notif;
	
	public void userSendEmail(String mail,String txt)
	{
		textElements(fmail, mail);
		textElements(message, txt);
		clickButton(btnSend);
	}

}
