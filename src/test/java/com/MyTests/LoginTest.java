package com.MyTests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.LoginPage;
import com.mypages.ProfilePage;

public class LoginTest extends BaseTest {

	ProfilePage profilePage;
	Logger log = Logger.getLogger(LoginTest.class);

	@Test(priority = 1, enabled = true)
	public void verifyLoginPageTitleTest() {
		log.info("Login page title test");
		LoginPage loginPage = abstractPage.getInstance(LoginPage.class);
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login title: " + title);
		Assert.assertEquals(title, "ToolsQA");
	}
//	
	@Test(priority = 2)
	public void verifyLoginPageHeaderTest() {
		log.info("Login page header test");
		LoginPage loginPage = abstractPage.getInstance(LoginPage.class);
		String header = loginPage.getLoginHeader();
		System.out.println("Login header: " + header);
		Assert.assertEquals(header, "Login");
	}
//	
//	@Test(priority = 3, enabled = true)
//	public void doLoginTest() {
//		log.info("Do login test");
//		LoginPage loginPage = abstractPage.getInstance(LoginPage.class);
//		profilePage = loginPage.doLogin("test1234", "#T123est?");
//		String header = profilePage.getProfileHeader();
//		System.out.println("Profile header: " + header);
//		Assert.assertEquals(header, "Profile");
//	}
}
