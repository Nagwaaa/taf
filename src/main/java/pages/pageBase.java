package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageBase {
	
	public static WebDriver driver;
	public JavascriptExecutor js;
	public Actions action;
	
	public pageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickButton(WebElement ele)
	{
		ele.click();
	}
	
	
	public void textElements(WebElement ele,String txt)
	{
		ele.sendKeys(txt);
	}

	public void SelectElement(WebElement ele,String txt)
	{
		Select select=new Select(ele);
		select.selectByVisibleText(txt);
	}
	
	 public void ScrollToButtom()
	 {
		   js.executeScript("scrollBy(0,document.body.scrollHeight)");
	 }
	 
	 public void makeAction(WebElement ele,WebElement ele2)
	 {
		 action.moveToElement(ele).moveToElement(ele2).click().perform();
	 }
}
