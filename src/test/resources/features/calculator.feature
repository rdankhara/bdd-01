@calculator
Feature: Calculator
  Scenario: Adding two numbers
    Given I have a calculator
    When I add 10 and 20
    Then I should get 30
