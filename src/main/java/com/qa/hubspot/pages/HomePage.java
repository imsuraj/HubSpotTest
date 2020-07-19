package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

import io.qameta.allure.Step;

public class HomePage extends BasePage{
	
	private WebDriver driver;

	By header = By.xpath("//div[@class='private-header__title private-page__title']");
	By accountName = By.xpath("//span[@class='account-name ']");

	By menuContact = By.id("nav-primary-contacts-branch");
	By subMenuContact = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	
	}
	
	
	//Page Actions 1
	@Step("Get homepage title")
	public String getHomePageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.Home_Page_Title, 10);
	}

	// Page Actions 
	@Step("Get homepage header")
	public String getHomePageHeaderText() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	@Step("Get logged in user name")
	public String getLoggedInUser() {
		if (elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}
	
	@Step("Go to contacts page")
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	@Step("Clickk on contacts link")
	public void clickOnContacts() {
		elementUtil.doClick(menuContact);
		elementUtil.doClick(subMenuContact);
	}

}
