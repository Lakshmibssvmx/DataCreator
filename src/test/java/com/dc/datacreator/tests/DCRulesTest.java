package com.dc.datacreator.tests;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.dc.datacreator.lib.GenericLib;
import com.dc.datacreator.lib.RestLib;

public class DCRulesTest 
{
	RestLib restLib=null;
	String sRefName=null; String sObjectApi=null; String sJsonData=null; String sRuleRec=null;
	String sName=null; String sRuleType=null; String sRecordType=null; String sDesc=null;
	int iRecNum=0;
	
	@BeforeClass
	public void initialization()
	{
		restLib = new RestLib();
	}
	
	@Test(priority=1,enabled=true, description="DCRULE_01: To create event hover rule")
	public void eventHovertest() throws IOException
	{	sObjectApi = "SVMXC__ServiceMax_Processes__c?";
		sJsonData =  "{\"SVMXC__Name__c\":\""+"Order Status Medium"+"\","
					+ "\"SVMXC__Rule_Type__c\":\""+"Event Hover Rule"+"\","
					//+ "\"SVMXC__Record_Type_Name__c\":\""+"SVMX Rule"+"\","
					+ "\"SVMXC__Description__c\":\""+"Order Status Medium"+"\"}";
				sRuleRec=restLib.getObjectRecordID(sObjectApi,sJsonData);

		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "EHOVER_NUM"));
		for(int i=1;i<=iRecNum;i++) {
			sRefName="EHOVER_"+i; 
			sName=GenericLib.getExcelData("EVENTHOVER",sRefName, "Name"); 
			sObjectApi = "SVMXC__ServiceMax_Processes__c?";
			sJsonData =  "{\"SVMXC__Name__c\":\""+"Order Status low"+"\","
						+ "\"SVMXC__Rule_Type__c\":\""+"Event Hover Rule"+"\","
						+ "\"SVMXC__Record_Type_Name__c\":\""+"0121F0000001QMBQA2"+"\","
						+ "\"SVMXC__Description__c\":\""+sName+"\"}";
			sRuleRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			GenericLib.setExcelData("EVENTHOVER", "EHOVER_"+i, "ProcessID", sRuleRec);
			}
		/*
		for(int i=1;i<=iRecNum;i++) {
			sRefName="Tech_"+i; 
			sTeamRec=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__Service_Group__c"); sTechName=GenericLib.getExcelData("TECHNICIAN",sRefName, "Name");sStreet=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__Street__c"); sZip=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__Zip__c");
			sCity=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__City__c"); sState=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__State__c"); sCountry=GenericLib.getExcelData("TECHNICIAN",sRefName, "SVMXC__Country__c"); 
			sObjectApi = "SVMXC__ServiceMax_Config_Data__c?";
			sJsonData =  "{\"RecordTypeId\": \""+"0121F0000001QLcQAM"+"\","
						+ "\"SVMXC__Expression_Type__c\":\""+"DISP_Event_Hover_Rule"+"\","
						+ "\"SVMXC__Field_Name__c\":\""+"SVMXC__Order_Status__c"+"\","
						+ "\"SVMXC__Operator__c\":\""+"eq"+"\","
						+ "\"SVMXC__Operand__c\":\""+"Open"+"\"}";
			sTechRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
			GenericLib.setExcelData("TECHNICIAN", "Tech_"+i, "TechID", sTechRec);
			}*/
		
	}
}
