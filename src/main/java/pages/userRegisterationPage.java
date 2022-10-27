package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userRegisterationPage extends pageBase {

	public userRegisterationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "gender-female")
	WebElement gender;
	
	@FindBy(id = "FirstName")
	WebElement firstname;
	
	@FindBy(id = "LastName")
	WebElement lastname;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement day;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement month;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement year;
	
	@FindBy(name = "Email")
	WebElement email;
	
	@FindBy(name = "Company")
	WebElement company;
	
	@FindBy(id = "Newsletter")
	WebElement check;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(id = "ConfirmPassword")
	WebElement conPassword;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement mess;
	
	public void UserRegister(String fname,String lname,String da,String mo,String ye,String mail,String com,String pass,String cpass)
	{
		clickButton(gender);
		textElements(firstname, fname);
		textElements(lastname, lname);
		SelectElement(day, da);
		SelectElement(month, mo);
		SelectElement(year, ye);
		textElements(email, mail);
		textElements(company, com);
		clickButton(check);
		textElements(password, pass);
		textElements(conPassword, cpass);
		clickButton(registerBtn);
	}
	

}
