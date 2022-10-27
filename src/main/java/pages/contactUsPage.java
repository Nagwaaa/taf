package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contactUsPage extends pageBase {

	public contactUsPage(WebDriver driver) {
		super(driver);
		 
	}
	
	@FindBy(id = "FullName")
	WebElement name;
	
	@FindBy(id = "Email")
	WebElement mail;
	
	@FindBy(linkText = "Contact us")
	WebElement contact;
	
	@FindBy(id = "Enquiry")
	WebElement enq;
	
	@FindBy(name = "send-email")
	WebElement btnSend;
	
	@FindBy(css = "div.result")
	public WebElement mess;
	
	public void UserContactUs(String nam,String mal,String txt)
	{
		textElements(name, nam);
		textElements(mail, mal);
		textElements(enq, txt);
		clickButton(btnSend);
	}
	
	public void pressOnContact()
	{
		clickButton(contact);
	}
	
	public void scroll()
	{
		ScrollToButtom();
	}

}
