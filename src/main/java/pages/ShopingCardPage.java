package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopingCardPage extends pageBase {

	public ShopingCardPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(tagName = "tr")
	List<WebElement>rows;
	
	@FindBy(tagName = "td")
	List<WebElement>cols;
	
	@FindBy(id = "updatecart")
	WebElement update;
	
	@FindBy(id = "itemquantity11868")
	WebElement qan;
	public void editQuantity(String q)
	{
		qan.clear();
		textElements(qan, q);
		clickButton(update);
		
		
	}

}
