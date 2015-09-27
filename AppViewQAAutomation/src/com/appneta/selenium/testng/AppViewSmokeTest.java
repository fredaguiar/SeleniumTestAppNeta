package com.appneta.selenium.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appneta.selenium.pagemodels.LoginPageModel;
import com.appneta.selenium.pagemodels.WebApplicationsPageModel;
import com.appneta.selenium.pagemodels.WebDashboardPageModel;

public final class AppViewSmokeTest extends SeleniumTest {

	private static String _appnetaLogin = "https://signon.pv-st.appneta.com/signon/login.html";
	private String _appName;
	private String _userAction;

	@DataProvider
	public Object[][] authenticationData() {
		return new Object[][] { new Object[]{ 
				"testhouse@appneta.com",
				"@ppN3ta!"
				}};
	}
	
	@DataProvider
	public Object[][] webAppData() {
		return new Object[][] { new Object[]{ 
				WebApplicationsPageModel.APPLICATION_OPTION_GOOGLE_APPS,
				"Google Apps",
				"appUsername",
				"appPassword",
				"appEmail",
				"appEmailPassword",
				}};
	}
	
	@Test(dataProvider = "authenticationData")
	public void authenticationTest(
			String username, 
			String password
			) throws Exception {

		LoginPageModel loginPage = new LoginPageModel();
		loginPage.loadPage();
		loginPage.login(username, password);
	}
	
	@Test(dataProvider = "webAppData", dependsOnMethods="authenticationTest")
	public void webAppTest(
			String appOption,
			String appName,
			String appUsername, 
			String appPassword,
			String appEmail,
			String appEmailPassword
			) throws Exception {
		
		_appName = appendRandomID(appName);
		_userAction = appOption;

		WebApplicationsPageModel webAppPage = new WebApplicationsPageModel();
		webAppPage.loadPage();
		webAppPage.createWebApp(appOption, _appName, true, appEmail, appEmailPassword);
	}
	
	@Test(dependsOnMethods="webAppTest")
	public void webDashboardTest() throws Exception {

		WebDashboardPageModel webDashboardPage = new WebDashboardPageModel();
		webDashboardPage.loadPage();
		webDashboardPage.createDashboard(_appName, _userAction);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
	}

}
