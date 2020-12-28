package com.zoopla.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ListingPage {
	WebDriver driver;
	public ListingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@id='sort-order-dropdown']")
	WebElement mostRecent;
	
	@FindBy(xpath="//body/div[@id='__next']/div[4]/div[1]/main[1]/div[2]")
	List<WebElement> listings;
	public void mostRecentRow() throws InterruptedException
	{
		Select sort = new Select(mostRecent);
		sort.selectByVisibleText("Highest price");
		Thread.sleep(2000);
	}
	
	public void getAllListings()
	{
		System.out.println("Listings on the page are: " + listings.size());
		for(int i=0;i<listings.size();i++)
		{
			System.out.println("The property: " + listings.get(i).getText());
		}
	}
	
	public PropertyDetailPage FifthListing() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement FifthList=listings.get(4).findElement(By.xpath("//body/div[@id='__next']/div[4]/div[1]/main[1]/div[2]/div[2]/div[5]/div[1]/div[1]/div[2]/a[1]"));
		System.out.println("Fifth List is: " + FifthList.getText());
		FifthList.click();
		System.out.println("Fifth List clicked.");
		
		System.out.println("");
		return new PropertyDetailPage(driver);
	}
}
