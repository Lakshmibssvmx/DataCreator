package com.dc.datacreator.tests;

import java.io.IOException;
import java.sql.Timestamp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.dc.datacreator.lib.GenericLib;
import com.dc.datacreator.lib.RestLib;

public class EventTest 
{
	RestLib restLib=null;
	String sRefName=null; 
	String sName=null; String sWOName=null; String sZip=null; String sActivityDatetime=null; String sActivityDate=null; String sDescription=null; String sDrivingTime=null;
	String sDrivingTimeHome=null;String sDuration=null; String sStartTime=null; String sEndTime=null; boolean bAllDay=false; String sOHTimeBefore=null;
	String sOHTimeAfter=null; String sServiceDuration=null; String sWORecID=null; String sStatus=null; String sTechRec=null; String sType=null; 
	String sObjectApi=null; String sJsonData = null; String sAccRec=null; String sTeam=null; int iTechNum=0;
	int iRecNum=0;
	
	@BeforeClass
	public void initialization() throws IOException
	{
		restLib = new RestLib();
		restLib.getOauthAccessToken();
	}
	
	@Test(priority=0,enabled=true, description="DCDATA_01: To create data")
	public void eventTest() throws IOException 
	{	
		Timestamp ts=new Timestamp(System.currentTimeMillis());  
		String sDate=java.time.LocalDate.now().toString();
		System.out.println(sDate);  
		iRecNum=Integer.parseInt(GenericLib.getConfigValue(GenericLib.sConfigFile, "TEAM_DATA"));
		sObjectApi="SVMXC__SVMX_Event__c?";
		
		for(int k=1; k<=iRecNum; k++) {
		sTeam=GenericLib.getExcelData("TEAM_DATA", "TD_"+k, "Team");
		iTechNum=Integer.parseInt(GenericLib.getExcelData("TEAM_DATA", "TD_"+k, "TechNum"));
		
		for(int i=1;i<=iTechNum;i++) {
		sWOName=GenericLib.getExcelData("WORKORDER", "WO_"+i, "Name");
		sZip=GenericLib.getExcelData("WORKORDER", "WO_"+i, "SVMXC__Zip__c");
		sWORecID=GenericLib.getExcelData("WORKORDER", "WO_"+i, "WO_RecID");
		sTechRec=GenericLib.getExcelData(sTeam, "Tech_"+i, "TechID");
		for(int j=1;j<=5;j++) {
		
		sActivityDatetime=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__ActivityDateTime__c");
		sDrivingTime=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__Driving_Time__c");
		sDrivingTimeHome=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__Driving_Time_Home__c");
		sDuration=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__DurationInMinutes__c");
		sStartTime=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__StartDateTime__c");
		sEndTime=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__EndDateTime__c");
		//String bAllDay=GenericLib.getExcelData("EVENT", "Event_1", "SVMXC__IsAllDayEvent__c");
		//=(Boolean)obj;
		sOHTimeBefore=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__Overhead_Time_Before__c");
		sOHTimeAfter=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__Overhead_Time_After__c");
		sServiceDuration=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__Service_Duration__c");
		sStatus=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__SM_Status__c");
		sType=GenericLib.getExcelData("EVENT", "Event_"+j, "SVMXC__Type__c");
	
		sJsonData="{\"Name\":\""+sWOName+" "+sZip+" "+"Event_"+j+"\","
				+ "\"SVMXC__ActivityDateTime__c\":\""+sDate+sActivityDatetime+"\","
				+ "\"SVMXC__ActivityDate__c\":\""+sDate+"\","
				+ "\"SVMXC__Description__c\":\""+"Description for "+sWOName+"Event_"+j+"\","
				+ "\"SVMXC__Driving_Time__c\":\""+sDrivingTime+"\","
				+ "\"SVMXC__Driving_Time_Home__c\": \""+sDrivingTimeHome+"\","
				+ "\"SVMXC__DurationInMinutes__c\":\""+sDuration+"\","
				+ "\"SVMXC__StartDateTime__c\":\""+sDate+sStartTime+"\","
				+ "\"SVMXC__EndDateTime__c\":\""+sDate+sEndTime+"\","
				+ "\"SVMXC__IsAllDayEvent__c\":\""+false+"\","
				+ "\"SVMXC__Overhead_Time_Before__c\":\""+sOHTimeBefore+"\","
				+ "\"SVMXC__Overhead_Time_After__c\":\""+sOHTimeAfter+"\","
				+ "\"SVMXC__Service_Duration__c\":\""+sServiceDuration+"\","
				+ "\"SVMXC__Service_Order__c\":\""+sWORecID+"\","
				+ "\"SVMXC__SM_Status__c\":\""+sStatus+"\","
				+ "\"SVMXC__Technician__c\":\""+sTechRec+"\","
				+ "\"SVMXC__WhatId__c\":\""+sWORecID+"\","
				+ "\"SVMXC__Type__c\":\""+sType+"\"}";
		sAccRec=restLib.getObjectRecordID(sObjectApi,sJsonData);
	}}}	
	}
}

