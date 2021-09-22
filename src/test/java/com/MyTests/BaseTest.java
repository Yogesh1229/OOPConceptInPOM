package com.MyTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.AbstractPage;
import com.mypages.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	public AbstractPage abstractPage;
	
	@BeforeMethod
	//@Parameters(value={"browser"})
	@Parameters("Browser")
	public void setUpTest(String browser) {
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else {
			System.out.println("No browser is defined in xml file...");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.get("https://demoqa.com/login");
		
		//This is the most important line
		//From here, we will send the driver to abstract page which will supply the driver to all page classes
		//Now we can create an object of abstract class so that's why we'll send it through child class constructor
		
		abstractPage = new BasePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
