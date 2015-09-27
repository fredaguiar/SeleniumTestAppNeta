package com.appneta.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WebApplicationsPageModel extends PageModel {

	private final String MENU_WEB_APPLICATIONS = ".//a[text()='Web Applications']";
	private final String ADD_WEB_APP_BUTTON = "addPathButton";
	private final String APPLICATION = ".//select[@class='ember-view ember-select input-xlarge']";
	private final String APPLICATION_OPTION = ".//option[text()='%s']";
	private final String NAME = "apn-input-name";
	private final String TARGET_URL = "apn-target-URL-checkbox";
	private final String EMAIL = ".//input[@class='ember-view ember-text-field input-medium']";
	private final String PASSWORD = ".//input[@type='password']";
	private final String SAVE = "apn-button-save";
	private final String APPLICATION_NAME = ".//h4[text()='%s']";
	
	// application types
	public static final String APPLICATION_OPTION_GOOGLE_APPS = "Google Apps";

	@Override
	public void loadPage() throws Exception {
		clickAppViewMenu();
		clickWebApplicationMenu();
		clickRemindMe();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FOOTER_LOGO)));
	}

	public void clickWebApplicationMenu() {
		PageElement elem = new PageElement(By.xpath(MENU_WEB_APPLICATIONS));
		elem.click();
	}
	
	public void clickAddWebAppButton() {
		PageElement elem = new PageElement(By.id(ADD_WEB_APP_BUTTON));
		elem.click();
	}
	
	public void selectApplication(String applicationOption) throws InterruptedException {
		PageElement elem = new PageElement(By.xpath(APPLICATION));
		elem.click();
		
		String option = String.format(APPLICATION_OPTION, applicationOption);
		PageElement elem2 = new PageElement(By.xpath(option));
		elem2.click();
	}
	
	public void fillInName(String name) {
		PageElement elem = new PageElement(By.name(NAME));
		elem.fillInText(name);
	}
	
	public void clickTargetUrl() {
		PageElement elem = new PageElement(By.name(TARGET_URL));
		elem.click();
	}
	
	public void fillInEmail(String email) {
		PageElement elem = new PageElement(By.xpath(EMAIL));
		elem.fillInText(email);
	}
	
	public void fillInPassword(String password) {
		PageElement elem = new PageElement(By.xpath(PASSWORD));
		elem.fillInText(password);
	}
	
	public void clickSave() {
		PageElement elem = new PageElement(By.name(SAVE));
		elem.click();
	}
	
	public void createWebApp(String appOption, String name, boolean targetUrl, 
		String email, String password) throws InterruptedException {
		
		clickAddWebAppButton();
		selectApplication(appOption);
		fillInName(name);
		if (targetUrl){
			clickTargetUrl();
		}
		fillInEmail(email);
		fillInPassword(password);
		
		clickSave();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FOOTER_LOGO)));
	}
	
	public boolean verifyAppNameExists (String appName) {
		
		String appName2 = String.format(APPLICATION_NAME, appName);
		PageElement elem = new PageElement(By.xpath(appName2));
		return elem.verifyElementExists();
	}

}