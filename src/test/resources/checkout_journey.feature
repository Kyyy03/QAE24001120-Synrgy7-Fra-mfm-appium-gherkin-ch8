Feature: Checkout Journey

  Scenario: User completes checkout process
    Given The user is logged in
    When The user adds items to the cart
    And The user proceeds to checkout
    And The user enters shipping information
    And The user completes the checkout
    Then The user should see the order confirmation