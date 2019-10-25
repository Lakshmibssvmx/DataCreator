package com.dc.datacreator.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DC_SchedulerMapPO 
{
	WebDriver driver = null;
	public DC_SchedulerMapPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
}
