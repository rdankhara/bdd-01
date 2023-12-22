@wordCounter
Feature: Counts min and max words from string

  Scenario Outline: Count min and max words
    Given When word counter receives <input>
    Then outcome should have <maxItemCount>, <maxName>, <min> and <minName>
    Examples:
      | input                                    | maxItemCount | maxName  | min | minName |
      | ""                                       | 0            | ""       | 0   | ""      |
      | "world"                                  | 1            | "world"  | 1   | "world" |
      | "apple is red, banana is yellow"         | 1            | "is"     | 4   | "apple" |
      | "apple is red, banana is yellow, yellow" | 2            | "yellow" | 3   | "apple" |

