package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{

	private By profileHeader = By.xpath("//div[contains(text(), 'Profile')]");

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public String getProfileHeader() {
		return getPageHeader(profileHeader);
	}
}
