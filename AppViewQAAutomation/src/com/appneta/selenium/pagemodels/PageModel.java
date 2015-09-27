package com.appneta.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appneta.selenium.testng.WebDriverFactory;

public abstract class PageModel {

	protected final String FOOTER_LOGO = "footer-logo";
	protected final String MENU_APP_VIEW = ".//a[text()='AppView']";
	protected final String REMIND_ME = ".tlypageguide_ignore";
	protected final String ACTION = ".//span[text()='Action']";
	protected final String DELETE = "apn-option-delete";
	
	protected WebDriver driver;
	protected WebDriverWait wait;

	protected PageModel() {
		this.driver = WebDriverFactory.getWebDriver();
		this.wait = WebDriverFactory.getWebDriverWait();
	}
	
	abstract public void loadPage() throws Exception;
	
	public void clickAppViewMenu() {
		PageElement elem = new PageElement(By.xpath(MENU_APP_VIEW));
		elem.click();
	}
	
	public void clickRemindMe() throws Exception {
		
		try {
			Thread.sleep(2000);
			PageElement elem = new PageElement(By.cssSelector(REMIND_ME));		
			boolean visible = elem.isVisible();
			if (visible) {
				elem.click();
				Thread.sleep(2000);
			}
		}
		catch(Exception ex) {
			// swallow any exception, seeing that RemindMe is a bit unpredictable 
		}
	}

}