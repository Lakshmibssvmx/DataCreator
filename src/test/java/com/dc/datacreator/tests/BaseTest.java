package com.dc.datacreator.tests;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.dc.datacreator.lib.BrowserLib;
import com.dc.datacreator.lib.GenericLib;
import com.dc.datacreator.lib.RestLib;
import com.dc.datacreator.pageobjects.DC_SalesForceOrgPO;
import com.dc.datacreator.pageobjects.DC_SchedulerEventPO;
import com.dc.datacreator.pageobjects.DC_SchedulerGridPO;
import com.dc.datacreator.pageobjects.DC_SchedulerMapPO;

public class BaseTest extends BrowserLib{
	//Selenium variables or class object initialization
	public Alert alert = null;
	public Actions actions = null;
	public Select selList = null;
	
	//Framework variables or framework class object initialization
	public RestLib restLib = null;

	//Page Object reference initilialization
	public DC_SalesForceOrgPO dc_salesforcePo = null;
	//public DC_ServiceMaxSetupPO dc_servicemaxsetupPo = null;
	public DC_SchedulerGridPO dc_schedulergridPo = null;
	public DC_SchedulerEventPO dc_schedulereventPo = null;
	public DC_SchedulerMapPO dc_schedulermapPo = null;
	
	//Global Test variable initialization
	public String sTestCaseID=null;
	public String sTeam=null; public String sTech=null; public String sStreet=null; public String sCity=null; public String sState=null;  public String sZip=null; public String sCountry=null;
	public String sWorkOrderID=null; public String sFromDate = null; public String sToDate =null; public String sTechName = null; public String sStartDate = null; public String sEndDate = null;
	public String sStartTime = null;public String sEndTime = null; public String sWOJsonData = null; public String sWOName=null; public String sTechZip = null; public String sTechStreet = null;
	public String sTerritoryName = null; public String sParentName = null;

	//Global Test Salesforce variable initialization
	public String sObjectApi =null; public String sJsonData = null; public String sWoObjectID =null; public String sSqlQuery =null;
	public String sRandomNo = null;

	
	@BeforeClass()
	public void login() throws InterruptedException, IOException
	{   // object creation for Rest service 
		
		restLib = new RestLib();
	
		// object creation for page objects                      
		dc_salesforcePo = new DC_SalesForceOrgPO(driver);
		dc_schedulergridPo = new DC_SchedulerGridPO(driver);
		dc_schedulereventPo = new DC_SchedulerEventPO(driver);
		dc_schedulermapPo =new DC_SchedulerMapPO(driver);
		//Login to Application
		dc_salesforcePo.login(GenericLib.getConfigValue(GenericLib.sConfigFile, "USERNAME"), GenericLib.getConfigValue(GenericLib.sConfigFile, "PASSWORD"));
				
		// Generation of rest token to access app via Oauth interface
		restLib.getOauthAccessToken();
		
		dc_salesforcePo.sParentWnd=driver.getWindowHandle();
		
	}

	@BeforeMethod
	public void baseStateHome() throws Exception
	{
		//dc_salesforcePo.navigatehome();
	}
	
	@AfterMethod
	public void closeChildBrowser() throws Exception
	{
		//driver.switchTo().window(dc_salesforcePo.sDCWnd).close();
		//driver.switchTo().window(dc_salesforcePo.sParentWnd);
		//driver.switchTo().defaultContent();
	}
	
	
	@AfterClass
	public void logout()
	{
		//;
	}
	
}
