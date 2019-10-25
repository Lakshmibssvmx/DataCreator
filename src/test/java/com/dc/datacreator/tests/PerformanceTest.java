package com.dc.datacreator.tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.dc.datacreator.lib.GenericLib;

public class PerformanceTest extends BaseTest
{
	@Test(priority=1,enabled=true, description="DCH_01: To filter based on priority and validate the assigned status of a wo")
	public void passtest() throws Exception
	{	
		
		
		
		try {
		//Launching DC
		dc_salesforcePo.naviagateDC();
		dc_schedulergridPo.getEleReloadDataBtn().click();
		Thread.sleep(GenericLib.iLowSleep);
		System.out.println("CLicked on Reload");
		dc_schedulergridPo.getEleContainsTxtFld().sendKeys("High");
		Thread.sleep(GenericLib.iLowSleep);
		
		dc_schedulergridPo.getEleNewChkBx().click();
		Thread.sleep(GenericLib.iLowSleep);
		
		}
		catch(Exception e) {
			throw e;
		}
		
	}
	
	
}
