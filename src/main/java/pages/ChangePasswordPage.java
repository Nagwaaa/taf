package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends pageBase{

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePass;
	
	@FindBy(id = "OldPassword")
	WebElement oldPass;
	
	@FindBy(id = "NewPassword")
	WebElement newPass;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement cnewPass;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement btnChange;
	
	@FindBy(css = "p.content")
	public WebElement mess;
	
	@FindBy(css = "span.close")
	WebElement close;
	
	public void pressOnChangePassword()
	{
		clickButton(changePass);
	}
	
	public void pressOnClose()
	{
		clickButton(close);
	}
	
	public void UserChangePassword(String oldp,String npass,String cpass)
	{
		textElements(oldPass, oldp);
		textElements(newPass, npass);
		textElements(cnewPass, cpass);
		clickButton(btnChange);
	}

}
