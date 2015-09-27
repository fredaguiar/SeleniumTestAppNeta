package com.appneta.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WebDashboardPageModel extends PageModel {

	private final String MENU_WEB_DASHBOARD = ".//a[text()='Web Dashboard']";
	private final String NEW_DASHBOARD = ".//button[@class='ui-button ui-button-success']";
	private final String ADD_APP = "plus";
	private final String SELECT_APP = "selectize-input items has-options full has-items";
	private final String SELECT_APP_NAME = ".//div[text()='%s']";
	private final String SELECT_USER_ACTION = "selectize-input items not-full has-options";
	private final String SELECT_USER_ACTION_NAME = ".//div[text()='%s']";
	private final String DONE = "dashboard-edit-done";
	
	@Override
	public void loadPage() {
		clickWebDashboardMenu();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FOOTER_LOGO)));
	}

	public void clickWebDashboardMenu() {
		PageElement elem = new PageElement(By.xpath(MENU_WEB_DASHBOARD));
		elem.click();
	}
	
	public void clickNewDashboardButton() {
		PageElement elem = new PageElement(By.xpath(NEW_DASHBOARD));
		elem.click();
	}
	
	public void addAnApp() {
		PageElement elem = new PageElement(By.cssSelector(ADD_APP));
		elem.click();
	}
	
	public void selectApp(String appName) {
		PageElement selectAppElem = new PageElement(By.cssSelector(SELECT_APP));
		selectAppElem.click();
		
		String appName2 = String.format(SELECT_APP_NAME, appName);
		PageElement selectNameElem = new PageElement(By.cssSelector(appName2));
		selectNameElem.click();
	}
	
	public void selectUserAction(String userAction) {
		PageElement selectUserActionElem = new PageElement(By.cssSelector(SELECT_USER_ACTION));
		selectUserActionElem.click();
		
		String userAction2 = String.format(SELECT_USER_ACTION_NAME, userAction);
		PageElement selectNameElem = new PageElement(By.cssSelector(userAction2));
		selectNameElem.click();
	}
	
	public void clickDone() {
		PageElement elem = new PageElement(By.id(DONE));
		elem.click();
	}
	
	public void createDashboard(String appName, String userAction){

		clickWebDashboardMenu();
		clickNewDashboardButton();
		selectApp(appName);
		selectUserAction(userAction);
		clickDone();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FOOTER_LOGO)));
	}
	
}