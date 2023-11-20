Feature:Login Page Test
  @smoke_1
  Scenario:Check the login features
    Given navigate to the home page and click the Signin btn
    When user enters valid email_id with password
    And verify the dash board page title
    Then logout the e_com application

