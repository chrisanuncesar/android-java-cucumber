Feature: Login
  As a user, I must be able to Login in the mobile app

  @TC.004
  Scenario: Login_LogInScreen_LogInButton_FirstTimeLogin
    Given Mobile PbP App is launched
    When I enter "MobileTesting4" in the username field
    When I enter "!Testmobile1" in the password field
    And I click login button
    #And I click OAuth login button
    #Then External login page is displayed
    #When I login with "admin" credentials
    #And I click Authorize button in the authorize page
    #Then Authorize page is displayed
