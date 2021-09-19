package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	// Page locators using By:
	private By userName = By.id("userName");
	private By password = By.id("password");
	private By loginBtn = By.id("login");
	private By loginHeader = By.className("main-header");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// As all variables are private and we cannot use them out of this class
	// So we'll create getters
	// Concept of ENCAPSULATION (How to access private variables using public
	// variables)

	public WebElement getUserName() {
		return getElement(userName);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public String getLoginHeader() {
		return getPageHeader(loginHeader);
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public ProfilePage doLogin(String username, String pwd) {
		getUserName().sendKeys(username);
		getPassword().sendKeys(pwd);
		getLoginBtn().click();
		
		return getInstance(ProfilePage.class);
	}
}
