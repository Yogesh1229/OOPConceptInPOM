package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	WebDriver driver;
	WebDriverWait wait;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
	}

	// abstract methods:
	// Every page should have these methods

	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract WebElement getElement(By locator);

	public abstract void waitForElementPresent(By locator);

	public abstract void waitForPageTitle(String title);
	
	//This method will return an instance of page class

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
