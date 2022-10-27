package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductPage extends pageBase {

	public CompareProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.clear-list")
	WebElement clear;
	
	@FindBy(css = "div.no-data")
	public WebElement assertMess;
	
	@FindBy(tagName = "tr")
	List<WebElement>rows;
	
	@FindBy(tagName = "td")
	List<WebElement>cols;
	
	public void PrintRows()
	{
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}
			for (WebElement col : cols) {
				System.out.println(col.getText());
			}
	}
	
	public void ClearProducts()
	{
		clickButton(clear);
	}
	

}
