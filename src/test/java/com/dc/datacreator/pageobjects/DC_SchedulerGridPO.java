package com.dc.datacreator.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DC_SchedulerGridPO 
{
	WebDriver driver = null;
	public DC_SchedulerGridPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//label[text()='View']")
	private WebElement eleViewTxt;
	public WebElement getEleViewTxt() 
	{
		return eleViewTxt;
	}
	
	@FindBy(xpath="//div[@class='View__viewBox']//input[@class='Input Picklist__input slds-input slds-combobox__input'][@name='picklist-single']")  //INCOMPLETE
	private WebElement eleViewLst;
	public WebElement getEleViewLst() 
	{
		return eleViewLst;
	}
	  
	private WebElement eleViewLstItm;       //INCOMPLETE
	public WebElement getEleViewLstItm(String sTitle)  
	{
		eleViewLstItm=driver.findElement(By.xpath("//a[@class='Menu__item-link slds-truncate react-slds-menuitem']//span[@title='"+sTitle+"']"));
		return eleViewLstItm;
	}
	
	@FindBy(xpath="//label[text()='Filter']")
	private WebElement eleFilterTxt;
	public WebElement getEleFilterTxt() 
	{
		return eleFilterTxt;
	}
	
	@FindBy(xpath="//div[@class='Filter__filterBox']//input[@class='Input Picklist__input slds-input slds-combobox__input'][@name='picklist-single']")  //INCOMPLETE
	private WebElement eleFilterLst;
	public WebElement getEleFilterLst() 
	{
		return eleFilterLst;
	}
	
	private WebElement eleFilterLstItm;       //INCOMPLETE
	public WebElement getEleFilterLstItm(String sTitle)  
	{
		eleFilterLstItm=driver.findElement(By.xpath("//span[@title='"+sTitle+"']/../../a"));
		return eleFilterLstItm;
	}
	
	@FindBy(xpath="//label[text()='contains']")
	private WebElement eleContainsTxt;
	public WebElement getEleContainsTxt() 
	{
		return eleContainsTxt;
	}
	
	@FindBy(xpath="//input[@name='gridFilter']")
	private WebElement eleContainsTxtFld;
	public WebElement getEleContainsTxtFld() 
	{
		return eleContainsTxtFld;
	}
	
	@FindBy(xpath="//label[text()='Status']")
	private WebElement eleStatusTxt;
	public WebElement getEleStatusTxt() 
	{
		return eleStatusTxt;
	}
	
	@FindBy(xpath="//div[@class='Status__checkboxContainer']//label[@class='slds-checkbox__label']/span")
	private WebElement eleNewChkBx;
	public WebElement getEleNewChkBx() 
	{
		return eleNewChkBx;
	}
	
	@FindBy(xpath="//span[text()='New']")
	private WebElement eleNewTxt;
	public WebElement getEleNewTxt() 
	{
		return eleNewTxt;
	}
	
	@FindBy(xpath="//input[@type='checkbox'][@name='Assigned']")
	private WebElement eleAssignedChkBx;
	public WebElement getEleAssignedChkBx() 
	{
		return eleAssignedChkBx;
	}
	
	@FindBy(xpath="//span[text()='Assigned']")
	private WebElement eleAssignedTxt;
	public WebElement getEleAssignedTxt() 
	{
		return eleAssignedTxt;
	}
	
	@FindBy(xpath="//input[@type='checkbox'][@name='Queued']")
	private WebElement eleQueuedChkBx;
	public WebElement getEleQueuedChkBx() 
	{
		return eleQueuedChkBx;
	}
	
	@FindBy(xpath="//span[text()='Queued']")
	private WebElement eleQueuedTxt;
	public WebElement getEleQueuedTxt() 
	{
		return eleQueuedTxt;
	}
	
	@FindBy(xpath="//button[@title='Reload Data']")
	private WebElement eleReloadDataBtn;
	public WebElement getEleReloadDataBtn() 
	{
		return eleReloadDataBtn;
	}
	
	@FindBy(xpath="//button[@title='Configure Colors']")       //INCOMPLETE
	private WebElement eleConfigureColorBtn;
	public WebElement getEleConfigureColorBtn() 
	{
		return eleConfigureColorBtn;
	}
	
	@FindBy(xpath="//button[@title='Configure Work Order Queue']")    //INCOMPLETE
	private WebElement eleConfigureWOQueueBtn;
	public WebElement getEleConfigureWOQueueBtn() 
	{
		return eleConfigureWOQueueBtn;
	}
	
	@FindBy(xpath="//button/svg[@class='Icon slds-button__icon slds-button__icon--center slds-button__icon--small slds-icon--small']/use[@xlink:href='/assets//icons/utility-sprite/svg/symbols.svg#question']")	//INCOMPLETE
	private WebElement eleQuestionBtn;
	public WebElement getEleQuestionBtn() 
	{
		return eleQuestionBtn;
	}
	
	//Context Menu PO
	private WebElement eleWOContextMenuIcn;       //INCOMPLETE
	public WebElement getEleWOContextMenuIcn(String sWONumber)  
	{
		driver.findElement(By.xpath("//div[text()='"+sWONumber+"']/../..//button[@class='Button Dropdown__button slds-button Button--type-icon slds-button--icon slds-button_icon slds-button--x-small']"));
		return eleWOContextMenuIcn;
	}
	
	//PO of Configure colors - RULES
	@FindBy(xpath="//h2[text()='Configure Coloring of Workorder Grid']")
	private WebElement eleConfigureColorTtl;
	public WebElement getEleConfigureColorTtl() 
	{
		return eleConfigureColorTtl;
	}
	
	@FindBy(xpath="//span[@class='react-slds-tab-item-content']/a[@class='Tab__link slds-tabs_scoped__link'][text()='Rules']")
	private WebElement eleRulesLnk;
	public WebElement getEleRulesLnk() 
	{
		return eleRulesLnk;
	}
	
	@FindBy(xpath="//div[text()='Rule Name']")
	private WebElement eleRuleNameTtl;
	public WebElement getEleRuleNameTtl() 
	{
		return eleRuleNameTtl;
	}
	
	@FindBy(xpath="//div[text()='Status']")
	private WebElement eleStatusConfigTtl;
	public WebElement getEleStatusConfigTtl() 
	{
		return eleStatusConfigTtl;
	}
	
	@FindBy(xpath="//div[text()='Delete']")
	private WebElement eleDeleteConfigTtl;
	public WebElement getEleDeleteConfigTtl() 
	{
		return eleDeleteConfigTtl;
	}
	
	@FindBy(xpath="//div[text()='Critical Work Orders']")
	private WebElement eleCriticalWOTxt;
	public WebElement getEleCriticalWOTxt() 
	{
		return eleCriticalWOTxt;
	}
	
	@FindBy(xpath="//div[text()='High Priority Work Orders']")
	private WebElement eleHighPriWOTxt;
	public WebElement getEleHighPriWOTxt() 
	{
		return eleHighPriWOTxt;
	}
	
	@FindBy(xpath="//div[text()='Medium Priority Work Orders']")
	private WebElement eleMediumPriWOTxt;
	public WebElement getEleMediumPriWOTxt() 
	{
		return eleMediumPriWOTxt;
	}
	
	private WebElement eleDeleteConfigIcn;       //INCOMPLETE
	public WebElement getEleDeleteConfigIcn(String sRuleName)  
	{
		driver.findElement(By.xpath("//div[text()='"+sRuleName+"']/..//svg[@class='Icon ColorRules__deleteIcon slds-icon slds-icon--x-small slds-icon-text-default']"));
		return eleDeleteConfigIcn;
	}
	

	@FindBy(xpath="//label[text()='Rule Name']")
	private WebElement eleRuleNameTxt;
	public WebElement getEleRuleNameTxt() 
	{
		return eleRuleNameTxt;
	}
	
	@FindBy(xpath="//input[@name='rule-name-input']")
	private WebElement eleRuleNameTxtFld;
	public WebElement getEleRuleNameTxtFld() 
	{
		return eleRuleNameTxtFld;
	}
	
	@FindBy(xpath="//div[@class='']/div[@class='ColorPicker']")
	private WebElement eleRulesColorPickerIcn;
	public WebElement getEleRulesColorPickerIcn() 
	{
		return eleRulesColorPickerIcn;
	}
	
	@FindBy(xpath="//label[@class='Toggle slds-checkbox--toggle']/input")
	private WebElement eleActiveBtn;
	public WebElement getEleActiveBtn() 
	{
		return eleActiveBtn;
	}
	
	@FindBy(xpath="//label[text()='Rule Name']")
	private WebElement eleRuleExprTxt;
	public WebElement getEleRuleExprTxt() 
	{
		return eleRuleExprTxt;
	}
	
	
	@FindBy(xpath="//label[@class='Label slds-form-element__label'][text()='1']/../..//svg[@class='Icon slds-input__icon slds-input__icon--right slds-icon-text-default Picklist__input-icon slds-icon slds-icon--x-small slds-icon-text-default'][1]")
	private WebElement eleRuleExpItemLst;
	public WebElement getEleRuleExpItemLst() 
	{
		return eleRuleExpItemLst;
	}
	
	@FindBy(xpath="(//svg[@class='Icon slds-input__icon slds-input__icon--right slds-icon-text-default Picklist__input-icon slds-icon slds-icon--x-small slds-icon-text-default'])[2]")
	private WebElement eleRuleExpItemValueLst;
	public WebElement getEleRuleExpItemValueLst() 
	{
		return eleRuleExpItemValueLst;
	}
	
	private WebElement eleRuleExpItemValueTxt;
	public WebElement getEleRuleExpItemValueTxt(String sTitle) 
	{
		driver.findElement(By.xpath("(//span[@class='Menu__item-content slds-truncate']/span[@title='"+sTitle+"'])[2]"));
		return eleRuleExpItemValueTxt;
	}
	

	@FindBy(xpath="") 				//INCOMPLETE
	private WebElement eleRuleCloseIcn;
	public WebElement getEleRuleCloseIcn() 
	{
		return eleRuleCloseIcn;
	}
	
	@FindBy(xpath="//label[@class='Label RuleExpression__addExpression slds-form-element__label']")
	private WebElement eleAddExpressionLnk;
	public WebElement getEleAddExpressionLnk() 
	{
		return eleAddExpressionLnk;
	}
	
	@FindBy(xpath="")				//INCOMPLETE
	private WebElement eleInExpressionTxt;
	public WebElement getEleInExpressionTxt() 
	{
		return eleInExpressionTxt;
	}
	
	@FindBy(xpath="//label[@class='Label ColorRules__addRule slds-form-element__label")
	private WebElement eleAddRuleLnk;
	public WebElement getEleAddRuleLnk() 
	{
		return eleAddRuleLnk;
	}
	
	@FindBy(xpath="//span[@class='Button__label'][text()='Done']")
	private WebElement eleConfigureDoneBtn;
	public WebElement getEleConfigureDoneBtn() 
	{
		return eleConfigureDoneBtn;
	}
	
	@FindBy(xpath="//button[@title='Close']")
	private WebElement eleConfigureCloseIcn;
	public WebElement getEleConfigureCloseIcn() 
	{
		return eleConfigureCloseIcn;
	}
	
	//PO of Configure colors - HIGHLIGHT
	@FindBy(xpath="//span[@class='react-slds-tab-item-content']/a[@class='Tab__link slds-tabs_scoped__link'][text()='Highlight']")
	private WebElement eleHighlightLnk;
	public WebElement getEleHighlightLnk() 
	{
		return eleHighlightLnk;
	}
	
	@FindBy(xpath="//div[@class='']/div[@class='ColorPicker']")			//INCOMPLETE
	private WebElement eleHoverColorPickerIcn;
	public WebElement getEleHoverColorPickerIcn() 
	{
		return eleHoverColorPickerIcn;
	}
	
	@FindBy(xpath="//div[@class='']/div[@class='ColorPicker']")			//INCOMPLETE
	private WebElement eleSelectionColorPickerIcn;
	public WebElement getEleSelectionColorPickerIcn() 
	{
		return eleSelectionColorPickerIcn;
	}
	
	@FindBy(xpath="//label[@class='Label slds-form-element__label'][contains(text(),'Hover Color')]")			//INCOMPLETE
	private WebElement eleHoverColorTxt;
	public WebElement getEleHoverColorTxt() 
	{
		return eleHoverColorTxt;
	}
	
	@FindBy(xpath="//label[@class='Label slds-form-element__label'][contains(text(),'Selection Color')]")
	private WebElement eleSelectionColorTxt;
	public WebElement getEleSelectionColorTxt() 
	{
		return eleSelectionColorTxt;
	}
	
	//PO of Configure colors - COUNTERS
	@FindBy(xpath="//span[@class='react-slds-tab-item-content']/a[@class='Tab__link slds-tabs_scoped__link'][text()='Counters']")
	private WebElement eleCountersLnk;
	public WebElement getEleCountersLnk() 
	{
		return eleCountersLnk;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='1']")			//INCOMPLETE
	private WebElement eleCountersColor1Txt;
	public WebElement getEleCountersColor1Txt() 
	{
		return eleCountersColor1Txt;
	}
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='1']/../..//div[@class='ColorPicker']")			//INCOMPLETE
	private WebElement eleCountersColorPicker1Icn;
	public WebElement getEleCountersColorPicker1Icn() 
	{
		return eleCountersColorPicker1Icn;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='1']/../..//div/input")			//INCOMPLETE
	private WebElement eleCountersPicker1Lst;
	public WebElement getEleCountersPicker1Lst() 
	{
		return eleCountersPicker1Lst;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='1']/../..//ul/li/a")	//INCOMPLETE		//INCOMPLETE
	private WebElement eleCountersPicker1Itm;
	public WebElement getEleCountersPicker1Itm() 
	{
		return eleCountersPicker1Itm;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='2']")			//INCOMPLETE
	private WebElement eleCountersColor2Txt;
	public WebElement getEleCountersColor2Txt() 
	{
		return eleCountersColor2Txt;
	}
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='2']/../..//div[@class='ColorPicker']")			//INCOMPLETE
	private WebElement eleCountersColorPicker2Icn;
	public WebElement getEleCountersColorPicker2Icn() 
	{
		return eleCountersColorPicker2Icn;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='2']/../..//div/input")			//INCOMPLETE
	private WebElement eleCountersPicker2Lst;
	public WebElement getEleCountersPicker2Lst() 
	{
		return eleCountersPicker2Lst;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='1']/../..//ul/li/a")	//INCOMPLETE		//INCOMPLETE
	private WebElement eleCountersPicker2Itm;
	public WebElement getEleCountersPicker2Itm() 
	{
		return eleCountersPicker2Itm;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='3']")			//INCOMPLETE
	private WebElement eleCountersColor3Txt;
	public WebElement getEleCountersColor3Txt() 
	{
		return eleCountersColor3Txt;
	}
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='3']/../..//div[@class='ColorPicker']")			//INCOMPLETE
	private WebElement eleCountersColorPicker3Icn;
	public WebElement getEleCountersColorPicker3Icn() 
	{
		return eleCountersColorPicker3Icn;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='3']/../..//div/input")			//INCOMPLETE
	private WebElement eleCountersPicker3Lst;
	public WebElement getEleCountersPicker3Lst() 
	{
		return eleCountersPicker3Lst;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='1']/../..//ul/li/a")	//INCOMPLETE		//INCOMPLETE
	private WebElement eleCountersPicker3Itm;
	public WebElement getEleCountersPicker3Itm() 
	{
		return eleCountersPicker3Itm;
	}
	
	@FindBy(xpath="//span[@class='ColorCounters__items'][text()='3']/../..//div/input")			//INCOMPLETE
	private WebElement eleConfigureWOQueueTxt;
	public WebElement getEleConfigureWOQueueTxt() 
	{
		return eleConfigureWOQueueTxt;
	}
	
	@FindBy(xpath="//label[@class='Available fields']")			
	private WebElement eleAvailableFieldsTxt;
	public WebElement getEleAvailableFieldsTxt() 
	{
		return eleAvailableFieldsTxt;
	}
	
	@FindBy(xpath="//span[text()='Automatically refresh list.']")			
	private WebElement eleAutoRefreshTxt;
	public WebElement getEleAutoRefreshTxt() 
	{
		return eleAutoRefreshTxt;
	}
	
	@FindBy(xpath="//span[text()='Automatically refresh list.']/../..//input")			
	private WebElement eleAutoRefreshChkBx;
	public WebElement getEleAutoRefreshChkBx() 
	{
		return eleAutoRefreshChkBx;
	}
	
	@FindBy(xpath="//span[text()='Automatically refresh list.']/../..//input")			
	private WebElement eleConfigureMinsTxtFld;
	public WebElement getEleConfigureMinsTxtFld() 
	{
		return eleConfigureMinsTxtFld;
	}
	
	@FindBy(xpath="//label[text()='Minutes']")			
	private WebElement eleMinutesTxt;
	public WebElement getEleMinutesTxt() 
	{
		return eleMinutesTxt;
	}
	
	private WebElement eleWOTxt;       
	public WebElement getEleWOTxt(String sWOTxt)  
	{
		eleWOTxt=driver.findElement(By.xpath("//div[text()='"+sWOTxt+"']"));
		return eleWOTxt;
	}
	
	private WebElement elePriorityTxt;       
	public WebElement getElePriorityTxt(String sWOTxt, String sPriorityTxt)  
	{
		elePriorityTxt=driver.findElement(By.xpath("//div[text()='"+sWOTxt+"']/../..//div[text()='"+sPriorityTxt+"']"));
		return elePriorityTxt;
	}
	
	private WebElement eleOrderTypeTxt;       
	public WebElement getEleOrderTypeTxt(String sWOTxt, String sOrderTypeTxt)  
	{
		eleOrderTypeTxt=driver.findElement(By.xpath("//div[text()='"+sWOTxt+"']/../..//div[text()='"+sOrderTypeTxt+"']"));
		return eleOrderTypeTxt;
	}
	
	private WebElement eleDispatchStatusTxt;       
	public WebElement getEleDispatchStatusTxt(String sWOTxt, String sDispatchStatusTxt)  
	{
		eleDispatchStatusTxt=driver.findElement(By.xpath("//div[text()='"+sWOTxt+"']/../..//div[text()='"+sDispatchStatusTxt+"']"));
		return eleDispatchStatusTxt;
	}
	
	private WebElement eleTechNameTxt;       
	public WebElement getEleTechNameTxt(String sWOTxt, String sTechNameTxt)  
	{
		eleTechNameTxt=driver.findElement(By.xpath("//div[text()='"+sWOTxt+"']/../..//div[text()='"+sTechNameTxt+"']"));
		return eleTechNameTxt;
	}
	public void dcFilter(String sFilterTxt, String sFilterValue ) throws InterruptedException
	{
		getEleFilterLst().click();
		getEleFilterLstItm(sFilterTxt).click();
		getEleContainsTxtFld().sendKeys(sFilterValue);
	}
	
}
