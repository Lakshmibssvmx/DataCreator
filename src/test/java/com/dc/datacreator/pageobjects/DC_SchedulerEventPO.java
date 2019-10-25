package com.dc.datacreator.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DC_SchedulerEventPO 
{

	WebDriver driver = null;
	public DC_SchedulerEventPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//label[@id='expandAll']")
	private WebElement eleExpandAllLnk;
	public WebElement getEleExpandAllLnk() 
	{
		return eleExpandAllLnk;
	}
}
