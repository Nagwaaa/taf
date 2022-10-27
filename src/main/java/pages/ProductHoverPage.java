package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductHoverPage extends pageBase {

	public ProductHoverPage(WebDriver driver) {
		super(driver);
		action=new Actions(driver);
	}
	
	
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement comp;
	
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']")
    WebElement note;
	
	public void userMakeProductHover()
	{
		makeAction(comp,note);
	}

}
