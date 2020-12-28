package com.zoopla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//Button[@class='ui-button-secondary']")
	WebElement SaveMyPreferences;
	@FindBy(xpath="//input[@id='search-input-location']")
	WebElement EnterCity;
	@FindBy(xpath="//Button[@type='submit']")
	WebElement Search;
	
	public void preferredButtonClick()
	{
		SaveMyPreferences.click();
	}
	
	public void EnterCityName(String city)
	{
		EnterCity.sendKeys(city);
	}
	
	public ListingPage ClickOnSearch()
	{
		Search.click();
		return new ListingPage(driver);
	}
}
