@score
Feature: Breaking Best and Worst Score

  Scenario Outline: Count best and worst score break
    Given when user plays game with <scores>
    Then they should see <max> and <min>
    Examples:
      | scores                 | max | min |
      | 10,5,20,20,4,5,2,25,1  | 2   | 4   |
      | 10,10,20,20,4,5,2,25,1 | 2   | 3   |
