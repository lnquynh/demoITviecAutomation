/**
 * 
 */
package com.itviec.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author Quynh Lai
 *
 */
public class BaseTest {
	public static String driverMacPath = System.getProperty("user.dir")+ "/selenium_driver/chromedriver";
	public static String driverWinPath = System.getProperty("user.dir")+ "\\selenium_driver\\chromedriver.exe";
	
	protected WebDriver driver;
	
	@BeforeClass
	public void setUp () {
		String os = System.getProperty("os.name").toLowerCase();
		driver = new ChromeDriver();
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", driverMacPath);
		}else {
			System.setProperty("webdriver.chrome.driver", driverWinPath);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		if (driver !=null) {
			driver.close();
			driver.quit();
		}
	}
}
