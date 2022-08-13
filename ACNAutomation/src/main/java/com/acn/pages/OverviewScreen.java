package com.acn.pages;

import java.util.List;

import com.acn.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class OverviewScreen extends BasePage {

	
	@AndroidFindBy(accessibility = "OVERVIEW_CARD_DETAILS_LABEL_AMOUNT")
	private WebElement pendingTollsAmount;
	
	@AndroidFindBy(accessibility = "OVERVIEW_MANAGE_PAYMENT_METHOD_BUTTON")
	private WebElement managePaymentButton;
	
	@AndroidFindBy(accessibility = "OVERVIEW_CARD_DETAILS_LABEL_ACCOUNT_ID")
	private WebElement accountId;
	
	@AndroidFindBy(accessibility = "OVERVIEW_ADD_VEHICLE_BUTTON_WARNING_MESSAGE")
	private WebElement noPrimaryVehiclesErrorMessage;
	
	@AndroidFindBy(accessibility = "OVERVIEW_MANAGE_PAYMENT_METHOD_BUTTON")
	private WebElement addPaymentMethodButton;
	
	@AndroidFindBy(accessibility = "OVERVIEW_CARD_DETAILS_LABEL_AMOUNT")
	private List<WebElement> recentActivities;

	public void setContext() {
		if(driver.getContext() != "NATIVE_APP") {
			driver.context("NATIVE_APP"); 
			driver.getPageSource();
			System.out.println("Context: " + driver.getContext());
		}
	}
	
	public Boolean isDisplayed() {
		setContext();
		return wait.until(ExpectedConditions.visibilityOf(pendingTollsAmount)).isDisplayed();
	}
	
	public String accountId() {
		return wait.until(ExpectedConditions.visibilityOf(accountId)).getText();
	}
	
	public Boolean addPaymentMethodButtonIsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(addPaymentMethodButton)).isDisplayed();
	}
	
}
