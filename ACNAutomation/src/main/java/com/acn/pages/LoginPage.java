package com.acn.pages;

import com.acn.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {
	
	@AndroidFindBy(accessibility = "LOGIN_BUTTON")
	@iOSXCUITFindBy(accessibility = "LOGIN_BUTTON")
	private WebElement loginButton;
	
	@AndroidFindBy(accessibility = "LOGIN_FORGOT_USERNAME_LINK")
	@iOSXCUITFindBy(accessibility = "LOGIN_FORGOT_USERNAME_LINK")
	private WebElement forgotUserNameLink;
	
	@AndroidFindBy(accessibility = "LOGIN_FORGOT_PASSWORD_LINK")
	@iOSXCUITFindBy(accessibility = "LOGIN_FORGOT_PASSWORD_LINK")
	private WebElement forgotPasswordLink;
	
	@AndroidFindBy(accessibility = "LOGIN_SIGN_UP_LINK")
	@iOSXCUITFindBy(accessibility = "LOGIN_SIGN_UP_LINK")
	private WebElement signUpLink;
	
	public void clickLogin() {
		wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
	}
	
	public void clickForgotUsername() {
		wait.until(ExpectedConditions.visibilityOf(forgotUserNameLink)).click();
	}
	
	public void clickForgotPassword() {
		wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink)).click();
	}
	
	public void clickSignUp() {
		wait.until(ExpectedConditions.visibilityOf(signUpLink)).click();
	}
}
