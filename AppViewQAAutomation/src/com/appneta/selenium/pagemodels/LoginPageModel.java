package com.appneta.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageModel extends PageModel {

	private final String LOGIN_URL = "https://signon.pv-st.appneta.com/signon/login.html";
	private final String LOGIN_BUTTON_ID = "login-button";
	private final String USER_ID_TEXT = "username-input";
	private final String PASSWORD_TEXT = "j_password";
	private final String FOOTER_POWEREDBY = "powered-by";

	public void loadPage() {
		driver.get(LOGIN_URL);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FOOTER_POWEREDBY)));
	}

	public void clickLoginButton() {
		PageElement elem = new PageElement(By.id(LOGIN_BUTTON_ID));
		elem.click();
	}
	
	public void fillInUsername(String username) {
		PageElement elem = new PageElement(By.id(USER_ID_TEXT));
		elem.fillInText(username);
	}
	
	public void fillInPassword(String password) {
		PageElement elem = new PageElement(By.name(PASSWORD_TEXT));
		elem.fillInText(password);
	}

	public void login(String username, String password) {

		fillInUsername(username);
		fillInPassword(password);
		clickLoginButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FOOTER_LOGO)));
	}

}