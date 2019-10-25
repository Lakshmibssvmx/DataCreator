/*
 * @author: LAKSHMI BS 
 * Description: Implementation of java reusable methods across the project
 */
package com.dc.datacreator.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class GenericLib 
{
	//Initialization of files & folders globally
	public static String sDirPath = System.getProperty("user.dir");
	public static String sResources = sDirPath+"//resources";
	public static String sTestDataFile = sResources + "//DCData.xlsx";
	public static String sConfigFile =  sResources+"//config.properties";
	public int iRowNum=0;
	public static String sChromeDriverPath =  sResources+"//drivers//chromedriver";
	public static String sGeckoDriverPath =  sResources+"//drivers//geckodriver";
	public static int iVHighSleep=40000;
	public static int iHighSleep=20000;
	public static int iMedSleep=10000;
	public static int iLowSleep=3000;
	/*
	 * @author: LAKSHMI BS 
	 * Description: To read test data from excel sheet
	 */
	public static String getExcelData(String sModuleSheet, String sTestCaseID, String sKey) throws IOException {
		String sData = null;
		FileInputStream fis = new FileInputStream(sTestDataFile);
		
		try {

			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sModuleSheet);
			int iRowNum = sht.getLastRowNum();
			
			for (int i = 1; i <= iRowNum; i++) {
				//System.out.println("_______ "+iRowNum);
				if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
					//System.out.println(sht.getRow(i).getCell(0));
					
					int iCellNum = sht.getRow(i).getLastCellNum();
					for(int j=0;j<iCellNum;j++)
					{
						if(sht.getRow(0).getCell(j).getStringCellValue().equals(sKey))
							{
							sData = sht.getRow(i).getCell(j).getStringCellValue();
							break;}
				
					}
					break;
				}
			}
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		fis.close();
		return sData;
	}
	/*
	 * @author: LAKSHMI BS 
	 * Description: To write data into excel sheet
	 */
	public static void setExcelData(String sModuleSheet, String sTestCaseID, String sKey, String sValue) throws IOException {
	
		FileInputStream fis = null;
		FileOutputStream fos =null;
		try {

			fis = new FileInputStream(sTestDataFile);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sModuleSheet);
			int iRowNum = sht.getLastRowNum();
			
			for (int i = 1; i <= iRowNum; i++) {
				try {
				if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
					int iCellNum = sht.getRow(i).getLastCellNum();
					for(int j=0;j<iCellNum;j++)
					{	
						if(sht.getRow(0).getCell(j).getStringCellValue().equals(sKey))
							{
							sht.getRow(i).createCell(j).setCellValue(sValue);
							}
					}
					break;
				
			}}catch(Exception e) {}}
		
			fos = new FileOutputStream(sTestDataFile);
			wb.write(fos);
			
			wb.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		fos.close();
		
	}
	
	/*
	 * @author: LAKSHMI BS 
	 * Description: To read the basic environment settings or org data from config.properties
	 * 
	 */
	public static String getConfigValue(String sFile, String sKey) {
		Properties prop = new Properties();
		String sValue = null;
		try {
			InputStream input = new FileInputStream(sFile);
			prop.load(input);
			sValue = prop.getProperty(sKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sValue;
	}

	/*
	 * @author: LAKSHMI BS
	 * Description: This method is used to generate times stamped with current time which can be used as random number
	 */
	public static String getUniqueNumber() {

		String sTimeStamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(System.currentTimeMillis());
		return sTimeStamp;
	}

	public static void main(String[] args) throws IOException 
	{
		System.out.println(GenericLib.getExcelData("ACCOUNT", "Acc_1", "Name"));
		//GenericLib.setExcelData("PRT", "RS_2389", "TeamName","Lakshmi");
		}

	
}

