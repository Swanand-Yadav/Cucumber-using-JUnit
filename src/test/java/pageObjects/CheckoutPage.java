package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	public WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By cartBag=By.xpath("//img[@alt='Cart']");
	By checkOutButton=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoBtn=By.cssSelector(".promoBtn");
	By placeOrder=By.xpath(" //Button[text()='Place Order']");
	
	public void checkOutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public boolean verifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
}
