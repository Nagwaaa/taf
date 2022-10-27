package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeCurrencyPage extends pageBase{

	public ChangeCurrencyPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "customerCurrency")
	WebElement sele;
	
	@FindBy(css = "span.price.actual-price")
	public WebElement assertCurr;
	
	
	public void SelectEuroCurrency(String currency)
	{
		SelectElement(sele,currency);
	}

}
