package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productDetailsPage extends pageBase{

	public productDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement comparelink;
	
	@FindBy(css = "strong.current-item")
	public WebElement assertSearch;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement sendMail;
	
	@FindBy(linkText = "Add your review")
	WebElement review;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement wishLink;
	
	@FindBy(css = "p.content")
	public WebElement messAssert;
	
	@FindBy(css = "span.close")
	WebElement close;
	
	@FindBy(linkText = "product comparison")
	WebElement comlink;
	
	@FindBy(id ="add-to-cart-button-4")
	WebElement cartBtn;
	
	@FindBy(linkText = "shopping cart")
	WebElement gotocart;
	
	public void pressOnCartPage() {
		clickButton(gotocart);
	}
	
	public void pressOnShopingCart()
	{
		clickButton(cartBtn);
	}
	
	public void pressOnComparePage()
	{
		clickButton(comlink);
	}
	
	public void pressOnCompareProduct()
	{
		clickButton(comparelink);
	}
	
	public void PressOnClose()
	{
		clickButton(close);
	}
	
	public void pressOnAddWishList()
	{
		clickButton(wishLink);
	}
	
	public void pressOnReviewProduct()
	{
		clickButton(review);
	}
	
	public void pressOnSendMail()
	{
		clickButton(sendMail);
	}

}
