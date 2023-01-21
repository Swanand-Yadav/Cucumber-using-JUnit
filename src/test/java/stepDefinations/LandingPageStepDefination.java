package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Utils.TestBase;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;

public class LandingPageStepDefination 
{
	public WebDriver driver;
	public String OfferPageProductName;
	TestContextSetup tcs;
	LandingPage landingPage;
	
	public LandingPageStepDefination(TestContextSetup tcs)
	{
		this.tcs=tcs;
		this.landingPage=tcs.pageObjectManager.getLandingPage();
	}
	
    @Given("^User is on GreenCart Landing page$")
    public void user_is_on_greencart_landing_page() 
    {
    	Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^User searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName) throws InterruptedException  
    {
    	//landingPage=tcs.pageObjectManager.getLandingPage();//chenge here if error occured
    	landingPage.searchItem(shortName);
    	Thread.sleep(3000);
    	tcs.LandingPageProductName=landingPage.getProductName().split("-")[0].trim();
    }   
    
    @When("^Added \"([^\"]*)\" items of the selected product of cart$")
    public void added_something_items_of_the_selected_product_of_cart(String quantity) 
    {
    	landingPage.increamentQuantity(Integer.parseInt(quantity));
    	landingPage.addToCart();
    }
}
