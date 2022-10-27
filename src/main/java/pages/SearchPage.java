package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends pageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement search;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement btnSearch;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement searchRes;
	
	@FindBy( css="li.ui-menu-item")
	List<WebElement> autoSearch;
	public void AutoSuggestSearch(String ele) throws InterruptedException
	{
		textElements(search, ele);
		Thread.sleep(3000);
		autoSearch.get(0).click();
		
	}
	
	public void UserSearchOnProduct(String ele)
	{
		textElements(search, ele);
		clickButton(btnSearch);
	}
	
	public void pressOnProduct()
	{
		clickButton(searchRes);
	}

}
