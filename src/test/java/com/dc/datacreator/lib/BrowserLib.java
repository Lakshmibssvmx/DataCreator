/*
 * @author: LAKSHMI BS 
 * Description: To initialise the browser configured from the configure properties file
 */
package com.dc.datacreator.lib;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserLib {
	public WebDriver driver = null;
	
	/*
	 * @author: LAKSHMI BS 
	 * Description: To launch the browser configured from the configure properties file before every Tests configured in testng.xml file
	 */
	@BeforeTest
	public void launchBrowser() throws Exception { 
		try {
			if (GenericLib.getConfigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", GenericLib.sChromeDriverPath);
				System.out.println("Chrome browser is set");
				driver = new ChromeDriver();
			} else if (GenericLib.getConfigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", GenericLib.sGeckoDriverPath);
				System.out.println("Firefox is set");
				driver = new FirefoxDriver();
			} else {
				System.out.println("Failed to Launch the browser");
			}
			
			loadURL(GenericLib.getConfigValue(GenericLib.sConfigFile, "URL"));
			} 
		
		
		catch (Exception e) {
			System.out.println("Trouble in launching browser");
			throw e;
		}
	}

	/*
	 * @author: LAKSHMI BS 
	 * Description: To load needed URL of org configured from the configure properties 
	 */
	
	public void loadURL(String sURL) throws InterruptedException {
		try {
			driver.get(sURL);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(5000);
		} catch (AssertionError e) {
			throw e;
		}
		
	}
	
	/*
	 * @author: LAKSHMI BS 
	 * Description: To quit the browser.
	 */
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
