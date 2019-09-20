package com.dc.datacreator.tests;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.dc.datacreator.lib.GenericLib;
import com.dc.datacreator.lib.RestLib;

public class DataTest
{
	RestLib restLib=null;
	String sRefName=null; 
	String sAccName=null; String sBillingPostalCode=null; String sBillingStreet=null; String sShippingStreet=null; String sShippingPostalCode=null;
	String sBillingCity=null; String sBillingCountry=null; String sBillingState=null; String sCurrencyIsoCode=null; String sIndustry=null;
	String sShippingCity=null; String sShippingCountry=null; String sShippingState=null; String sType=null; 
	String sProdName=null; String sProdCode=null; String sProdCurrency=null; String sUnitMeasure=null; String sDescription=null; String sProdFamily=null;
	String sSalutation=null; String sFirstName=null; String sLastName=null; String sMailingStreet=null; String sMailingCity=null; String sMailingState=null; String sMailingCode=null; String sMailingCountry=null; 	
	String sRecordTypeId=null; String sLocName=null;
	String sCaseNum=null; String sOrigin=null; String sPriority=null; String sReason=null; String sStatus=null; String sSubject=null;
	String sTeamName=null; String sStreet=null;String sZip=null; String sCity=null; String sState=null; String sCountry=null; String sTeamRec=null;
	String sTechName=null; 	String sTechRec=null;
	public String sObjectApi=null; public String sJsonData = null; Boolean bIsDeleted=false; String sAcc_Rec=null; String sPro_Rec=null;String sContact_Rec=null;String sLoc_Rec=null;
	int iRecNum=0;
	
	@BeforeClass
	public void initialization()
	{
		restLib = new RestLib();
	}
	
	@Test(priority=1,enabled=true, description="DCDATA_01: To create data")
	public void accountTest() throws IOException 
	{
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "ACCOUNT_NUM"));
	for(int i=1;i<=iRecNum;i++) {
		sRefName="Acc_"+i; 
		sAccName=GenericLib.getExcelData("ACCOUNT",sRefName, "Name"); sBillingPostalCode=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingPostalCode"); sBillingStreet=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingStreet"); sShippingStreet=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingStreet"); sShippingPostalCode=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingPostalCode");
		sBillingCity=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingCity"); sBillingCountry=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingCountry"); sBillingState=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingState"); sCurrencyIsoCode=GenericLib.getExcelData("ACCOUNT",sRefName, "CurrencyIsoCode"); sIndustry=GenericLib.getExcelData("ACCOUNT",sRefName, "Industry");
		sShippingCity=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingCity"); sShippingCountry=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingCountry"); sShippingState=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingState"); sType=GenericLib.getExcelData("ACCOUNT",sRefName, "Type"); 
		sObjectApi = "Account?";
		sJsonData =  "{\"Name\": \""+sAccName+"\","
					+ "\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\","
					+ "\"Industry\":\""+sIndustry+"\","
					+ "\"Type\":\""+sType+"\","
					+ "\"BillingStreet\":\""+sBillingStreet+"\","
					+ "\"BillingCity\":\""+sBillingCity+"\","
					+ "\"BillingCountry\":\""+sBillingCountry+"\","
					+ "\"BillingState\":\""+sBillingState+"\","
					+ "\"BillingPostalCode\": \""+sBillingPostalCode+"\","
					+ "\"ShippingStreet\":\""+sShippingStreet+"\","
					+ "\"ShippingCity\":\""+sShippingCity+"\","
					+ "\"ShippingCountry\":\""+sShippingCountry+"\","
					+ "\"ShippingState\":\""+sShippingState+"\","
					+ "\"ShippingPostalCode\":\""+sShippingPostalCode+"\"}";
		sAcc_Rec=restLib.getObjectRecordID(sObjectApi,sJsonData);
		GenericLib.setExcelData("CONTACT", "Contact_"+i, "AccountID", sAcc_Rec);
		GenericLib.setExcelData("LOCATION", "Loc_"+i, "SVMXC__Account__c", sAcc_Rec);
		GenericLib.setExcelData("Case", "Case_"+i, "AccountID", sAcc_Rec);
		
	}
		}
	
	@Test(priority=2,enabled=true, description="DCDATA_02: To create product data")
	public void producttest() throws IOException
	{
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "PRODUCT_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Pro_"+i; 
			sProdName=GenericLib.getExcelData("PRODUCT",sRefName, "Name"); sProdCode=GenericLib.getExcelData("PRODUCT",sRefName, "ProductCode"); sProdCurrency=GenericLib.getExcelData("PRODUCT",sRefName, "CurrencyIsoCode"); sUnitMeasure=GenericLib.getExcelData("PRODUCT",sRefName, "UnitMeasure");
			sDescription=GenericLib.getExcelData("PRODUCT",sRefName, "Description"); sProdFamily=GenericLib.getExcelData("PRODUCT",sRefName, "Family");  
			sObjectApi = "Product2?";
			sJsonData =  "{\"Name\": \""+sProdName+"\","
						+ "\"ProductCode\":\""+sProdCode+"\","
						+ "\"CurrencyIsoCode\":\""+sProdCurrency+"\","
						+ "\"SVMXC__Unit_Of_Measure__c\":\""+sUnitMeasure+"\","
						+ "\"Description\":\""+sDescription+"\","
						+ "\"Family\":\""+sProdFamily+"\","
						+ "\"IsActive\":\""+true+"\"}";
						
			sPro_Rec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			}
		}
	
	@Test(priority=3,enabled=true, description="DCDATA_03: To create contact data")
	public void contacttest() throws IOException
	{
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "CONTACT_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Contact_"+i; 
			sSalutation=GenericLib.getExcelData("CONTACT",sRefName, "Salutation"); sFirstName=GenericLib.getExcelData("CONTACT",sRefName, "FirstName"); sLastName=GenericLib.getExcelData("CONTACT",sRefName, "LastName"); sAccName=GenericLib.getExcelData("CONTACT",sRefName, "AccountID");sMailingStreet=GenericLib.getExcelData("CONTACT",sRefName, "MailingStreet");
			sMailingCity=GenericLib.getExcelData("CONTACT",sRefName, "MailingCity"); sMailingState=GenericLib.getExcelData("CONTACT",sRefName, "MailingState"); sMailingCode=GenericLib.getExcelData("CONTACT",sRefName, "MailingPostalCode"); sMailingCountry=GenericLib.getExcelData("CONTACT",sRefName, "MailingCountry"); sCurrencyIsoCode=GenericLib.getExcelData("CONTACT",sRefName, "CurrencyIsoCode"); 
			sObjectApi = "Contact?";
			sJsonData =  "{\"Salutation\": \""+sSalutation+"\","
						+ "\"FirstName\":\""+sFirstName+"\","
						+ "\"LastName\":\""+sLastName+"\","
						+ "\"AccountId\":\""+sAccName+"\","
						+ "\"MailingStreet\":\""+sMailingStreet+"\","
						+ "\"MailingCity\":\""+sMailingCity+"\","
						+ "\"MailingState\":\""+sMailingState+"\","
						+ "\"MailingPostalCode\":\""+sMailingCode+"\","
						+ "\"MailingCountry\": \""+sMailingCountry+"\","
						+ "\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\"}";
			sContact_Rec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			GenericLib.setExcelData("Case", "Case_"+i, "ContactID", sContact_Rec);
			}
		}

	@Test(priority=4,enabled=true, description="DCDATA_04: To create location data")
	public void locationtest() throws IOException
	{
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "LOCATION_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Loc_"+i; 
			sRecordTypeId=GenericLib.getExcelData("LOCATION",sRefName, "RecordTypeId"); sLocName=GenericLib.getExcelData("LOCATION",sRefName, "LocName"); sAccName=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__Account__c"); sMailingStreet=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__Street__c");
			sMailingCity=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__City__c"); sMailingState=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__State__c"); sMailingCountry=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__Country__c"); sMailingCode=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__Zip__c"); sCurrencyIsoCode=GenericLib.getExcelData("LOCATION",sRefName, "CurrencyIsoCode"); 
			sObjectApi = "SVMXC__Site__c?";
			sJsonData =  "{\"RecordTypeId\": \""+sRecordTypeId+"\","
						+ "\"Name\":\""+sLocName+"\","
						+ "\"SVMXC__Account__c\":\""+sAccName+"\","
						+ "\"SVMXC__Street__c\":\""+sMailingStreet+"\","
						+ "\"SVMXC__City__c\":\""+sMailingCity+"\","
						+ "\"SVMXC__State__c\":\""+sMailingState+"\","
						+ "\"SVMXC__Country__c\":\""+sMailingCountry+"\","
						+ "\"SVMXC__Zip__c\":\""+sMailingCode+"\","
						+ "\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\"}";
			sLoc_Rec=restLib.getObjectRecordID(sObjectApi,sJsonData);}
			}
	
	@Test(priority=5,enabled=true, description="DCDATA_05: To create case data")
	public void casetest() throws IOException
	{
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "CASE_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Case_"+i; 
			sContact_Rec=GenericLib.getExcelData("CASE",sRefName, "ContactID"); sAcc_Rec=GenericLib.getExcelData("CASE",sRefName, "AccountID"); sDescription=GenericLib.getExcelData("CASE",sRefName, "Description"); sOrigin=GenericLib.getExcelData("CASE",sRefName, "Origin");
			sPriority=GenericLib.getExcelData("CASE",sRefName, "Priority"); sReason=GenericLib.getExcelData("CASE",sRefName, "Reason"); sStatus=GenericLib.getExcelData("CASE",sRefName, "Status"); sSubject=GenericLib.getExcelData("CASE",sRefName, "Subject"); sCurrencyIsoCode=GenericLib.getExcelData("CASE",sRefName, "CurrencyIsoCode"); 
			sObjectApi = "Case?";
			sJsonData =  "{\"ContactId\": \""+sContact_Rec+"\","
						+ "\"AccountId\":\""+sAcc_Rec+"\","
						+ "\"Description\":\""+sDescription+"\","
						+ "\"Origin\":\""+sOrigin+"\","
						+ "\"Priority\":\""+sPriority+"\","
						+ "\"Reason\":\""+sReason+"\","
						+ "\"Status\":\""+sStatus+"\","
						+ "\"Subject\":\""+sSubject+"\","
						+ "\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\"}";
			sCaseNum=restLib.getObjectRecordID(sObjectApi,sJsonData);
			GenericLib.setExcelData("Case", "Case_"+i, "CaseNumber", sCaseNum);
			}
			}

	@Test(priority=6,enabled=true, description="DCDATA_06: To create team data")
	public void createTeamtest() throws IOException
	{	iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "TEAM_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Team_"+i; 
			sRecordTypeId=GenericLib.getExcelData("TEAM",sRefName, "RecordTypeId"); sTeamName=GenericLib.getExcelData("TEAM",sRefName, "TeamName");sStreet=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Street__c"); sZip=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Zip__c");
			sCity=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__City__c"); sState=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__State__c"); sCountry=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Country__c"); sDescription=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Description__c"); sCurrencyIsoCode=GenericLib.getExcelData("TEAM",sRefName, "CurrencyIsoCode"); 
			sObjectApi = "SVMXC__Service_Group__c?";
			sJsonData =  "{\"RecordTypeId\": \""+sRecordTypeId+"\","
						+ "\"Name\":\""+sAcc_Rec+"\","
						+ "\"SVMXC__Street__c\":\""+sStreet+"\","
						+ "\"SVMXC__Zip__c\":\""+sZip+"\","
						+ "\"SVMXC__City__c\":\""+sCity+"\","
						+ "\"SVMXC__State__c\":\""+sState+"\","
						+ "\"SVMXC__Country__c\":\""+sCountry+"\","
						+ "\"SVMXC__Description__c\":\""+sDescription+"\","
						+ "\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\"}";
			sTeamRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			GenericLib.setExcelData("TEAM", "Team_"+i, "TeamID", sTeamRec);	
		}
	}

	@Test(priority=7,enabled=true, description="DCDATA_07: To create technician data")
	public void createTechtest() throws IOException
	{
		
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "TECH_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Tech_"+i; 
			sTeamRec=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__Service_Group__c"); sTechName=GenericLib.getExcelData("TECHNICIAN",sRefName, "Name");sStreet=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__Street__c"); sZip=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__Zip__c");
			sCity=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__City__c"); sState=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__State__c"); sCountry=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__Country__c"); 
			sObjectApi = "SVMXC__Service_Group_Members__c?";
			sJsonData =  "{\"SVMXC__Service_Group__c\": \""+sTeamRec+"\","
						+ "\"Name\":\""+sTechName+"\","
						+ "\"SVMXC__Street__c\":\""+sStreet+"\","
						+ "\"SVMXC__Zip__c\":\""+sZip+"\","
						+ "\"SVMXC__City__c\":\""+sCity+"\","
						+ "\"SVMXC__State__c\":\""+sState+"\","
						+ "\"SVMXC__Country__c\":\""+sCountry+"\","
						+ "\"SVMXC__Role__c\":\"Technician\","
						+ "\"SVMXC__Break_Type__c\":\"Time Window\","
						+ "\"SVMXC__Active__c\":\""+true+"\","
						+ "\"SVMXC__Enable_Scheduling__c\":\""+true+"\"}";
			sTechRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			GenericLib.setExcelData("TECHNICIAN", "Tech_"+i, "TechID", sTechRec);
			}
	}
}
