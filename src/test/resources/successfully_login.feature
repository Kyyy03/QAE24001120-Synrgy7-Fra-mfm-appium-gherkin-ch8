Feature: Successful Login

  Scenario: User logs in with valid credentials
    Given The user is on the login page
    When The user enters valid username and password
    And The user clicks the login button
    Then The user should see the products page