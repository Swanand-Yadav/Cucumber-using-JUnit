package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Utils.TestBase;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;

public class CheckOutPageStepDefination 
{
	public WebDriver driver;
	public String OfferPageProductName;
	TestContextSetup tcs;//keep public here if any error occured
	public CheckoutPage CheckOutPage;
	
	public CheckOutPageStepDefination(TestContextSetup tcs)
	{
		this.tcs=tcs;
		this.CheckOutPage=tcs.pageObjectManager.getCheckoutPage();
	}
	/*
	@Given("^User is on GreenCart Landing page$")
    public void user_is_on_greencart_landing_page() 
	{
        
    }

    @When("^User searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String name) 
    {
       
    }
*/
    @Then("^User proceeds to checkout and validate the (.+) items in checkout$")
    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout(String name) 
    {
    	CheckOutPage.checkOutItems();
    	// Assertion to extract name from screen and compare with name
    }

    

    @Then("^verify user has ability to enter promo code and place the order$")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() 
    {
    	CheckOutPage=tcs.pageObjectManager.getCheckoutPage();
    	Assert.assertTrue(CheckOutPage.verifyPromoBtn());
    	Assert.assertTrue(CheckOutPage.verifyPlaceOrder());
    }
}
