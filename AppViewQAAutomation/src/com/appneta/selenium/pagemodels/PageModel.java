package com.appneta.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appneta.selenium.testng.WebDriverFactory;

public abstract class PageModel {

	protected final String FOOTER_LOGO = "footer-logo";
	protected final String MENU_APP_VIEW = ".//a[text()='AppView']";
	protected final String REMIND_ME = ".tlypageguide_ignore";
	
	protected WebDriver driver;
	protected WebDriverWait wait;

	protected PageModel() {
		this.driver = WebDriverFactory.getWebDriver();
		this.wait = WebDriverFactory.getWebDriverWait();
	}
	
	abstract public void loadPage();
	
	public void clickAppViewMenu() {
		PageElement elem = new PageElement(By.xpath(MENU_APP_VIEW));
		elem.click();
	}
	
	public void clickRemindMe() {
		PageElement elem = new PageElement(By.cssSelector(REMIND_ME));
		if (elem.isVisible()) {
			elem.click();
		}
	}

}