package com.zoopla.TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoopla.pages.AgentPage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.ListingPage;
import com.zoopla.pages.PropertyDetailPage;

public class Tests extends ReUsable{

//	WebDriver driver;
	@Test
	public void inputLocationAndClickSubmit() throws InterruptedException
	{
		HomePage homepage = new HomePage(driver);
		ListingPage listingpage;
		AgentPage agentpage;
		PropertyDetailPage propertydetailspage;
		driver.get("https://www.zoopla.co.uk/");
		Thread.sleep(1500);
		homepage.preferredButtonClick();
		
		String expectedTitle = "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		
		homepage.EnterCityName("london");
		listingpage=homepage.ClickOnSearch();
		
		listingpage.mostRecentRow();
		listingpage.getAllListings();
		
		propertydetailspage = listingpage.FifthListing();
		
		String agentDetailFromPropertyDetailPage = propertydetailspage.getAgentName();
		
		agentpage=propertydetailspage.clickOnAgentName();
		Thread.sleep(2000);
		
		String agentFromAgentPage = agentpage.GetDetailsFromAgentPage();
		Assert.assertTrue(agentDetailFromPropertyDetailPage.contains(agentFromAgentPage));
		
	}
}
