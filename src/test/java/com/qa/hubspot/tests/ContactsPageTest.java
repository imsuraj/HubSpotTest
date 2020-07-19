package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest extends BaseTest {
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeClass
	public void ContactsSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	@Test(priority = 1)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("Home page title is: " + title);
		Assert.assertEquals(title, Constants.Contacts_Page_Title, "Contacts Page title does not matched..");
	}

	@Test(priority = 2)
	public void verifyContactsPageHeaderTest() {
		String header = contactsPage.getContactsPageHeaderText();
		System.out.println("HomePae header is: "+header);
		Assert.assertEquals(header, Constants.Contacts_Page_Header, "Contacts page header is not present");
	}
	//This is normal test to create a contact
	@Test(enabled = false)
	public void createContactTest() {
		contactsPage.createContact("surya.shah14141@gmail.com", "Suraj", "Anand", "Job");
	}
	
	
	@DataProvider
	public Object[][] getDataFromExcel() {
		Object data[][] = ExcelUtil.getTestData("contacts");
		return data;
	}
	
	
	@Test(priority = 3, dataProvider = "getDataFromExcel")
	public void createContactDDTest(String email, String firstname, String lastname, String jobtitle) {
		contactsPage.createContact(email, firstname, lastname, jobtitle);
	}
	
}
