Feature:feature to test the home page

  Scenario:Check the home page before the Login
    Given open the browser
    When verify home page title
    And clicks the sign_in button
    Then verify the login page title
    Then close the browser

  Scenario:Check to the login functionality
    Given open the browser
    When verify home page title
    And clicks the sign_in button
    Then verify the login page title
    Then login to the e_com web page
    Then click the the logout button
    Then verify home page title after logout
    Then close the browser

