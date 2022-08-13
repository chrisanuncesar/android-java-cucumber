package com.acn.steps;

import com.acn.base.DriverManager;
import com.acn.pages.LoginPage;
import com.acn.pages.OAuthAuthorizePage;
import com.acn.pages.OAuthLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    @Given("^Mobile PbP App is launched$")
    public void mobile_pbp_app_is_launched() throws Exception {
        assertNotNull(DriverManager.getDriver());
        OAuthLoginPage oAuthLogin = new OAuthLoginPage();
        oAuthLogin.clickHomepageMenu();
        oAuthLogin.clickLoginButton();
    }

    @When("I enter {string} in the username field")
    public void i_enter_username_in_the_username_field(String username) throws InterruptedException {
        System.out.println("Username: " + username);
        OAuthLoginPage oAuthLogin = new OAuthLoginPage();
        oAuthLogin.typeName(username);
    }

    @When("I enter {string} in the password field")
    public void i_enter_password_in_the_password_field(String password) throws InterruptedException {
        System.out.println("Password :" + password);
        OAuthLoginPage oAuthLogin = new OAuthLoginPage();
        oAuthLogin.typePassword(password);
    }

    @When("I click login button")
    public void i_click_login_button() {
        System.out.println("Login");
        OAuthLoginPage oAuthLogin = new OAuthLoginPage();
        oAuthLogin.clickSignIn();
    }

    @When("^I click OAuth login button$")
    public void i_click_oauth_login_button(){
        OAuthLoginPage oAuthLogin = new OAuthLoginPage();
        oAuthLogin.clickLoginButton();
    }

    @Then("^External login page is displayed$")
    public void external_login_page_is_displayed() {
        OAuthLoginPage oAuthLogin = new OAuthLoginPage();
        oAuthLogin.isDisplayed();
    }

    @When("I login with {string} credentials")
    public void i_login_with_user_credentials(String user) {
        LoginPage login = new LoginPage();
        login.clickLogin();

        OAuthLoginPage oAuthLogin = new OAuthLoginPage();
        oAuthLogin.login(user);

        OAuthAuthorizePage oAuthAuthorize = new OAuthAuthorizePage();
        oAuthAuthorize.clickAuthorizeButton();
    }

    @When("^I click Authorize button in the authorize page$")
    public void i_click_authorize_button_in_the_authorize_page() {
        OAuthAuthorizePage oAuthAuthorize = new OAuthAuthorizePage();
        oAuthAuthorize.clickAuthorizeButton();
    }

    @Then("^Authorize page is displayed$")
    public void authorize_page_is_displayed() throws Throwable {
        OAuthAuthorizePage oAuthAuthorize = new OAuthAuthorizePage();
        assertTrue(oAuthAuthorize.isDisplayed());
    }
}
