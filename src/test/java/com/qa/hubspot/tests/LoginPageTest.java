package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


//@Listeners(ExtentReportListener.class)

@Listeners(TestAllureListener.class)
@Epic("Epic - 101 : design login page with different features...")
@Story("US - 102 : design basic login page with singup, title and login form...")
public class LoginPageTest extends BaseTest {
	
	HomePage homePage;

	@Test(priority = 2)
	@Description("verify Login Page Title Test.....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + title);
		Assert.assertEquals(title, Constants.Login_Page_Title, "Login Page title does not matched..");
	}

	@Test(priority = 1)
	@Description("verify sugn up link test.....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "Sign Up link is not displayed");
	}

	@Test(priority = 3)
	@Description("verify Login Test.....")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Logged in user is :"+loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "login is not success.");

	}

}
