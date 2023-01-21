package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;

import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

public class OfferPageStepDefination 
{
	public String OfferPageProductName;
	TestContextSetup tcs;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefination(TestContextSetup tcs)
	{
		this.tcs=tcs;
	}

	 @Then("^User searched for (.+) shortname in offers page$")
    public void user_searched_for_something_shortname_in_offers(String shortName) throws InterruptedException 
    {
		switchToOfferPage();
		OffersPage offerPage=tcs.pageObjectManager.getOffersPage();
		offerPage.searchItem(shortName);
		Thread.sleep(3000);
        OfferPageProductName=offerPage.getProductName();   
    }
    
	public void switchToOfferPage()
	{
		LandingPage lp=tcs.pageObjectManager.getLandingPage();// Creating landing page object.
		lp.selectTopDealsPage();// It will select topdeal page to redirect offer page.
		tcs.genericUtils.SwitchWindowToChild();
	}
	
    @Then("validate product name in offers page matches with Landing page")
    public void validate_product_name_in_offers_page_matches_with_landing_page()
    {
        Assert.assertEquals(tcs.LandingPageProductName, OfferPageProductName);
    }
}
