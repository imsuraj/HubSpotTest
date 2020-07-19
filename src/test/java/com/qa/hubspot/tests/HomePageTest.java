package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(TestAllureListener.class)
@Epic("Epic - 103 : Home page with different features...")
@Story("US - 104 : design basic home page with header, title and .....")
public class HomePageTest extends BaseTest {
	
	HomePage homePage;
	
	
	@BeforeClass
	public void homeSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	@Description("Verify HomePage title test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title, "Home Page title does not matched..");
	}
	
	
	@Test(priority = 2)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify Homepage header test")
	public void verifyHomePageHeaderTest() {
		String header = homePage.getHomePageHeaderText();
		System.out.println("HomePage header is: "+header);
		Assert.assertEquals(header, Constants.Home_Page_Header, "Home page header is not present");
	}
	
	@Test(priority = 3)
	@Description("Verify logged in user test.")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyLoggedInUserTest() {
		String accountName = homePage.getLoggedInUser();
		System.out.println("Logged in user is : "+accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"), "logged in user does not matched");
	}
}
