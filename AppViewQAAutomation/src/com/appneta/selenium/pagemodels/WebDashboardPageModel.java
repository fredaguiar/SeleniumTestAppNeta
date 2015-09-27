package com.appneta.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WebDashboardPageModel extends PageModel {

	private final String MENU_WEB_DASHBOARD = ".//a[text()='Web Dashboard']";
	private final String NEW_DASHBOARD = ".//button[@class='ui-button ui-button-success']";
	private final String DASHBOARD_NAME = ".dashboard-name";
	private final String ADD_APP = ".plus";
	private final String SELECT_APP = ".//div[@class='selectize-input items not-full']";
	private final String SELECT_APP_NAME = ".//div[text()='%s']";
	private final String SELECT_USER_ACTION = ".//div[@class='selectize-input items not-full has-options']";
	private final String SELECT_USER_ACTION_NAME = ".//div[text()='%s']";
	private final String DONE = "dashboard-edit-done";
	private final String DASHBOARD_NAME_CSS = ".dashboard-name";
	
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
	
	public void addAnApp(String appName) throws InterruptedException {
		PageElement addElem = new PageElement(By.cssSelector(ADD_APP));
		addElem.click();
		
		PageElement selectAppElem = new PageElement(By.xpath(SELECT_APP));
		selectAppElem.click();
		
		String appName2 = String.format(SELECT_APP_NAME, appName);
		PageElement selectNameElem = new PageElement(By.xpath(appName2));
		selectNameElem.click();
		
		Thread.sleep(2000);
	}
	
	public void selectUserAction(String userAction) {
		PageElement selectUserActionElem = new PageElement(By.xpath(SELECT_USER_ACTION));
		selectUserActionElem.click();
		
		String userAction2 = String.format(SELECT_USER_ACTION_NAME, userAction);
		PageElement selectNameElem = new PageElement(By.xpath(userAction2));
		selectNameElem.click();
	}
	
	public void clickDone() {
		PageElement elem = new PageElement(By.id(DONE));
		elem.click();
	}
	
	public void createDashboard(String dashboardName, String appName, String userAction) throws InterruptedException{

		clickNewDashboardButton();
		fillInDashboardName(dashboardName);
		addAnApp(appName);
		//selectUserAction(userAction);
		clickDone();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FOOTER_LOGO)));
	}
	
	public void fillInDashboardName(String dashboardName) {
		PageElement elem = new PageElement(By.cssSelector(DASHBOARD_NAME));
		elem.fillInText(dashboardName);
	}
	
	public boolean verifyDashboardNameExists (String dashboardName) {
		
		WebElement elem = driver.findElement(By.cssSelector(DASHBOARD_NAME_CSS));
		String txt = elem.getText();
		if(txt != null) {
			return txt.contains(dashboardName);
		}
		return false;
	}
	
}