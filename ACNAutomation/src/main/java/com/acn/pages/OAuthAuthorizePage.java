package com.acn.pages;

import com.acn.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class OAuthAuthorizePage extends BasePage {

	@FindBy(xpath = "//form[@name=\"_com_liferay_oauth2_provider_web_internal_portlet_OAuth2AuthorizePortlet_fm\"]")
	private WebElement authorizePage;
	
	@FindBy(xpath = "//button[@id=\"_com_liferay_oauth2_provider_web_internal_portlet_OAuth2AuthorizePortlet_allow\"]")
	private WebElement authorizeButton;
	
	@FindBy(xpath = "//button[@id=\"_com_liferay_oauth2_provider_web_internal_portlet_OAuth2AuthorizePortlet_cancel\"]")
	private WebElement cancelButton;
	
	public boolean isDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(authorizePage)).isDisplayed();
	}
	
	public void clickAuthorizeButton() {
		wait.until(ExpectedConditions.visibilityOf(authorizeButton)).click();
	}
	
	public void clickCancelButton() {
		wait.until(ExpectedConditions.visibilityOf(cancelButton)).click();
	}
	
}
