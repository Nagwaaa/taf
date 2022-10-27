package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProductReviewPage extends pageBase{

	public UserProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement title;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement text;
	
	@FindBy(id = "addproductrating_4")
	WebElement rate;
	
	@FindBy(name = "add-review")
	WebElement btnReview;
	
	@FindBy(css = "div.result")
	public WebElement mess;
	
	public void userReviewProduct(String tit,String txt)
	{
		textElements(title, tit);
		textElements(text, txt);
		clickButton(rate);
		clickButton(btnReview);
	}

}
