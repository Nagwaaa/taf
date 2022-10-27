package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutDetailsPage extends pageBase {

	public CheckoutDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement selectCountry;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zip;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phone;
	
	@FindBy(name = "save")
	WebElement save;

	@FindBy(id = "shippingoption_1")
	WebElement ship1;
	
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement btnCount;
	
	@FindBy(id = "paymentmethod_1")
	WebElement pay1;
	
	@FindBy(id = "CardholderName")
	WebElement hname;
	
	@FindBy(id = "CardNumber")
	WebElement cnum;
	
	@FindBy(id = "ExpireMonth")
	WebElement mon;
	
	@FindBy(id = "ExpireYear")
	WebElement year;
	
	@FindBy(id = "CardCode")
	WebElement CardCode;
	
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement cont;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirm;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement orderDet;
	
	@FindBy(linkText = "PDF Invoice")
	WebElement pdf;
	
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement payy;
	
	public void DownloadInvoice()
	{
		clickButton(pdf);
	}
	
	
	public void OrderDetails()
	{
		clickButton(orderDet);
	}
	
	public void confirmOrder()
	{
		clickButton(confirm);
	}
	

	
	public void paymentCard(String name,String num,String mo,String ye,String cod)
	{
		textElements(hname, name);
		textElements(cnum, num);
		SelectElement(mon, mo);
		SelectElement(year, ye);
		textElements(CardCode, cod);
		clickButton(cont);
	}
	
	public void payment()
	{
		clickButton(pay1);
		clickButton(payy);
	}
	
	public void shippingMethod()
	{
		clickButton(ship1);
		clickButton(btnCount);
	}
	
	public void billingAddress(String country,String cit,String addre,String zp,String ph)
	{
		SelectElement(selectCountry, country);
		textElements(city, cit);
		textElements(address, addre);
		textElements(zip, zp);
		textElements(phone, ph);
		clickButton(save);
	}
}
