Feature:feature to test the e_com page
  Background:
    Given open the browser

  Scenario:Check the home page feature before the Login
    When verify home page title
    And clicks the sign_in button
    Then verify the login page title
    Then close the browser

  Scenario:Check the login feature
    When verify home page title
    And clicks the sign_in button
    Then verify the login page title
    Then login to the e_com web page
    Then click the the logout button
    Then verify home page title after logout
    Then close the browser



