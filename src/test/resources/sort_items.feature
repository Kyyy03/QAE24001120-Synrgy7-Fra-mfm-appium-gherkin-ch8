Feature: Sort Items

  Scenario: User sorts items by price from low to high
    Given The user is logged in
    When The user sorts items by price from low to high
    Then The items should be sorted by price from low to high