Feature:Test the login feature
  Scenario Outline : verify the login with valid credentials
    Given start to open the web browser
    Given navigate to the web page
    When user enter <email_id> and <password>
    Then verify the dashboard page title
    Then logout the application
    Then close the application
    Examples:
      | email_id                       | password |
      | selenium_java_2023@yopmail.com | Java2023 |