package com.zoopla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailPage {

	WebDriver driver;
	public PropertyDetailPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//h4[@class='ui-agent__name][1]")
	WebElement agentName;
	
	public String getAgentName()
	{
		String agentNameDetails = agentName.getText();
		System.out.println("Agent Name Details from Property Details Page: " + agentNameDetails);
		return agentNameDetails;
	}
	
	public AgentPage clickOnAgentName()
	{
		agentName.click();
		return new AgentPage(driver);
	}
}
