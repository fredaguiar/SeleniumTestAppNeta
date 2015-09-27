package com.appneta.selenium.testng;

import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*
 * Basic parent class to be extend by test classes.
 * It starts, maximizes the browser and shut it down. 
 */
public abstract class SeleniumTest {
	
	protected static WebDriver driver;

	@BeforeClass()
	public void beforeClass() throws Exception {
		
		driver = WebDriverFactory.getWebDriver();
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {		
		driver.quit();
	}
	
	// Appends a unique to a string in order to prevent name collisions during parallel testing
	public static String appendRandomID(String prefix)throws Exception {
		String randomString = UUID.randomUUID().toString().substring(0, 5);
		return prefix + randomString;
	}

}
