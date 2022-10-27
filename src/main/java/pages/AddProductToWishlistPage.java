package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToWishlistPage extends pageBase {

	public AddProductToWishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "wishlist")
	WebElement wish;
	
	@FindBy(css = "td.remove-from-cart")
	WebElement dele;
	
	@FindBy(css = "div.no-data")
	public WebElement assertDele;
	
	public void PressOnDeleteProduct()
	{
		clickButton(dele);
	}
	
	public void pressOnWishlistLink()
	{
		clickButton(wish);
	}

}
