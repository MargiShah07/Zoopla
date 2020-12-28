package com.zoopla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentPage {
	WebDriver driver;
	
	public AgentPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h1[@class='bottom-half']//b[1]")
	WebElement agentName;
	
	public String GetDetailsFromAgentPage()
	{
		String agentDetails = agentName.getText();
		System.out.println("Agent Details from Agent Page: " + agentDetails);
		return agentDetails;
	}
}
