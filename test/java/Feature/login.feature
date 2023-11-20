#@SmokeFeature
Feature:feature to test Login functionality
  #@smoketest
  Scenario:Check Login is successful with Valid credentials
    Given user enters into login page
    When user Enter Username and password
    And click the login button
    Then user is navigated to the home page