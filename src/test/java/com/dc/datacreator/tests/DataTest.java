package com.dc.datacreator.tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
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
	String sCaseRec=null; String sOrigin=null; String sPriority=null; String sReason=null; String sStatus=null; String sSubject=null;
	String sTeamName=null; String sStreet=null;String sZip=null; String sCity=null; String sState=null; String sCountry=null; String sTeamRec=null;
	String sTechName=null; 	String sTechRec=null;
	String sDispRec=null; String sSqlQuery=null;
	String sWoObjectID=null;String sWOName=null; String sVisit=null; String sSchOptions=null; String sEstDuration=null; String sAge=null; String sBillingType=null;String sLongitude=null; String sLatitude=null;
	String sObjectApi=null; String sJsonData = null; Boolean bIsDeleted=false; String sAccRec=null; String sProRec=null;String sContactRec=null;String sLocRec=null;
	int iRecNum=0; int iTechNum=0;
	
	@BeforeClass
	public void initialization() throws IOException
	{
		restLib = new RestLib();
		restLib.getOauthAccessToken();
	}
	
	@Test(priority=1,enabled=false, description="DCDATA_01: To create data")
	public void accountTest() throws IOException, InterruptedException 
	{	
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "ACCOUNT_NUM"));
		for(int i=1;i<=iRecNum;i++) 
		{	sRefName="Acc_"+i; 
		sAccName=GenericLib.getExcelData("ACCOUNT",sRefName, "Name"); sBillingPostalCode=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingPostalCode"); sBillingStreet=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingStreet"); sShippingStreet=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingStreet"); sShippingPostalCode=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingPostalCode");
		sBillingCity=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingCity"); sBillingCountry=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingCountry"); sBillingState=GenericLib.getExcelData("ACCOUNT",sRefName, "BillingState"); sCurrencyIsoCode=GenericLib.getExcelData("ACCOUNT",sRefName, "CurrencyIsoCode"); sIndustry=GenericLib.getExcelData("ACCOUNT",sRefName, "Industry");
		sShippingCity=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingCity"); sShippingCountry=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingCountry"); sShippingState=GenericLib.getExcelData("ACCOUNT",sRefName, "ShippingState"); sType=GenericLib.getExcelData("ACCOUNT",sRefName, "Type"); 
		System.out.println(sAccName);
		sObjectApi = "Account?";
		sJsonData =  "{\"Name\":\""+sAccName+"\","
					+ "\"BillingStreet\":\""+sBillingStreet+"\","
					+ "\"BillingCity\":\""+sBillingCity+"\","
					+ "\"BillingCountry\":\""+sBillingCountry+"\","
					+ "\"BillingState\":\""+sBillingState+"\","
					+ "\"BillingPostalCode\": \""+sBillingPostalCode+"\","
					+ "\"ShippingStreet\":\""+sShippingStreet+"\","
					+ "\"ShippingCity\":\""+sShippingCity+"\","
					+ "\"ShippingCountry\":\""+sShippingCountry+"\","
					+ "\"ShippingState\":\""+sShippingState+"\"," 
					+ "\"ShippingPostalCode\":\""+sShippingPostalCode+"\","
			//		+ "\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\","
					+ "\"Industry\":\""+sIndustry+"\","
					+ "\"Type\":\""+sType+"\"}";
		sAccRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
		Thread.sleep(10000);
		GenericLib.setExcelData("ACCOUNT", "Acc_"+i, "Acc_Rec", sAccRec);Thread.sleep(2000);
		GenericLib.setExcelData("CONTACT", "Contact_"+i, "AccountID", sAccRec);Thread.sleep(2000);
		GenericLib.setExcelData("LOCATION", "Loc_"+i, "SVMXC__Account__c", sAccRec);Thread.sleep(2000); 
		GenericLib.setExcelData("Case", "Case_"+i, "AccountID", sAccRec);Thread.sleep(2000);
		}
	}
	
	@Test(priority=2,enabled=false, description="DCDATA_02: To create product data")
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
				//		+ "\"CurrencyIsoCode\":\""+sProdCurrency+"\","
						+ "\"SVMXC__Unit_Of_Measure__c\":\""+sUnitMeasure+"\","
						+ "\"Description\":\""+sDescription+"\","
						+ "\"Family\":\""+sProdFamily+"\","
						+ "\"IsActive\":\""+true+"\"}";
			sProRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			}
		}
	
	@Test(priority=3,enabled=false, description="DCDATA_03: To create contact data")
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
						+ "\"MailingCountry\": \""+sMailingCountry+"\"}";
					//	+ "\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\""
					//	+ "}";
			sContactRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			GenericLib.setExcelData("Case", "Case_"+i, "ContactID", sContactRec);
			}
		}

	@Test(priority=4,enabled=false, description="DCDATA_04: To create location data")
	public void locationtest() throws IOException
	{	sRecordTypeId=GenericLib.getConfigValue(GenericLib.sConfigFile, "LOCRECID"); 
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "LOCATION_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Loc_"+i; 
			sLocName=GenericLib.getExcelData("LOCATION",sRefName, "LocName"); sAccName=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__Account__c"); sMailingStreet=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__Street__c");
			sMailingCity=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__City__c"); sMailingState=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__State__c"); sMailingCountry=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__Country__c"); sMailingCode=GenericLib.getExcelData("LOCATION",sRefName, "SVMXC__Zip__c"); sCurrencyIsoCode=GenericLib.getExcelData("LOCATION",sRefName, "CurrencyIsoCode"); 
			sObjectApi = "SVMXC__Site__c?";
			sJsonData =  "{\"RecordTypeId\": \""+sRecordTypeId+"\","
						+ "\"Name\":\""+sLocName+"\","
						+ "\"SVMXC__Account__c\":\""+sAccName+"\","
						+ "\"SVMXC__Street__c\":\""+sMailingStreet+"\","
						+ "\"SVMXC__City__c\":\""+sMailingCity+"\","
						+ "\"SVMXC__State__c\":\""+sMailingState+"\","
						+ "\"SVMXC__Country__c\":\""+sMailingCountry+"\","
						+ "\"SVMXC__Zip__c\":\""+sMailingCode+"\"}";
					//	+ "\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\""
					//	+ "}";
			sLocRec=restLib.getObjectRecordID(sObjectApi,sJsonData);}
			}
	
	@Test(priority=5,enabled=false, description="DCDATA_05: To create case data")
	public void casetest() throws IOException
	{	
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "CASE_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Case_"+i; 
			sContactRec=GenericLib.getExcelData("CASE",sRefName, "ContactID"); sAccRec=GenericLib.getExcelData("CASE",sRefName, "AccountID"); sDescription=GenericLib.getExcelData("CASE",sRefName, "Description"); sOrigin=GenericLib.getExcelData("CASE",sRefName, "Origin");
			sPriority=GenericLib.getExcelData("CASE",sRefName, "Priority"); sReason=GenericLib.getExcelData("CASE",sRefName, "Reason"); sStatus=GenericLib.getExcelData("CASE",sRefName, "Status"); sSubject=GenericLib.getExcelData("CASE",sRefName, "Subject"); sCurrencyIsoCode=GenericLib.getExcelData("CASE",sRefName, "CurrencyIsoCode"); 
			sObjectApi = "Case?";
			sJsonData =  "{\"ContactId\": \""+sContactRec+"\","
						+ "\"AccountId\":\""+sAccRec+"\","
						+ "\"Description\":\""+sDescription+"\","
						+ "\"Origin\":\""+sOrigin+"\","
						+ "\"Priority\":\""+sPriority+"\","
						+ "\"Reason\":\""+sReason+"\","
						+ "\"Status\":\""+sStatus+"\","
						+ "\"Subject\":\""+sSubject+"\"}";
					//	+ "\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\""
					//	+ "}";
			sCaseRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			GenericLib.setExcelData("Case", "Case_"+i, "CaseNumber", sCaseRec);
			}
			}

	@Test(priority=6,enabled=false, description="DCDATA_06: To create team data")
	public void createTeamtest() throws IOException
	{	sRecordTypeId=GenericLib.getConfigValue(GenericLib.sConfigFile, "TEAMRECID"); 
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "TEAM_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Team_"+i; 
			sTeamName=GenericLib.getExcelData("TEAM",sRefName, "TeamName");sStreet=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Street__c"); sZip=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Zip__c");
			sCity=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__City__c"); sState=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__State__c"); sCountry=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Country__c"); sDescription=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Description__c"); 
			sCurrencyIsoCode=GenericLib.getExcelData("TEAM",sRefName, "CurrencyIsoCode"); sLatitude=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Latitude__c"); sLongitude=GenericLib.getExcelData("TEAM",sRefName, "SVMXC__Longitude__c"); 
			sObjectApi = "SVMXC__Service_Group__c?";
			sJsonData =  "{\"RecordTypeId\": \""+sRecordTypeId+"\","
						+ "\"Name\":\""+sTeamName+"\","
						+ "\"SVMXC__Street__c\":\""+sStreet+"\","
						+ "\"SVMXC__Zip__c\":\""+sZip+"\","
						+ "\"SVMXC__City__c\":\""+sCity+"\","
						+ "\"SVMXC__State__c\":\""+sState+"\","
						+ "\"SVMXC__Country__c\":\""+sCountry+"\","
						+ "\"SVMXC__Description__c\":\""+sDescription+"\"}";
					//	+"\"CurrencyIsoCode\":\""+sCurrencyIsoCode+"\","
					//	+"\"SVMXC__Latitude__c\":\""+sLastName+"\","
					//	+ "\"SVMXC__Longitude__c\":\""+sLongitude+"\"}";
			sTeamRec=restLib.getObjectRecordID(sObjectApi, sJsonData);
			GenericLib.setExcelData("TEAM", "Team_"+i, "TeamID", sTeamRec);	
			GenericLib.setExcelData("TEAM_DATA", "TD_"+i, "TeamRecID", sTeamRec);

		}
	}

	@Test(priority=7,enabled=true, description="DCDATA_07: To create technician data")
	public void createTechtest() throws IOException
	{
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "TEAM_DATA"));
		for(int k=2; k<=iRecNum; k++) 
		{
		sTeamName=GenericLib.getExcelData("TEAM_DATA", "TD_"+k, "Team");
		iTechNum=Integer.parseInt(GenericLib.getExcelData("TEAM_DATA", "TD_"+k, "TechNum"));
		sTeamRec=GenericLib.getExcelData("TEAM_DATA","TD_"+k, "TeamRecID");
		
		for(int i=51;i<=iTechNum;i++) {
			sRefName="Tech_"+i; 
			sTechName=GenericLib.getExcelData(sTeamName,sRefName, "Name");sStreet=GenericLib.getExcelData(sTeamName,sRefName, "SVMXC__Street__c"); sZip=GenericLib.getExcelData(sTeamName,sRefName, "SVMXC__Zip__c");
			sCity=GenericLib.getExcelData(sTeamName,sRefName, "SVMXC__City__c"); sState=GenericLib.getExcelData(sTeamName,sRefName, "SVMXC__State__c"); sCountry=GenericLib.getExcelData(sTeamName,sRefName, "SVMXC__Country__c"); 
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
			GenericLib.setExcelData(sTeamName, "Tech_"+i, "TechID", sTechRec);
		}}
	}
	
	@Test(priority=8,enabled=false, description="DCDATA_08: To create technician data")
	public void addDispatcher() throws IOException
	{
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile,"TEAM_DATA"));
		for(int k=1; k<=iRecNum; k++) 
		{	sRefName="TD_"+k;
			sDispRec=GenericLib.getExcelData("TEAM_DATA", sRefName, "DispRecID");
			sTeamRec=GenericLib.getExcelData("TEAM_DATA", sRefName, "TeamRecID");
			
			sObjectApi = "SVMXC__Dispatcher_Access__c?";
			sJsonData =  "{\"SVMXC__Dispatcher__c\": \""+sDispRec+"\","
						+ "\"SVMXC__Service_Team__c\":\""+sTeamRec+"\"}";
			sTechRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			
		}
	}
	
	@Test(priority=9,enabled=false, description="DCDATA_09: To create WorkORder data")
	public void createWorkOrder() throws IOException
	{
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "WO_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="WO_"+i;
			sAccRec=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Company__c"); sContactRec=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Contact__c"); sCaseRec=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Case__c"); 
			sStreet=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Street__c");sZip=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Zip__c"); sState=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__State__c"); sCity=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__City__c"); sCountry=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Country__c"); 
			sVisit=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Purpose_of_Visit__c"); sPriority=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Priority__c"); sDescription=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Problem_Description__c"); sStatus=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Order_Status__c"); 
			sType=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Order_Type__c"); sSchOptions=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__SM_Scheduling_Options__c"); sEstDuration=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__SM_Estimated_Duration__c"); 
			sAge=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Age__c"); sBillingType=GenericLib.getExcelData("WORKORDER", sRefName, "SVMXC__Billing_Type__c"); 
			sObjectApi = "SVMXC__Service_Order__c?";
			sJsonData =  "{\"SVMXC__Company__c\":\""+sAccRec+"\","
						+ "\"SVMXC__Contact__c\":\""+sContactRec+"\","
						+ "\"SVMXC__Case__c\":\""+sCaseRec+"\","
						+ "\"SVMXC__Street__c\":\""+sStreet+"\","
						+ "\"SVMXC__Zip__c\":\""+sZip+"\","
						+ "\"SVMXC__State__c\":\""+sState+"\","
						+ "\"SVMXC__City__c\":\""+sCity+"\","
						+ "\"SVMXC__Country__c\":\""+sCountry+"\","
						+ "\"SVMXC__Purpose_of_Visit__c\":\""+sVisit+"\","
						+ "\"SVMXC__Priority__c\":\""+sPriority+"\","
						+ "\"SVMXC__Order_Status__c\":\""+sStatus+"\","
						+ "\"SVMXC__Order_Type__c\":\""+sType+"\","
						+ "\"SVMXC__SM_Scheduling_Options__c\":\""+sSchOptions+"\","
						+ "\"SVMXC__SM_Estimated_Duration__c\":\""+sEstDuration+"\","
				//		+ "\"CurrencyIsoCode\":\"USD\","
						+ "\"SVMXC__Billing_Type__c\":\""+sBillingType+"\"}";
			sWoObjectID=restLib.getObjectRecordID(sObjectApi,sJsonData);
			sWOName =restLib.getObjectName("SVMXC__Service_Order__c",sWoObjectID); 
			GenericLib.setExcelData("WORKORDER", "WO_"+i, "Name", sWOName);	
			GenericLib.setExcelData("WORKORDER", "WO_"+i, "WO_RecID", sWoObjectID);	
		}
	}
	
}
