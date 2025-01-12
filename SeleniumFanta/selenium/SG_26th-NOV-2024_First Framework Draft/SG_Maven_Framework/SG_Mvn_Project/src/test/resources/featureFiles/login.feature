Feature: Automating Login page Functionality

  @Regression @SmokeTest
  Scenario: Verify login functionality with valid credentials
    Given verify user navigates the URL
      | appURL                    |
      | http://localhost:81/login.do |
    And verify user enters valid credentials
      | userName | password |
      | admin    | manager  |
    And verify user logout from the application
