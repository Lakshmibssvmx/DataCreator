package com.dc.datacreator.pageobjects;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dc.datacreator.lib.GenericLib;

public class DC_SalesForceOrgPO 
{
	WebDriver driver = null;
	public static String sParentWnd = null;
	public static String sDCWnd = null;
	public DC_SalesForceOrgPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	private WebElement eleUsernameTxtFld;
	public WebElement getEleUsernameTxtFld() 
	{
		return eleUsernameTxtFld;
	}
	@FindBy(id="password")
	private WebElement elePasswordTxtFld;
	public WebElement getElePasswordTxtFld() 
	{
		return elePasswordTxtFld;
	}
	@FindBy(id="Login")
	private WebElement eleLoginBtn;
	public WebElement getEleLoginBtn() 
	{
		return eleLoginBtn;
	}
	
	@FindBy(id="home_Tab")
	private WebElement eleHomeTab;
	public WebElement getEleHomeTab() 
	{
		return eleHomeTab;
	}
	@FindBy(xpath="//button[@class='bare branding-userProfile-button slds-button slds-global-actions__avatar slds-global-actions__item-action uiButton forceHeaderButton']")
	private WebElement eleProfileIcn;
	public WebElement getEleProfileIcn() 
	{
		return eleProfileIcn;
	}
	@FindBy(xpath="//div[@class='container']//a[@class='profile-link-label switch-to-aloha uiOutputURL']")
	private WebElement eleSwitchSFClassicLnk;
	public WebElement getEleSwitchSFClassicLnk() 
	{
		return eleSwitchSFClassicLnk;
	}
	
	@FindBy(xpath="//div[@class='sidebarModuleBody']//a[text()='Dispatch Console HTML']")
	private WebElement eleDispatchConsoleLnk;
	public WebElement getEleDispatchConsoleLnk() 
	{
		return eleDispatchConsoleLnk;
	}
	@FindBy(xpath="//a[@href='/_ui/core/userprofile/UserProfilePage']")
	private WebElement eleProfileLnk;
	public WebElement getEleProfileLnk() 
	{
		return eleProfileLnk;
	}
	@FindBy(xpath="//h2[text()='Recent Items']")
	private WebElement eleRecentItemsTxt;
	public WebElement getEleRecentItemsTxt() 
	{
		return eleRecentItemsTxt;
	}

	private WebElement eleTeamTxt;
	public WebElement getEleTeamTxt(String sTeam) 
	{
		eleTeamTxt=driver.findElement(By.xpath("//h2[text()=' "+ sTeam+"']"));
		return eleTeamTxt;
	}
	private WebElement eleTechTxt;
	public WebElement getEleTechTxt(String sTech) 
	{
		eleTechTxt=driver.findElement(By.xpath("//h2[text()=' "+ sTech+"']"));
		return eleTechTxt;
	}
	
	@FindBy(xpath="//td/span[text()='Latitude']/../..//td[@class='dataCol inlineEditWrite']/div")
	private WebElement eleLatitudeTxt;
	public WebElement getEleLatitudeTxt() 
	{
		return eleLatitudeTxt;
	}
	@FindBy(xpath="//td/span[text()='Longitude']/../..//td[@class='dataCol inlineEditWrite']/div")
	private WebElement eleLongitudeTxt;
	public WebElement getEleLongitudeTxt() 
	{
		return eleLongitudeTxt;
	}
	
	@FindBy(xpath="//td/span[text()='Home Longitude']/../..//td[@class='dataCol inlineEditWrite']/div")
	private WebElement eleHomeLongitudeTxt;
	public WebElement getEleHomeLongitudeTxt() 
	{
		return eleHomeLongitudeTxt;
	}
	
	@FindBy(xpath="//td/span[text()='Home Latitude']/../..//td[@class='dataCol inlineEditWrite']/div")
	private WebElement eleHomeLatitudeTxt;
	public WebElement getEleHomeLatitudeTxt() 
	{
		return eleHomeLatitudeTxt;
	}
	
	@FindBy(xpath="//input[@title=' Validate Address']")
	private WebElement eleValidateAddressBtn;
	public WebElement getEleValidateAddressBtn() 
	{
		return eleValidateAddressBtn;
	}
	
	@FindBy(css="iframe[title='Service_Group_Wizard']")
	private WebElement eleServiceWizardTeamFrm;
	public WebElement getEleServiceWizardTeamFrm() 
	{
		return eleServiceWizardTeamFrm;
	}
	
	@FindBy(css="iframe[title='Service_Group_Member_Wizard']")
	private WebElement eleServiceWizardTechFrm;
	public WebElement getEleServiceWizardTechFrm() 
	{
		return eleServiceWizardTechFrm;
	}
	
	public void login(String sUser, String sPwd) throws InterruptedException
	{
		try {
			Assert.assertTrue(getEleUsernameTxtFld().isDisplayed(), "Salesforce login page is not displayed");
			getEleUsernameTxtFld().sendKeys(sUser);
			getElePasswordTxtFld().sendKeys(sPwd);
			getEleLoginBtn().click();
			Thread.sleep(GenericLib.iLowSleep);
			handleLightningAlert();
			Assert.assertTrue(getEleHomeTab().isDisplayed(), "Failed to login");
			}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	public void switchToClassic()
	{
		getEleProfileIcn().click();
		getEleSwitchSFClassicLnk().click();
		Assert.assertTrue(getEleHomeTab().isDisplayed(), "Failed to switch to Salesforce Classic");
	}
	
	public void navigatehome() throws InterruptedException
	{
		getEleHomeTab().click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		handleLightningAlert();
		Assert.assertTrue(getEleRecentItemsTxt().isDisplayed(), "Failed to navigate to home page");
		
	}
	
	public void handleLightningAlert()
	{
		try {
			driver.findElement(By.id("tryLexDialogX")).click();
		}catch(Exception e) {
			
		}
		
	}
	public void naviagateDC() throws InterruptedException
	{	getEleDispatchConsoleLnk().click();
		Thread.sleep(GenericLib.iMedSleep);
		windowHandle();
		driver.switchTo().window(sDCWnd);
		driver.manage().window().maximize();
		Thread.sleep(GenericLib.iLowSleep);
	}
	
	public void windowHandle()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator=windowHandles.iterator();
		while(iterator.hasNext())
		{
			sParentWnd = iterator.next();
			sDCWnd = iterator.next();
		}
		
	}
	public void validateTech(String sTech) throws InterruptedException
	{
		
		Assert.assertTrue(getEleTechTxt(sTech).isDisplayed(), "Technician page is not displayed");
		driver.switchTo().frame(getEleServiceWizardTechFrm());
		getEleValidateAddressBtn().click();
		Thread.sleep(GenericLib.iHighSleep);
		driver.switchTo().defaultContent();
		Assert.assertTrue(getEleHomeLatitudeTxt().isDisplayed(), "Failed to validate address of technician.");
		Assert.assertTrue(getEleHomeLongitudeTxt().isDisplayed(), "Failed to validate address of techncian.");
		
	}
	public void validateTeam(String sTeam) throws InterruptedException
	{
		
		Assert.assertTrue(getEleTeamTxt(sTeam).isDisplayed(), "Team page is not displayed");
		driver.switchTo().frame(getEleServiceWizardTeamFrm());
		getEleValidateAddressBtn().click();
		Thread.sleep(GenericLib.iHighSleep);
		driver.switchTo().defaultContent();	
		Assert.assertTrue(getEleLatitudeTxt().isDisplayed(), "Failed to validate address of team.");
		Assert.assertTrue(getEleLongitudeTxt().isDisplayed(), "Failed to validate address of team.");
		
	}
}
