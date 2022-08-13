package com.acn.pages;

import com.acn.base.BasePage;
import com.acn.utils.JsonParser;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OAuthLoginPage extends BasePage {

	    //external OAuth login elements
		@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.Button")
		private WebElement signInContainer;
		
		@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.EditText")
		private WebElement usernameField;
		
		@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.EditText")
		private WebElement passwordField;
		
		@FindBy(id = "_com_liferay_login_web_portlet_LoginPortlet_login")
		private WebElement OAuthLoginButton;
		
		@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ONBOARDING_MENU_SCREEN_IPASS_CARD_BUTTON_I-PASS\"]/android.view.ViewGroup")
		private WebElement homepageMenu;
		
		@FindBy(xpath = "//android.widget.TextView[@text='Log In']")
		private WebElement btnLogin;

	    public static final int TIMEOUT = 60;
		
		
		public void setContext() {
			try {
				if(driver.getContext() != "WEBVIEW_chrome") {
					if(driver.getContextHandles().size() == 1) {
						Thread.sleep(6000);
					}
					driver.context("WEBVIEW_chrome");
					driver.getPageSource();
					System.out.println("Context: " + driver.getContext());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public boolean isDisplayed() {
			setContext();
			return wait.until(ExpectedConditions.visibilityOf(signInContainer)).isDisplayed();
		}

		public void typeName(String name) {
			wait.until(ExpectedConditions.visibilityOf(usernameField));
			usernameField.clear();
			usernameField.sendKeys(name);
		}

		public void typePassword(String password) {
			wait.until(ExpectedConditions.visibilityOf(passwordField));
			passwordField.clear();
			passwordField.sendKeys(password);
		}

		public void clickLoginButton() {
			wait.until(ExpectedConditions.visibilityOf(btnLogin));
			btnLogin.click();
		}
		
		public void login(String name, String password) {
			typeName(name);
			typePassword(password);
			clickLoginButton();
		}
		
		public void login(String user) {
			setContext();
			JSONObject userObj = new JSONObject(JsonParser.parse("loginUsers.json").getJSONObject(user).toString());
			typeName(userObj.getString("username"));
			typePassword(userObj.getString("password"));
			clickLoginButton();
		}
		
		public void clickHomepageMenu() {
			wait.until(ExpectedConditions.visibilityOf(homepageMenu));
			homepageMenu.click();
		}

		public void clickSignIn() {
			wait.until(ExpectedConditions.visibilityOf(signInContainer));
			signInContainer.click();
		}

}
