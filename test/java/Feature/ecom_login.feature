Feature:feature to test the home page

  Scenario:Check the home page before the Login
    Given open the browser
    When verify home page title
    And clicks the sign_in button
    Then verify the login page title
    Then close the browser
