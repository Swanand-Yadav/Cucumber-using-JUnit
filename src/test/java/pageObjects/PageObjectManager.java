package pageObjects;

import org.openqa.selenium.WebDriver;
// Below nothing but the factory design pattern
public class PageObjectManager 
{
	public LandingPage landingPage;
	public OffersPage offerPage;
	public WebDriver driver;
	public CheckoutPage checkOutPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LandingPage getLandingPage()
	{
		landingPage=new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage()
	{
		offerPage=new OffersPage(driver);
		return offerPage;
	}
	
	public CheckoutPage getCheckoutPage()
	{
		checkOutPage=new CheckoutPage(driver);
		return checkOutPage;
	}
}
