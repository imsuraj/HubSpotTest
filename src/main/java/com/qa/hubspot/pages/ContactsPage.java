package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage {
	
	private WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	By header = By.xpath("//i18n-string[text()='Contacts']");
	By createContact = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary = By.xpath("(//span[text()='Create contact'])[last()]");
	By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=1]");
	
	
	public String getContactsPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.Contacts_Page_Title, 10);
	}
	
	
	public String getContactsPageHeaderText() {
		elementUtil.waitForElementToBeVisible(header, 10);
		return elementUtil.doGetText(header);
	}
	
	public void createContact(String email, String firstname, String lastname, String jobtitle) {
		elementUtil.clickWhenReady(createContact, 10);
		
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.firstName, firstname);
		elementUtil.doSendKeys(this.lastName, lastname);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementUtil.doSendKeys(this.jobTitle, jobtitle);
		
		elementUtil.doActionsClick(createContactSecondary);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.doActionsClick(contactsBackLink);
		
		
	}

}
