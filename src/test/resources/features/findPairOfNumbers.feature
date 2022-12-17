Feature: Find Pairs of Numbers

  Scenario: As a developer I need to check whether provided collection has all numbers in pair
    Given an array of:
      | 1 |
      | 2 |
      | 3 |
      | 3 |
      | 2 |
      | 2 |
      | 2 |
      | 1 |
    When I check for pairs
    Then It should return true

  Scenario: Check for Array which does not contain pair
    Given an array of:
      | 1 |
      | 2 |
      | 3 |
      | 3 |
      | 2 |
      | 2 |
      | 1 |
      | 1 |
    When I check for pairs
    Then It should return false