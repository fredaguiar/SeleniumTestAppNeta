package com.appneta.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFactory {

	private volatile static WebDriver driver;
	private volatile static WebDriverWait wait;

	private WebDriverFactory() {
	}

	public static WebDriver getWebDriver()  {
		
		if (driver != null) {
			return driver;
		}

		synchronized (WebDriverFactory.class) {
			System.setProperty("webdriver.chrome.driver", ".\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 5, 1000);
			return driver;
		}
	}
	
	public static WebDriverWait getWebDriverWait() {		
		return wait;
	}

}
