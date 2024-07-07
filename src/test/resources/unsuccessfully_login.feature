Feature: Unsuccessful Login

  Scenario: User logs in with invalid credentials
    Given The user is on the login page
    When The user enters invalid username and password
    And The user clicks the login button
    Then The user should see an error message