package com.appneta.selenium.pagemodels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appneta.selenium.testng.WebDriverFactory;

public class PageElement {

	private WebDriver driver;
	private WebDriverWait wait;
	private By by;
	
	public PageElement(By by) {
		
		this.driver = WebDriverFactory.getWebDriver();
		this.wait = WebDriverFactory.getWebDriverWait();
		this.by = by;
	}
	
	public void explicitWait() {
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public boolean isVisible() {
		WebElement elmt = getElement();
		return elmt!=null && elmt.isDisplayed();
	}

	private WebElement getElement() {
		int numberOfAttemptsToWait = 5;
		int currentAttempt = 1;
		List<WebElement> elements = null;

		while (currentAttempt < numberOfAttemptsToWait) {

			elements = this.driver.findElements(by);
			if (elements.size() > 0 && elements.get(0).isDisplayed()) {
				return elements.get(0);
			}
			System.out.println("attempt % " + currentAttempt);
			currentAttempt++;
		}

		return null;
	}

	public void click() {
		WebElement btn = this.wait.until(ExpectedConditions.elementToBeClickable(by));
		btn.click();
	}

	public void fillInText(String textToFill) {
		WebElement inptTxt = this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		inptTxt.clear();
		inptTxt.sendKeys(textToFill);
	}

}
